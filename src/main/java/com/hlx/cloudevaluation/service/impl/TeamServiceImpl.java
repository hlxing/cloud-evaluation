package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.dao.UserDao;
import com.hlx.cloudevaluation.exception.error.ApiException;
import com.hlx.cloudevaluation.exception.error.TeamErrorEnum;
import com.hlx.cloudevaluation.mapper.ClassUserMapper;
import com.hlx.cloudevaluation.mapper.SysClassMapper;
import com.hlx.cloudevaluation.mapper.SysTeamMapper;
import com.hlx.cloudevaluation.mapper.TeamUserMapper;
import com.hlx.cloudevaluation.model.dto.TeamAddDTO;
import com.hlx.cloudevaluation.model.dto.TeamUpdateDTO;
import com.hlx.cloudevaluation.model.po.*;
import com.hlx.cloudevaluation.model.vo.TeamDetailVO;
import com.hlx.cloudevaluation.model.vo.TeamUserVO;
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

    private SysClassMapper sysClassMapper;

    private UserDao userDao;

    @Autowired
    public TeamServiceImpl(ModelMapper modelMapper, TeamUserMapper teamUserMapper,
                           SysTeamMapper sysTeamMapper, ClassUserMapper classUserMapper,
                           SysClassMapper sysClassMapper, UserDao userDao) {
        this.modelMapper = modelMapper;
        this.teamUserMapper = teamUserMapper;
        this.sysTeamMapper = sysTeamMapper;
        this.classUserMapper = classUserMapper;
        this.sysClassMapper = sysClassMapper;
        this.userDao = userDao;
    }

    @Override
    public String add(TeamAddDTO teamAddDTO, Integer userId) {
        String teamName = teamAddDTO.getTeamName();
        SysTeamExample teamExample = new SysTeamExample();
        SysTeamExample.Criteria teamCri = teamExample.createCriteria();
        teamCri.andTeamNameEqualTo(teamName);
        if (sysTeamMapper.selectByExample(teamExample).size() > 0) {
            //团队名存在
            throw new ApiException(TeamErrorEnum.TEAM_NAME_EXIST);
        }

        SysTeam sysTeam = modelMapper.map(teamAddDTO, SysTeam.class);
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
            sysTeam.setTeamCaptain(userId);
        }

        sysTeam.setTeamExit(false);
        sysTeam.setTeamEdit(true);
        sysTeamMapper.insert(sysTeam);

        //队长创建团队后默认加入团队
        TeamUser teamUser = new TeamUser();
        teamUser.setUserId(userId);
        teamUser.setTeamId(sysTeam.getTeamId());
        teamUserMapper.insert(teamUser);

        return token;
    }

    @Override
    public void join(String token, Integer userId) {
        ClassUserExample example = new ClassUserExample();
        ClassUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<ClassUser> classUserList = classUserMapper.selectByExample(example);
        if (classUserList.size() == 0) {
            //学生未加入班级
            throw new ApiException(TeamErrorEnum.ACTIVE_CLASS_NOT_EXIST);
        }

        SysTeamExample tokenExample = new SysTeamExample();
        SysTeamExample.Criteria tokenCriteria = tokenExample.createCriteria();
        tokenCriteria.andTeamTokenEqualTo(token);
        List<SysTeam> teamList = sysTeamMapper.selectByExample(tokenExample);
        if (teamList.size() == 0) {
            //token无效
            throw new ApiException(TeamErrorEnum.TOKEN_INVALID);
        } else {
            Integer teamId = teamList.get(0).getTeamId();
            Integer max = teamList.get(0).getTeamLimit();
            SysTeamExample limitExample = new SysTeamExample();
            SysTeamExample.Criteria limitCriteria = limitExample.createCriteria();
            limitCriteria.andTeamIdEqualTo(teamId);
            List<SysTeam> limitList = sysTeamMapper.selectByExample(limitExample);
            if (limitList.size() >= max) {
                //人数到达上限
                throw new ApiException(TeamErrorEnum.TEAM_NUMBER_LIMIT);
            } else {
                TeamUser teamUser = new TeamUser();
                teamUser.setTeamId(teamId);
                teamUser.setUserId(userId);
                teamUserMapper.insert(teamUser);
            }
        }
    }

    @Override
    public TeamDetailVO getDetail(Integer userId) {
        // 获取团队id
        TeamUserExample teamUserExample = new TeamUserExample();
        TeamUserExample.Criteria teamUserCriteria = teamUserExample.createCriteria();
        teamUserCriteria.andUserIdEqualTo(userId);
        List<TeamUser> temp = teamUserMapper.selectByExample(teamUserExample);
        if (temp == null || temp.size() == 0) {
            return new TeamDetailVO();
        }
        Integer teamId = temp.get(0).getTeamId();


        // 获取团队信息
        SysTeam sysTeam = sysTeamMapper.selectByPrimaryKey(teamId);
        TeamDetailVO teamDetailVO = modelMapper.map(sysTeam, TeamDetailVO.class);

        // 获取成员信息
        teamUserExample.clear();
        TeamUserExample.Criteria teamUserCriteria2 = teamUserExample.createCriteria();
        teamUserCriteria2.andTeamIdEqualTo(teamId);
        List<TeamUser> teamUserList = teamUserMapper.selectByExample(teamUserExample);
        List<TeamUserVO> teamUserVOList = new ArrayList<>();

        for (TeamUser teamUser : teamUserList) {
            ClassUserExample classUserExample = new ClassUserExample();
            ClassUserExample.Criteria classUserCriteria = classUserExample.createCriteria();
            classUserCriteria.andUserIdEqualTo(teamUser.getUserId());
            ClassUser classUser = classUserMapper.selectByExample(classUserExample).get(0);

            User user = userDao.get(classUser.getUserId());
            TeamUserVO teamUserVO = modelMapper.map(classUser, TeamUserVO.class);
            teamUserVO.setUserAccount(user.getUserAccount());
            teamUserVO.setUserName(user.getUserName());
            teamUserVO.setUserId(user.getUserId());
            teamUserVO.setIsCaptain(user.getUserId().equals(sysTeam.getTeamCaptain()));

            teamUserVOList.add(teamUserVO);
        }
        teamDetailVO.setClassUserVOList(teamUserVOList);
        return teamDetailVO;
    }

    @Override
    public void update(TeamUpdateDTO teamUpdateDTO, Integer userId) {
        SysTeam sysTeam = modelMapper.map(teamUpdateDTO, SysTeam.class);

        if (sysTeamMapper.selectByPrimaryKey(teamUpdateDTO.getTeamId()).getTeamName().equals(teamUpdateDTO.getTeamName())) {
            //团队名已经存在
            throw new ApiException(TeamErrorEnum.TEAM_NAME_EXIST);
        }

        if (!sysTeamMapper.selectByPrimaryKey(teamUpdateDTO.getTeamId()).getTeamCaptain().equals(userId)) {
            //非队长修改团队信息
            throw new ApiException(TeamErrorEnum.NOT_CAPTAIN_UPDATE);
        }

        if (teamUpdateDTO.getTeamCaptain() != null) {
            TeamUserExample teamUserExample = new TeamUserExample();
            TeamUserExample.Criteria teamUserCri = teamUserExample.createCriteria();
            teamUserCri.andTeamIdEqualTo(teamUpdateDTO.getTeamId());
            teamUserCri.andUserIdEqualTo(teamUpdateDTO.getTeamCaptain());
            List<TeamUser> teamUsers = teamUserMapper.selectByExample(teamUserExample);
            if (teamUsers.size() == 0) {
                //非本队成员成为队长
                throw new ApiException(TeamErrorEnum.CAPTAIN_NOT_IN_TEAM);
            }
        }


        ClassUserExample classUserExample = new ClassUserExample();
        ClassUserExample.Criteria criteria = classUserExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if (!sysClassMapper.selectByPrimaryKey(classUserMapper.selectByExample(classUserExample).get(0).getClassId()).getClassTeamEdit()) {
            //学生下的班级的团队不许编辑
            throw new ApiException(TeamErrorEnum.CLASS_TEAM_EDIT_LIMIT);
        }
        if (!sysTeamMapper.selectByPrimaryKey(teamUpdateDTO.getTeamId()).getTeamEdit()) {
            //团队信息不允许编辑
            throw new ApiException(TeamErrorEnum.TEAM_EDIT_LIMIT);
        }
        SysTeamExample example = new SysTeamExample();
        SysTeamExample.Criteria criteria1 = example.createCriteria();
        criteria1.andTeamIdEqualTo(teamUpdateDTO.getTeamId());
        sysTeamMapper.updateByExampleSelective(sysTeam, example);
    }

    @Override
    public void exit(Integer userId) {
        SysTeamExample teamExample = new SysTeamExample();
        SysTeamExample.Criteria teamCriteria = teamExample.createCriteria();
        teamCriteria.andTeamCaptainEqualTo(userId);
        List<SysTeam> temp = sysTeamMapper.selectByExample(teamExample);
        if (temp.size() != 0) {
            throw new ApiException(TeamErrorEnum.TEAM_CAPTAIN_EXIT_ERROR);
        }
        TeamUserExample teamUserExample = new TeamUserExample();
        TeamUserExample.Criteria teamUserCriteria = teamUserExample.createCriteria();
        teamUserCriteria.andUserIdEqualTo(userId);
        teamUserMapper.deleteByExample(teamUserExample);
    }

    @Override
    public void clear(Integer teamId, Integer userId) {
        if (!sysTeamMapper.selectByPrimaryKey(teamId).getTeamCaptain().equals(userId)) {
            //不是队长不能解散团队
            throw new ApiException(TeamErrorEnum.NOT_CAPTAIN_CLEAR_TEAM);
        }
        TeamUserExample example = new TeamUserExample();
        TeamUserExample.Criteria criteria = example.createCriteria();
        criteria.andTeamIdEqualTo(teamId);
        teamUserMapper.deleteByExample(example);
    }
}
