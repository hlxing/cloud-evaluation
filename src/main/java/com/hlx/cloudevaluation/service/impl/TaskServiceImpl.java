package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.dao.UserDao;
import com.hlx.cloudevaluation.exception.error.ApiException;
import com.hlx.cloudevaluation.exception.error.TaskErrorEnum;
import com.hlx.cloudevaluation.exception.error.TeamErrorEnum;
import com.hlx.cloudevaluation.mapper.*;
import com.hlx.cloudevaluation.model.dto.*;
import com.hlx.cloudevaluation.model.po.*;
import com.hlx.cloudevaluation.model.vo.*;
import com.hlx.cloudevaluation.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

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

    private ClassUserMapper classUserMapper;


    public TaskServiceImpl(SysTaskMapper sysTaskMapper, TaskSkillMapper taskSkillMapper,
                           ModelMapper modelMapper, SysTeamMapper sysTeamMapper,
                           TeamScoreMapper teamScoreMapper, TeamUserMapper teamUserMapper,
                           UserDao userDao, UserScoreMapper userScoreMapper,
                           SkillScoreMapper skillScoreMapper, SysSkillMapper sysSkillMapper,
                           ClassUserMapper classUserMapper) {
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
        this.classUserMapper = classUserMapper;
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
        if (sysTask == null) {
            throw new ApiException(TeamErrorEnum.TASK_ID_INVALID);
        }
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
            v.setTeamId(item.getTeamId());
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
        boolean flag = false;
        if (teamScoreMapper.selectByExample(teamScoreExample).size() > 0) {
            //有打分
            flag = true;
        }

        for (TeamUser userItem : users) {
            UserContributeVO userContributeVo = new UserContributeVO();
            userContributeVo.setUserId(userItem.getUserId());
            userContributeVo.setUserName(userDao.get(userItem.getUserId()).getUserName());
            if (flag) {
                UserScoreExample userScoreExample = new UserScoreExample();
                UserScoreExample.Criteria usCri = userScoreExample.createCriteria();
                usCri.andTaskIdEqualTo(taskId);
                usCri.andUserIdEqualTo(userItem.getUserId());
                List<UserScore> userScores = userScoreMapper.selectByExample(userScoreExample);
                userContributeVo.setUsContribute(userScores.get(0).getUsContribute());
            } else {
                userContributeVo.setUsContribute(null);
            }
            contributeVOList.add(userContributeVo);
        }
        taskTeamStatusVO.setUserContributeVOList(contributeVOList);

        List<TaskSkillScoreVO> skillScoreVOList = new ArrayList<>();

        if (flag) {
            //根据队长查团队的能力指标
            Integer captain = sysTeamMapper.selectByPrimaryKey(teamId).getTeamCaptain();
            SkillScoreExample skillScoreExample = new SkillScoreExample();
            SkillScoreExample.Criteria ssCri = skillScoreExample.createCriteria();
            ssCri.andUserIdEqualTo(captain);
            ssCri.andTaskIdEqualTo(taskId);
            List<SkillScore> skillScores = skillScoreMapper.selectByExample(skillScoreExample);

            for (SkillScore ssItem : skillScores) {
                SysSkill sysSkill = sysSkillMapper.selectByPrimaryKey(ssItem.getSkillId());
                TaskSkillScoreVO skillScoreVO = modelMapper.map(sysSkill, TaskSkillScoreVO.class);
                skillScoreVO.setSsScore(ssItem.getSsScore());

                skillScoreVOList.add(skillScoreVO);
            }
        } else {
            TaskSkillExample taskSkillExample = new TaskSkillExample();
            TaskSkillExample.Criteria tsCri = taskSkillExample.createCriteria();
            tsCri.andTaskIdEqualTo(taskId);
            List<TaskSkill> taskSkills = taskSkillMapper.selectByExample(taskSkillExample);
            for (TaskSkill skillItem : taskSkills) {
                SysSkill sysSkill = sysSkillMapper.selectByPrimaryKey(skillItem.getSkillId());
                TaskSkillScoreVO skillScoreVO = modelMapper.map(sysSkill, TaskSkillScoreVO.class);
                skillScoreVO.setSsScore(null);

                skillScoreVOList.add(skillScoreVO);
            }
        }
        taskTeamStatusVO.setSkillVOList(skillScoreVOList);

        return taskTeamStatusVO;
    }

    @Override
    public void evaluate(TaskEvaluateDTO taskEvaluateDTO) {
        List<TaskSkillDTO> taskSkillDTOList = taskEvaluateDTO.getTaskSkillDTOList();
        Map<Integer, Double> skillScoreMap = new HashMap<>();
        Integer taskId = taskEvaluateDTO.getTaskId();
        Integer teamId = taskEvaluateDTO.getTeamId();
        Double teamScoreVal = 0.0;
        for (TaskSkillDTO taskSkillDTO : taskSkillDTOList) {
            skillScoreMap.put(taskSkillDTO.getSkillId(), taskSkillDTO.getSsScore());
            teamScoreVal += taskSkillDTO.getSsScore();
        }
        TeamScore teamScore = new TeamScore();
        teamScore.setTaskId(taskId);
        teamScore.setTeamId(teamId);
        teamScore.setTeamScore(teamScoreVal);



        Double averageContribute = 0.0;
        List<TaskContributeDTO> taskContributeDTOList = taskEvaluateDTO.getTaskContributeDTOList();
        Map<Integer, Double> userContributeMap = new HashMap<>();
        for (TaskContributeDTO taskContributeDTO : taskContributeDTOList) {
            userContributeMap.put(taskContributeDTO.getUserId(), taskContributeDTO.getUsContribute());
            averageContribute += taskContributeDTO.getUsContribute();
        }
        averageContribute = averageContribute / taskContributeDTOList.size();

        teamScore.setAverageContribute(averageContribute);
        teamScoreMapper.insertSelective(teamScore);


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

    @Override
    public TaskSearchVO search(Integer userId) {
        ClassUserExample classUserExample = new ClassUserExample();
        ClassUserExample.Criteria classUserCriteria = classUserExample.createCriteria();
        classUserCriteria.andUserIdEqualTo(userId);
        List<ClassUser> classUserList = classUserMapper.selectByExample(classUserExample);
        if (classUserList.size() == 0) {
            return new TaskSearchVO();
        }
        Integer classId = classUserList.get(0).getClassId();

        SysTaskExample taskExample = new SysTaskExample();
        SysTaskExample.Criteria taskCriteria = taskExample.createCriteria();
        taskCriteria.andTaskClassEqualTo(classId);
        List<SysTask> taskList = sysTaskMapper.selectByExample(taskExample);
        List<TaskVO> taskVOList = new ArrayList<>();
        for (SysTask task : taskList) {
            TaskVO taskVO = modelMapper.map(task, TaskVO.class);
            User user = userDao.get(taskVO.getTaskId());
            taskVO.setTaskCreatorName(user.getUserName());
            taskVO.setTaskCreatorAccount(user.getUserAccount());


            taskVOList.add(taskVO);
        }

        TaskSearchVO taskSearchVO = new TaskSearchVO();
        taskSearchVO.setTaskVOList(taskVOList);

        return taskSearchVO;
    }

    @Override
    public TaskScoreVO getScore(Integer taskId, Integer userId) {
        TaskScoreVO taskScoreVO = new TaskScoreVO();

        UserScoreExample userScoreExample = new UserScoreExample();
        UserScoreExample.Criteria usCri = userScoreExample.createCriteria();
        usCri.andTaskIdEqualTo(taskId);
        usCri.andUserIdEqualTo(userId);
        List<UserScore> userScores = userScoreMapper.selectByExample(userScoreExample);
        if (userScores.size() > 0) {
            taskScoreVO.setUsContribute(userScores.get(0).getUsContribute());
            taskScoreVO.setUsFinalScore(userScores.get(0).getUsFinalScore());

            TeamUserExample teamUserExample = new TeamUserExample();
            TeamUserExample.Criteria tuCri = teamUserExample.createCriteria();
            tuCri.andUserIdEqualTo(userId);
            Integer teamId = teamUserMapper.selectByExample(teamUserExample).get(0).getTeamId();

            TeamScoreExample teamScoreExample = new TeamScoreExample();
            TeamScoreExample.Criteria tsCri = teamScoreExample.createCriteria();
            tsCri.andTeamIdEqualTo(teamId);
            tsCri.andTaskIdEqualTo(taskId);
            Double average = teamScoreMapper.selectByExample(teamScoreExample).get(0).getAverageContribute();

            taskScoreVO.setAverageContribute(average);

            SkillScoreExample skillScoreExample = new SkillScoreExample();
            SkillScoreExample.Criteria ssCri = skillScoreExample.createCriteria();
            ssCri.andUserIdEqualTo(userId);
            ssCri.andTaskIdEqualTo(taskId);
            List<SkillScore> skillScores = skillScoreMapper.selectByExample(skillScoreExample);
            List<SkillScoreVO> skillScoreVOList = new ArrayList<>();
            for (SkillScore item : skillScores) {
                SysSkill sysSkill = sysSkillMapper.selectByPrimaryKey(item.getSkillId());
                SkillScoreVO skillScoreVO = modelMapper.map(sysSkill, SkillScoreVO.class);
                skillScoreVO.setSsScore(item.getSsScore());
                skillScoreVO.setSsRealScore(item.getSsRealScore());

                skillScoreVOList.add(skillScoreVO);
            }
            taskScoreVO.setSkillScoreVOList(skillScoreVOList);

            return taskScoreVO;
        }
        return new TaskScoreVO();
    }

    @Override
    public void delete(Integer taskId) {
        SkillScoreExample skillScoreExample = new SkillScoreExample();
        SkillScoreExample.Criteria ssCri = skillScoreExample.createCriteria();
        ssCri.andTaskIdEqualTo(taskId);
        if (skillScoreMapper.selectByExample(skillScoreExample).size() > 0) {
            throw new ApiException(TaskErrorEnum.NOT_DELETE_AFTER_SCORE);
        }
        sysTaskMapper.deleteByPrimaryKey(taskId);
    }

    @Override
    public void update(TaskUpdateDTO taskUpdateDTO) {
        SysTask sysTask = modelMapper.map(taskUpdateDTO, SysTask.class);
        sysTaskMapper.updateByPrimaryKeySelective(sysTask);
        for (TaskSkillAddDTO item : taskUpdateDTO.getSkillList()) {
            TaskSkill taskSkill = new TaskSkill();
            taskSkill.setTaskId(taskUpdateDTO.getTaskId());
            taskSkill.setSkillId(item.getSkillId());
            taskSkill.setSkillNumber(item.getSkillNumber());
            taskSkillMapper.insert(taskSkill);
        }
    }

    @Override
    public TaskSearchVO getList() {


    }
}
