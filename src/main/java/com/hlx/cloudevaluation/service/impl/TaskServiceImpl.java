package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.dao.UserDao;
import com.hlx.cloudevaluation.mapper.*;
import com.hlx.cloudevaluation.model.dto.TaskAddDTO;
import com.hlx.cloudevaluation.model.dto.TaskEvaluateDTO;
import com.hlx.cloudevaluation.model.dto.TaskSkillAddDTO;
import com.hlx.cloudevaluation.model.po.*;
import com.hlx.cloudevaluation.model.vo.*;
import com.hlx.cloudevaluation.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @description: 作业服务实现层
 * @author: hlx 2019-05-05
 **/
@Service
public class TaskServiceImpl implements TaskService {

    private SysTaskMapper sysTaskMapper;

    private TaskSkillMapper taskSkillMapper;

    private ModelMapper modelMapper;

    private SysTeamMapper sysTeamMapper;

    private TeamScoreMapper teamScoreMapper;

    private TeamUserMapper teamUserMapper;

    private UserScoreMapper userScoreMapper;

    private UserDao userDao;

    private SkillScoreMapper skillScoreMapper;

    private SysSkillMapper sysSkillMapper;

    public TaskServiceImpl(SysTaskMapper sysTaskMapper, TaskSkillMapper taskSkillMapper,
                           ModelMapper modelMapper, SysTeamMapper sysTeamMapper,
                           TeamScoreMapper teamScoreMapper, TeamUserMapper teamUserMapper,
                           UserDao userDao, UserScoreMapper userScoreMapper, SkillScoreMapper skillScoreMapper,
                           SysSkillMapper sysSkillMapper) {
        this.sysTaskMapper = sysTaskMapper;
        this.taskSkillMapper = taskSkillMapper;
        this.modelMapper = modelMapper;
        this.sysTeamMapper = sysTeamMapper;
        this.teamScoreMapper = teamScoreMapper;
        this.teamUserMapper = teamUserMapper;
        this.userDao = userDao;
        this.userScoreMapper = userScoreMapper;
        this.skillScoreMapper = skillScoreMapper;
        this.sysSkillMapper = sysSkillMapper;
    }

    @Override
    public void add(TaskAddDTO taskAddDTO, Integer userId) {
        SysTask sysTask = modelMapper.map(taskAddDTO, SysTask.class);
        sysTask.setTaskCreator(userId);
        sysTask.setTaskCreateAt(new Date());
        List<TaskSkillAddDTO> skillAddDTOList = taskAddDTO.getSkillList();
        sysTaskMapper.insert(sysTask);
        for (TaskSkillAddDTO item : skillAddDTOList) {
            TaskSkill taskSkill = new TaskSkill();
            taskSkill.setSkillId(item.getSkillId());
            taskSkill.setSkillNumber(item.getSkillNumber());
            taskSkill.setTaskId(sysTask.getTaskId());
            taskSkillMapper.insertSelective(taskSkill);
        }
    }

    @Override
    public TaskStatusVO getStatus(Integer taskId) {
        SysTask sysTask = sysTaskMapper.selectByPrimaryKey(taskId);
        TaskStatusVO taskStatusVO = modelMapper.map(sysTask, TaskStatusVO.class);

        SysTeamExample teamExample = new SysTeamExample();
        SysTeamExample.Criteria teamCri = teamExample.createCriteria();
        teamCri.andTeamExitEqualTo(false);
        //这个班级下的团队
        teamCri.andTeamClassEqualTo(sysTask.getTaskClass());
        List<SysTeam> teamList = sysTeamMapper.selectByExample(teamExample);
        List<TaskStatusItemVO> statusDatas = new ArrayList<>();
        for (SysTeam item : teamList) {
            TaskStatusItemVO v = new TaskStatusItemVO();
            v.setTeamName(item.getTeamName());
            TeamScoreExample teamScoreExample = new TeamScoreExample();
            TeamScoreExample.Criteria tsCir = teamScoreExample.createCriteria();
            tsCir.andTaskIdEqualTo(taskId);
            tsCir.andTeamIdEqualTo(item.getTeamId());
            if (teamScoreMapper.selectByExample(teamScoreExample).size() > 0) {
                v.setStatus(true);
            } else {
                v.setStatus(false);
            }
            statusDatas.add(v);
        }
        taskStatusVO.setTaskStatusItemVOList(statusDatas);
        return taskStatusVO;
    }

    @Override
    public TaskTeamStatusVO getTeamStatus(Integer taskId, Integer teamId) {
        TaskTeamStatusVO taskTeamStatusVO = new TaskTeamStatusVO();

        List<UserContributeVO> contributeVOList = new ArrayList<>();
        TeamUserExample teamUserExample = new TeamUserExample();
        TeamUserExample.Criteria tuCri = teamUserExample.createCriteria();
        tuCri.andTeamIdEqualTo(teamId);
        List<TeamUser> users = teamUserMapper.selectByExample(teamUserExample);

        //判断是否已经打分
        TeamScoreExample teamScoreExample = new TeamScoreExample();
        TeamScoreExample.Criteria tsCir = teamScoreExample.createCriteria();
        tsCir.andTaskIdEqualTo(taskId);
        tsCir.andTeamIdEqualTo(teamId);
        if (teamScoreMapper.selectByExample(teamScoreExample).size() == 0) {
            //未打分
            taskTeamStatusVO.setSkillVOList(null);
            taskTeamStatusVO.setUserContributeVOList(null);
            return taskTeamStatusVO;
        }

        for (TeamUser userItem : users) {
            UserContributeVO userContributeVo = new UserContributeVO();
            userContributeVo.setUserId(userItem.getUserId());
            userContributeVo.setUserName(userDao.get(userItem.getUserId()).getUserName());

            UserScoreExample userScoreExample = new UserScoreExample();
            UserScoreExample.Criteria usCri = userScoreExample.createCriteria();
            usCri.andTaskIdEqualTo(taskId);
            usCri.andUserIdEqualTo(userItem.getTeamId());
            List<UserScore> userScores = userScoreMapper.selectByExample(userScoreExample);
            userContributeVo.setUsContribute(userScores.get(0).getUsContribute());
            contributeVOList.add(userContributeVo);
        }
        taskTeamStatusVO.setUserContributeVOList(contributeVOList);

        List<SkillScoreVO> skillScoreVOList = new ArrayList<>();

        //根据队长查团队的能力指标
        Integer captain = sysTeamMapper.selectByPrimaryKey(teamId).getTeamCaptain();

        SkillScoreExample skillScoreExample = new SkillScoreExample();
        SkillScoreExample.Criteria ssCri = skillScoreExample.createCriteria();
        ssCri.andUserIdEqualTo(captain);
        ssCri.andTaskIdEqualTo(taskId);
        List<SkillScore> skillScores = skillScoreMapper.selectByExample(skillScoreExample);

        for (SkillScore ssItem : skillScores) {
            SysSkill sysSkill = sysSkillMapper.selectByPrimaryKey(ssItem.getSkillId());
            SkillScoreVO skillScoreVO = modelMapper.map(sysSkill, SkillScoreVO.class);
            skillScoreVO.setSsScore(ssItem.getSsScore());
            skillScoreVOList.add(skillScoreVO);
        }
        taskTeamStatusVO.setSkillVOList(skillScoreVOList);

        return taskTeamStatusVO;
    }

    @Override
    public void evaluate(TaskEvaluateDTO taskEvaluateDTO) {
    }
}
