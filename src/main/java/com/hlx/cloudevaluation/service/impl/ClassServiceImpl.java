package com.hlx.cloudevaluation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hlx.cloudevaluation.dao.UserDao;
import com.hlx.cloudevaluation.exception.error.ApiException;
import com.hlx.cloudevaluation.exception.error.ClassErrorEnum;
import com.hlx.cloudevaluation.mapper.ClassRoleMapper;
import com.hlx.cloudevaluation.mapper.ClassUserMapper;
import com.hlx.cloudevaluation.mapper.SysClassMapper;
import com.hlx.cloudevaluation.model.dto.*;
import com.hlx.cloudevaluation.model.po.*;
import com.hlx.cloudevaluation.model.vo.*;
import com.hlx.cloudevaluation.service.ClassService;
import com.hlx.cloudevaluation.util.RandomUtil;
import com.hlx.cloudevaluation.util.StringUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ClassServiceImpl implements ClassService {

    private SysClassMapper sysClassMapper;

    private ModelMapper modelMapper;

    private ClassRoleMapper classRoleMapper;

    private ClassUserMapper classUserMapper;

    private UserDao userDao;

    @Autowired
    public ClassServiceImpl(SysClassMapper sysClassMapper, ClassUserMapper classUserMapper,
                            ClassRoleMapper classRoleMapper, UserDao userDao,
                            ModelMapper modelMapper) {
        this.sysClassMapper = sysClassMapper;
        this.classUserMapper = classUserMapper;
        this.classRoleMapper = classRoleMapper;
        this.modelMapper = modelMapper;
        this.userDao = userDao;
    }

    @Override
    public void update(ClassUpdateDTO classUpdateDTO, Integer userId) {
        SysClass sysClass = modelMapper.map(classUpdateDTO, SysClass.class);
        sysClass.setClassUpdateAt(new Date());
        sysClassMapper.updateByPrimaryKeySelective(sysClass);
    }

    @Override
    public void delete(Integer classId, Integer userId) {
        SysClassExample example = new SysClassExample();
        SysClassExample.Criteria criteria = example.createCriteria();
        criteria.andClassIdEqualTo(classId);
        SysClass sysClass = new SysClass();
        sysClass.setClassExist(false);
        sysClass.setClassUpdateAt(new Date());
        sysClass.setClassDeleteAt(new Date());

        sysClassMapper.updateByExampleSelective(sysClass, example);
    }

    @Override
    public void auth(ClassAuthDTO classAuthDTO, Integer userId) {
        Integer stuOrAssistant = classAuthDTO.getAuthCode();
        if (stuOrAssistant.equals(0)) {
            ClassUserExample example = new ClassUserExample();
            ClassUserExample.Criteria criteria = example.createCriteria();

            //通过token拿class_id
            SysClassExample classExample = new SysClassExample();
            SysClassExample.Criteria classCriteria = classExample.createCriteria();
            classCriteria.andClassStuTokenEqualTo(classAuthDTO.getToken());
            Integer classId = sysClassMapper.selectByExample(classExample).get(0).getClassId();
            criteria.andClassIdEqualTo(classId);
            criteria.andUserIdEqualTo(userId);
            if (classUserMapper.selectByExample(example).size() > 0) {
                //学生已在这个班级,不用再添加
                throw new ApiException(ClassErrorEnum.EXIST_IN_CLASS_ROLE);
            }
            //学生
            ClassUser classUser = modelMapper.map(classAuthDTO, ClassUser.class);
            classUser.setCuCreateAt(new Date());
            classUser.setUserId(userId);
            classUserMapper.insertSelective(classUser);

            ClassRole student = new ClassRole();
            student.setUserId(userId);
            student.setRoleName("student");
            student.setClassId(classId);
            classRoleMapper.insertSelective(student);
        } else {
            //助教
            SysClassExample classExample = new SysClassExample();
            SysClassExample.Criteria classCriteria = classExample.createCriteria();
            classCriteria.andClassAssistantTokenEqualTo(classAuthDTO.getToken());

            ClassRoleExample example = new ClassRoleExample();
            ClassRoleExample.Criteria criteria = example.createCriteria();
            Integer classId = sysClassMapper.selectByExample(classExample).get(0).getClassId();
            criteria.andClassIdEqualTo(classId);
            criteria.andUserIdEqualTo(userId);
            if (classRoleMapper.selectByExample(example).size() > 0) {
                //权限已添加
                throw new ApiException(ClassErrorEnum.EXIST_IN_CLASS_ROLE);
            }
            ClassRole assist = new ClassRole();
            assist.setClassId(classId);
            assist.setUserId(userId);
            assist.setRoleName("assistant");
            classRoleMapper.insertSelective(assist);
        }
    }

    @Override
    public ClassSearchVO search(ClassSearchDTO classSearchDTO, Integer userId) {
        Integer pageNum = classSearchDTO.getPageNum();
        Integer pageSize = classSearchDTO.getPageSize();
        PageHelper.startPage(pageNum, pageSize);

        ClassRoleExample classRoleExample = new ClassRoleExample();
        ClassRoleExample.Criteria criteria = classRoleExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<ClassRole> classRoleList = classRoleMapper.selectByExample(classRoleExample);

        PageInfo<ClassRole> pageInfo = new PageInfo<>(classRoleList);

        List<SysClass> classList = new ArrayList<>();
        for (ClassRole item : classRoleList) {
            SysClassExample sysClassExample = new SysClassExample();
            SysClassExample.Criteria classCriteria = sysClassExample.createCriteria();
            classCriteria.andClassIdEqualTo(item.getClassId());
            if (StringUtil.isNotEmpty(classSearchDTO.getClassName())) {
                classCriteria.andClassNameLike("%" + classSearchDTO.getClassName() + "%");
            }
            List<SysClass> sysClassListItem = sysClassMapper.selectByExample(sysClassExample);
            if (sysClassListItem.size() > 0) {
                classList.add(sysClassListItem.get(0));
            }
        }
        ClassSearchVO classSearchVO = new ClassSearchVO();
        classSearchVO.setPageNum(pageInfo.getPageNum());
        classSearchVO.setMaxPageNum(pageInfo.getPages());

        List<ClassVO> classVOList = modelMapper.map(
                classList, new TypeToken<List<ClassVO>>() {
                }.getType());
        classSearchVO.setClassVOList(classVOList);

        return classSearchVO;
    }

    @Override
    public ClassDetailVO getDetail(ClassGetDetailDTO detailDTO, Integer userId) {
        Set<Integer> classSet = new HashSet<>();
        ClassRoleExample roleExample = new ClassRoleExample();
        ClassRoleExample.Criteria roleCriteria = roleExample.createCriteria();
        roleCriteria.andUserIdEqualTo(userId);
        List<ClassRole> classRoleList = classRoleMapper.selectByExample(roleExample);
        for (ClassRole classRole : classRoleList) {
            classSet.add(classRole.getClassId());
        }
        if (!classSet.contains(detailDTO.getClassId())) {
            throw new ApiException(ClassErrorEnum.CLASS_ID_INVALID);
        }

        SysClass sysClass = sysClassMapper.selectByPrimaryKey(detailDTO.getClassId());
        ClassDetailVO classDetailVO = modelMapper.map(sysClass, ClassDetailVO.class);

        ClassUserExample classUserExample = new ClassUserExample();
        ClassUserExample.Criteria classUserCriteria = classUserExample.createCriteria();
        classUserCriteria.andClassIdEqualTo(detailDTO.getClassId());
        List<ClassUser> classUserList = classUserMapper.selectByExample(classUserExample);

        List<ClassUserVO> classUserVOList = new ArrayList<>();
        for (ClassUser classUser : classUserList) {
            User user = userDao.get(classUser.getUserId());
            ClassUserVO classUserVO = modelMapper.map(classUser, ClassUserVO.class);
            classUserVO.setUserAccount(user.getUserAccount());
            classUserVO.setUserName(user.getUserName());
            classUserVO.setUserId(user.getUserId());
            classUserVOList.add(classUserVO);
        }
        classDetailVO.setClassUserVOList(classUserVOList);

        return classDetailVO;
    }

    @Override
    public void add(ClassAddDTO classAddDTO, Integer userId) {
        SysClass sysClass = modelMapper.map(classAddDTO, SysClass.class);
        sysClass.setClassCreator(userId);
        sysClass.setClassCreateAt(new Date());
        sysClass.setClassAssistantToken(RandomUtil.get());
        sysClass.setClassStuToken(RandomUtil.get());
        sysClass.setClassTeamEdit(true);
        sysClass.setClassExist(true);
        sysClassMapper.insertSelective(sysClass);

        ClassRole classRole = new ClassRole();
        classRole.setClassId(sysClass.getClassId());
        classRole.setUserId(userId);
        classRole.setRoleName("teacher");
        classRoleMapper.insert(classRole);
    }
}