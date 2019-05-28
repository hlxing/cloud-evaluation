package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.dao.UserDao;
import com.hlx.cloudevaluation.mapper.*;
import com.hlx.cloudevaluation.model.po.*;
import com.hlx.cloudevaluation.model.vo.*;
import com.hlx.cloudevaluation.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 统计服务实现层
 * @author: hlx 2019-05-28
 **/
@Service
public class AnalysisServiceImpl implements AnalysisService {

    private UserScoreMapper userScoreMapper;

    private UserDao userDao;

    private SkillScoreMapper skillScoreMapper;

    private SysSkillMapper sysSkillMapper;

    private SysTaskMapper sysTaskMapper;

    private TaskSkillMapper taskSkillMapper;

    @Autowired
    public AnalysisServiceImpl(UserScoreMapper userScoreMapper, UserDao userDao, SkillScoreMapper skillScoreMapper,
                               SysSkillMapper sysSkillMapper, SysTaskMapper sysTaskMapper, TaskSkillMapper taskSkillMapper) {
        this.userScoreMapper = userScoreMapper;
        this.userDao = userDao;
        this.skillScoreMapper = skillScoreMapper;
        this.sysSkillMapper = sysSkillMapper;
        this.sysTaskMapper = sysTaskMapper;
        this.taskSkillMapper = taskSkillMapper;
    }

    @Override
    public AnalysisTaskTotalVO getTaskTotal(Integer taskId, Integer userId) {
        AnalysisTaskTotalVO analysisTaskTotalVO = new AnalysisTaskTotalVO();
        List<AnalysisTaskTotalItemVO> analysisTaskTotalItemVOList = new ArrayList<>();
        UserScoreExample userScoreExample = new UserScoreExample();
        UserScoreExample.Criteria usCri = userScoreExample.createCriteria();
        usCri.andTaskIdEqualTo(taskId);

        List<UserScore> userScoreList = userScoreMapper.selectByExample(userScoreExample);
        for (UserScore userScore : userScoreList) {
            AnalysisTaskTotalItemVO analysisTaskTotalItemVO = new AnalysisTaskTotalItemVO();
            analysisTaskTotalItemVO.setUsFinalScore(userScore.getUsFinalScore());
            analysisTaskTotalItemVO.setUserAccount(userDao.get(userScore.getUserId()).getUserAccount());

            analysisTaskTotalItemVOList.add(analysisTaskTotalItemVO);
        }
        analysisTaskTotalVO.setTaskTotalItemVOList(analysisTaskTotalItemVOList);
        return analysisTaskTotalVO;
    }

    @Override
    public AnalysisTaskSkillVO getTaskDetail(Integer taskId, Integer skillId, Integer userId) {
        AnalysisTaskSkillVO analysisTaskSkillVO = new AnalysisTaskSkillVO();

        SkillScoreExample skillScoreExample = new SkillScoreExample();
        SkillScoreExample.Criteria ssCri = skillScoreExample.createCriteria();
        ssCri.andTaskIdEqualTo(taskId);
        ssCri.andSkillIdEqualTo(skillId);
        List<SkillScore> skillScoreList = skillScoreMapper.selectByExample(skillScoreExample);

        List<AnalysisTaskSkillItemVO> analysisTaskSkillItemVOList = new ArrayList<>();

        for (SkillScore skillScore : skillScoreList) {
            AnalysisTaskSkillItemVO analysisTaskSkillItemVO = new AnalysisTaskSkillItemVO();
            analysisTaskSkillItemVO.setScore(skillScore.getSsRealScore());
            analysisTaskSkillItemVO.setUserAccount(userDao.get(skillScore.getUserId()).getUserAccount());
            analysisTaskSkillItemVOList.add(analysisTaskSkillItemVO);
        }

        analysisTaskSkillVO.setSkillItemVOList(analysisTaskSkillItemVOList);

        return analysisTaskSkillVO;
    }

