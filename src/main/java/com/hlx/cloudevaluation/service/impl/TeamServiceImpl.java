package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.dao.UserDao;
import com.hlx.cloudevaluation.exception.error.ApiException;
import com.hlx.cloudevaluation.exception.error.TeamErrorEnum;
import com.hlx.cloudevaluation.mapper.ClassUserMapper;
import com.hlx.cloudevaluation.mapper.SysTeamMapper;
import com.hlx.cloudevaluation.mapper.TeamUserMapper;
import com.hlx.cloudevaluation.model.dto.TeamAddDTO;
import com.hlx.cloudevaluation.model.dto.TeamUpdateDTO;
import com.hlx.cloudevaluation.model.po.*;
import com.hlx.cloudevaluation.model.vo.ClassUserVO;
import com.hlx.cloudevaluation.model.vo.TeamDetailVO;
import com.hlx.cloudevaluation.service.TeamService;
import com.hlx.cloudevaluation.util.RandomUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private ModelMapper modelMapper;

    private TeamUserMapper teamUserMapper;

    private SysTeamMapper sysTeamMapper;

    private ClassUserMapper classUserMapper;

    private UserDao userDao;

    @Autowired
    public TeamServiceImpl(ModelMapper modelMapper, TeamUserMapper teamUserMapper,
                           SysTeamMapper sysTeamMapper, ClassUserMapper classUserMapper,
                           UserDao userDao) {
        this.modelMapper = modelMapper;
        this.teamUserMapper = teamUserMapper;
        this.sysTeamMapper = sysTeamMapper;
        this.classUserMapper = classUserMapper;
        this.userDao = userDao;
    }

    @Override
    public String add(TeamAddDTO teamAddDTO, Integer userId) {
        SysTeam sysTeam = modelMapper.map(teamAddDTO, SysTeam.class);
        sysTeam.setTeamCaptain(userId);
        sysTeam.setTeamCreateAt(new Date());
        String token = RandomUtil.get();
        sysTeam.setTeamToken(token);

        ClassUserExample example = new ClassUserExample();
        ClassUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<ClassUser> classUserList = classUserMapper.selectByExample(example);
        if (classUserList.size() == 0) {
            //学生未加入班级
            throw new ApiException(TeamErrorEnum.ACTIVE_CLASS_NOT_EXIST);
        } else {
            sysTeam.setTeamClass(classUserList.get(0).getClassId());
        }
        sysTeam.setTeamExit(true);
        sysTeamMapper.insertSelective(sysTeam);
        return token;
    }

    @Override
    public void join(String token, Integer userId) {

    }

    @Override
    public TeamDetailVO getDetail(Integer userId) {
        // 获取团队id
        TeamUserExample teamUserExample = new TeamUserExample();
        TeamUserExample.Criteria teamUserCriteria = teamUserExample.createCriteria();
        teamUserCriteria.andUserIdEqualTo(userId);
        Integer teamId = teamUserMapper.selectByExample(teamUserExample).get(0).getTeamId();

        // 获取团队信息
        SysTeam sysTeam = sysTeamMapper.selectByPrimaryKey(teamId);
        TeamDetailVO teamDetailVO = modelMapper.map(sysTeam, TeamDetailVO.class);

        // 获取成员信息
        teamUserExample.clear();
        TeamUserExample.Criteria teamUserCriteria2 = teamUserExample.createCriteria();
        teamUserCriteria2.andTeamIdEqualTo(teamId);
        List<TeamUser> teamUserList = teamUserMapper.selectByExample(teamUserExample);
        List<ClassUserVO> classUserVOList = new ArrayList<>();

        for (TeamUser teamUser : teamUserList) {
            ClassUserExample classUserExample = new ClassUserExample();
            ClassUserExample.Criteria classUserCriteria = classUserExample.createCriteria();
            classUserCriteria.andUserIdEqualTo(teamUser.getUserId());
            ClassUser classUser = classUserMapper.selectByExample(classUserExample).get(0);

            User user = userDao.get(classUser.getUserId());
            ClassUserVO classUserVO = modelMapper.map(classUser, ClassUserVO.class);
            classUserVO.setUserAccount(user.getUserAccount());
            classUserVO.setUserName(user.getUserName());
            classUserVO.setUserId(user.getUserId());

            classUserVOList.add(classUserVO);
        }
        teamDetailVO.setClassUserVOList(classUserVOList);
        return teamDetailVO;
    }

    @Override
    public void update(TeamUpdateDTO teamUpdateDTO, Integer userId) {

    }

    @Override
    public void exit(Integer userId) {

    }
}
