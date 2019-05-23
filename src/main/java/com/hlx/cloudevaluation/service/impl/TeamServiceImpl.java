package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.exception.error.ApiException;
import com.hlx.cloudevaluation.exception.error.TeamErrorEnum;
import com.hlx.cloudevaluation.mapper.ClassUserMapper;
import com.hlx.cloudevaluation.mapper.SysTeamMapper;
import com.hlx.cloudevaluation.mapper.TeamUserMapper;
import com.hlx.cloudevaluation.model.dto.TeamAddDTO;
import com.hlx.cloudevaluation.model.po.*;
import com.hlx.cloudevaluation.model.vo.TeamDetailVO;
import com.hlx.cloudevaluation.service.TeamService;
import com.hlx.cloudevaluation.util.RandomUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private ModelMapper modelMapper;

    private TeamUserMapper teamUserMapper;

    private SysTeamMapper sysTeamMapper;

    private ClassUserMapper classUserMapper;

    public TeamServiceImpl(ModelMapper modelMapper, TeamUserMapper teamUserMapper,
                           SysTeamMapper sysTeamMapper, ClassUserMapper classUserMapper) {
        this.modelMapper = modelMapper;
        this.teamUserMapper = teamUserMapper;
        this.sysTeamMapper = sysTeamMapper;
        this.classUserMapper = classUserMapper;
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
                throw new ApiException(TeamErrorEnum.CLASS_TEAM_LIMIT);
            } else {
                TeamUser teamUser = new TeamUser();
                teamUser.setTeamId(teamId);
                teamUserMapper.insert(teamUser);
            }
        }
    }

    @Override
    public TeamDetailVO getDetail(Integer userId) {
        return null;
    }
}
