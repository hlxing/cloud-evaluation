package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.exception.error.ApiException;
import com.hlx.cloudevaluation.exception.error.ClassErrorEnum;
import com.hlx.cloudevaluation.mapper.ClassRoleMapper;
import com.hlx.cloudevaluation.mapper.ClassUserMapper;
import com.hlx.cloudevaluation.mapper.SysClassMapper;
import com.hlx.cloudevaluation.model.dto.ClassAddDTO;
import com.hlx.cloudevaluation.model.dto.ClassAuthDTO;
import com.hlx.cloudevaluation.model.dto.ClassSearchDTO;
import com.hlx.cloudevaluation.model.dto.ClassUpdateDTO;
import com.hlx.cloudevaluation.model.po.*;
import com.hlx.cloudevaluation.model.vo.ClassSearchVO;
import com.hlx.cloudevaluation.service.ClassService;
import com.hlx.cloudevaluation.util.GetRandomToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClassServiceImpl implements ClassService {

    private SysClassMapper sysClassMapper;

    private ModelMapper modelMapper;

    private ClassRoleMapper classRoleMapper;

    private ClassUserMapper classUserMapper;

    @Autowired
    public ClassServiceImpl(SysClassMapper sysClassMapper, ClassUserMapper classUserMapper, ClassRoleMapper classRoleMapper, ModelMapper modelMapper) {
        this.sysClassMapper = sysClassMapper;
        this.classUserMapper = classUserMapper;
        this.classRoleMapper = classRoleMapper;
        this.modelMapper = modelMapper;
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
            criteria.andClassIdEqualTo(classAuthDTO.getClassID());
            criteria.andUserIdEqualTo(userId);
            if (classUserMapper.selectByExample(example).size() > 0) {
                //学生已在这个班级,不用再添加
                throw new ApiException(ClassErrorEnum.STU_EXIST);
            }
            //学生
            ClassUser classUser = new ClassUser();
            classUser.setClassId(classAuthDTO.getClassID());
            classUser.setCuCreateAt(new Date());
            classUser.setUserId(userId);
            classUserMapper.insert(classUser);
        } else {
            ClassRoleExample example = new ClassRoleExample();
            ClassRoleExample.Criteria criteria = example.createCriteria();
            criteria.andClassIdEqualTo(classAuthDTO.getClassID());
            criteria.andUserIdEqualTo(userId);
            if (classRoleMapper.selectByExample(example).size() > 0) {
                //权限已添加
                throw new ApiException(ClassErrorEnum.EXIST_IN_CLASS_ROLE);
            }
            ClassRole classRole = new ClassRole();
            classRole.setClassId(classAuthDTO.getClassID());
            classRole.setUserId(userId);
            classRole.setRoleName("助教");
            classRoleMapper.insert(classRole);
        }
    }

    @Override
    public ClassSearchVO search(ClassSearchDTO classSearchDTO, Integer userId) {
        return null;
    }

    @Override
    public void add(ClassAddDTO classAddDTO, Integer userId) {
        SysClass sysClass = modelMapper.map(classAddDTO, SysClass.class);
        sysClass.setClassCreator(userId);
        sysClass.setClassCreateAt(new Date());
        sysClass.setClassAssistantToken(GetRandomToken.getRandomToken());
        sysClass.setClassStuToken(GetRandomToken.getRandomToken());
        sysClassMapper.insertSelective(sysClass);
    }
}