    @Override
    public AnalysisTaskSkillAverageVO getTaskSkillAverage(Integer taskId, Integer userId) {
        AnalysisTaskSkillAverageVO analysisTaskSkillAverageVO = new AnalysisTaskSkillAverageVO();
        List<AnalysisTaskSkillAverageItemVO> analysisTaskSkillAverageItemVOList = new ArrayList<>();

        SkillScoreExample skillScoreExample = new SkillScoreExample();
        SkillScoreExample.Criteria ssCri = skillScoreExample.createCriteria();
        ssCri.andTaskIdEqualTo(taskId);
        List<SkillScore> skillScoreList = skillScoreMapper.selectByExample(skillScoreExample);

        Map<Integer, Double> skillMap = new HashMap<>();

        for (SkillScore skillScore : skillScoreList) {
            Integer skillId = skillScore.getSkillId();
            Double realScore = skillScore.getSsRealScore();
            skillMap.put(skillId, skillMap.getOrDefault(skillId, 0.0) + realScore);
        }

        //学生的数量
        Integer stuNum = skillScoreList.size() / skillMap.keySet().size();
        for (Integer skillIdItem : skillMap.keySet()) {
            AnalysisTaskSkillAverageItemVO analysisTaskSkillAverageItemVO = new AnalysisTaskSkillAverageItemVO();
            analysisTaskSkillAverageItemVO.setSkillName(sysSkillMapper.selectByPrimaryKey(skillIdItem).getSkillName());
            analysisTaskSkillAverageItemVO.setAverageScore(skillMap.get(skillIdItem) / stuNum);

            analysisTaskSkillAverageItemVOList.add(analysisTaskSkillAverageItemVO);
        }
        analysisTaskSkillAverageVO.setSkillAverageItemVOList(analysisTaskSkillAverageItemVOList);
        return analysisTaskSkillAverageVO;
    }

    @Override
    public AnalysisClassSkillAverageVO getClassSkillAverage(Integer classId, Integer skillId) {
        AnalysisClassSkillAverageVO analysisClassSkillAverageVO = new AnalysisClassSkillAverageVO();
        List<AnalysisClasSkillAverageItemVO> analysisClasSkillAverageItemVOList = new ArrayList<>();

        SysTaskExample sysTaskExample = new SysTaskExample();
        SysTaskExample.Criteria taskCri = sysTaskExample.createCriteria();
        taskCri.andTaskClassEqualTo(classId);
        List<SysTask> taskList = sysTaskMapper.selectByExample(sysTaskExample);

        for (SysTask task : taskList) {
            AnalysisClasSkillAverageItemVO analysisClasSkillAverageItemVO = new AnalysisClasSkillAverageItemVO();

            TaskSkillExample taskSkillExample = new TaskSkillExample();
            TaskSkillExample.Criteria tsCri = taskSkillExample.createCriteria();
            tsCri.andTaskIdEqualTo(task.getTaskId());
            tsCri.andSkillIdEqualTo(skillId);
            List<TaskSkill> taskSkillList = taskSkillMapper.selectByExample(taskSkillExample);
            if (taskSkillList.size() == 0) {
                //这个作业没有这个能力指标
                analysisClasSkillAverageItemVO.setScore(0.0);
            } else {
                //这个作业有这个能力指标
                SkillScoreExample skillScoreExample = new SkillScoreExample();
                SkillScoreExample.Criteria ssCri = skillScoreExample.createCriteria();
                ssCri.andSkillIdEqualTo(skillId);
                ssCri.andTaskIdEqualTo(task.getTaskId());
                List<SkillScore> skillScoreList = skillScoreMapper.selectByExample(skillScoreExample);
                Double total = 0.0;
                for (SkillScore skillScore : skillScoreList) {
                    total += skillScore.getSsRealScore();
                }
                analysisClasSkillAverageItemVO.setScore(total / skillScoreList.size());
            }
            analysisClasSkillAverageItemVO.setTaskId(task.getTaskId());
            analysisClasSkillAverageItemVO.setTaskName(task.getTaskName());
            analysisClasSkillAverageItemVOList.add(analysisClasSkillAverageItemVO);
        }

        analysisClassSkillAverageVO.setClassTaskSkillAverageItemVOList(analysisClasSkillAverageItemVOList);
        return analysisClassSkillAverageVO;
    }

    @Override
    public AnalysisClassTotalVO getClassTotal(Integer classId) {

        AnalysisClassTotalVO analysisClassTotalVO = new AnalysisClassTotalVO();
        List<AnalysisClassTotalItemVO> analysisClassTotalItemVOList = new ArrayList<>();

        SysTaskExample sysTaskExample = new SysTaskExample();
        SysTaskExample.Criteria taskCri = sysTaskExample.createCriteria();
        taskCri.andTaskClassEqualTo(classId);
        sysTaskExample.setOrderByClause("task_create_at ASC");
        List<SysTask> taskList = sysTaskMapper.selectByExample(sysTaskExample);
        Integer order = 1;
        for (SysTask task : taskList) {
            AnalysisClassTotalItemVO analysisClassTotalItemVO = new AnalysisClassTotalItemVO();
            analysisClassTotalItemVO.setTaskCode(order++);
            analysisClassTotalItemVO.setTaskName(task.getTaskName());
            analysisClassTotalItemVO


        }
    }
}