package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.mapper.*;
import com.hlx.cloudevaluation.model.dto.*;
import com.hlx.cloudevaluation.model.po.*;
import com.hlx.cloudevaluation.model.vo.TaskStatusVO;
import com.hlx.cloudevaluation.model.vo.TaskTeamStatusVO;
import com.hlx.cloudevaluation.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 作业服务实现层
 * @author: hlx 2019-05-05
 **/
@Service
public class TaskServiceImpl implements TaskService {

    private SysTaskMapper sysTaskMapper;

    private TaskSkillMapper taskSkillMapper;

    private SkillScoreMapper skillScoreMapper;

    private UserScoreMapper userScoreMapper;

    private TeamScoreMapper teamScoreMapper;

    private TeamUserMapper teamUserMapper;

    private ModelMapper modelMapper;

    public TaskServiceImpl(SysTaskMapper sysTaskMapper, TaskSkillMapper taskSkillMapper, ModelMapper modelMapper,
                           SkillScoreMapper skillScoreMapper, UserScoreMapper userScoreMapper, TeamScoreMapper teamScoreMapper,
                           TeamUserMapper teamUserMapper) {
        this.sysTaskMapper = sysTaskMapper;
        this.taskSkillMapper = taskSkillMapper;
        this.modelMapper = modelMapper;
        this.skillScoreMapper = skillScoreMapper;
        this.userScoreMapper = userScoreMapper;
        this.teamScoreMapper = teamScoreMapper;
        this.teamUserMapper = teamUserMapper;
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
        return null;
    }

    @Override
    public TaskTeamStatusVO getTeamStatus(Integer taskId, Integer teamId) {
        return null;
    }

    @Override
    public void evaluate(TaskEvaluateDTO taskEvaluateDTO) {
        List<TaskSkillDTO> taskSkillDTOList = taskEvaluateDTO.getTaskSkillDTOList();
        Map<Integer, Double> skillScoreMap = new HashMap<>();
        Integer taskId = taskEvaluateDTO.getTaskId();
        Integer teamId = taskEvaluateDTO.getTeamId();
        Double teamScoreVal = 0.0;
        for (TaskSkillDTO taskSkillDTO : taskSkillDTOList) {
            skillScoreMap.put(taskSkillDTO.getTaskId(), taskSkillDTO.getSsScore());
            teamScoreVal += taskSkillDTO.getSsScore();
        }
        TeamScore teamScore = new TeamScore();
        teamScore.setTaskId(taskId);
        teamScore.setTeamId(teamId);
        teamScore.setTeamScore(teamScoreVal);
        teamScoreMapper.insertSelective(teamScore);

        Double averageContribute = 0.0;
        List<TaskContributeDTO> taskContributeDTOList = taskEvaluateDTO.getTaskContributeDTOList();
        Map<Integer, Double> userContributeMap = new HashMap<>();
        for (TaskContributeDTO taskContributeDTO : taskContributeDTOList) {
            userContributeMap.put(taskContributeDTO.getUserId(), taskContributeDTO.getUsContribute());
            averageContribute += taskContributeDTO.getUsContribute();
        }
        averageContribute = averageContribute / taskContributeDTOList.size();

        TeamUserExample teamUserExample = new TeamUserExample();
        TeamUserExample.Criteria teamUserCriteria = teamUserExample.createCriteria();
        teamUserCriteria.andTeamIdEqualTo(taskEvaluateDTO.getTeamId());
        List<TeamUser> teamUserList = teamUserMapper.selectByExample(teamUserExample);
        for (TeamUser teamUser : teamUserList) {
            UserScore userScore = new UserScore();
            Integer userId = teamUser.getUserId();
            Double finalScore = 0.0;
            Double contributeRate = 1 + userContributeMap.get(userId) - averageContribute;
            for (Integer skillId : skillScoreMap.keySet()) {
                SkillScore skillScore = new SkillScore();
                skillScore.setSkillId(skillId);
                skillScore.setTaskId(taskId);
                skillScore.setUserId(userId);
                skillScore.setSsScore(skillScoreMap.get(skillId));
                skillScore.setSsRealScore(skillScoreMap.get(skillId) * contributeRate);
                finalScore += skillScore.getSsRealScore();
                skillScoreMapper.insertSelective(skillScore);
            }
            userScore.setTaskId(taskId);
            userScore.setUsContribute(userContributeMap.get(userId));
            userScore.setUserId(userId);
            userScore.setUsFinalScore(finalScore);
            userScoreMapper.insertSelective(userScore);
        }
    }

}
