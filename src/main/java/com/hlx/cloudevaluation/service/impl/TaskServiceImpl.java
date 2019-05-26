package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.mapper.*;
import com.hlx.cloudevaluation.model.dto.TaskAddDTO;
import com.hlx.cloudevaluation.model.dto.TaskEvaluateDTO;
import com.hlx.cloudevaluation.model.dto.TaskSkillAddDTO;
import com.hlx.cloudevaluation.model.po.*;
import com.hlx.cloudevaluation.model.vo.TaskStatusItemVO;
import com.hlx.cloudevaluation.model.vo.TaskStatusVO;
import com.hlx.cloudevaluation.model.vo.TaskTeamStatusVO;
import com.hlx.cloudevaluation.model.vo.UserContributeVO;
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

    public TaskServiceImpl(SysTaskMapper sysTaskMapper, TaskSkillMapper taskSkillMapper,
                           ModelMapper modelMapper, SysTeamMapper sysTeamMapper,
                           TeamScoreMapper teamScoreMapper, TeamUserMapper teamUserMapper) {
        this.sysTaskMapper = sysTaskMapper;
        this.taskSkillMapper = taskSkillMapper;
        this.modelMapper = modelMapper;
        this.sysTeamMapper = sysTeamMapper;
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
//        TaskStatusVO taskStatusVO = new TaskStatusVO();
//
//        List<UserContributeVO> contributeVOList =new ArrayList<>();
//        TeamUserExample teamUserExample = new TeamUserExample();
//        TeamUserExample.Criteria tuCri = teamUserExample.createCriteria();
//        tuCri.andTeamIdEqualTo(teamId);
//        List<TeamUser> users = teamUserMapper.selectByExample(teamUserExample);
//        for(TeamUser userItem : users){
//            UserContributeVO userVo = new UserContributeVO();
//            userVo.setUserId(userItem.getUserId());
//            userVo.setUserName();
//
//        }
        return null;


    }

    @Override
    public void evaluate(TaskEvaluateDTO taskEvaluateDTO) {
    }
}
