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

    private ClassUserMapper classUserMapper;

    @Autowired
    public AnalysisServiceImpl(UserScoreMapper userScoreMapper, UserDao userDao, SkillScoreMapper skillScoreMapper,
                               SysSkillMapper sysSkillMapper, SysTaskMapper sysTaskMapper, TaskSkillMapper taskSkillMapper,
                               ClassUserMapper classUserMapper) {
        this.userScoreMapper = userScoreMapper;
        this.userDao = userDao;
        this.skillScoreMapper = skillScoreMapper;
        this.sysSkillMapper = sysSkillMapper;
        this.sysTaskMapper = sysTaskMapper;
        this.taskSkillMapper = taskSkillMapper;
        this.classUserMapper = classUserMapper;
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
    public AnalysisTaskSumVO getTaskSum(Integer taskId, Integer userId) {
        UserScoreExample userScoreExample = new UserScoreExample();
        UserScoreExample.Criteria userScoreCriteria = userScoreExample.createCriteria();
        userScoreCriteria.andTaskIdEqualTo(taskId);
        Integer taskNum = userScoreMapper.countByExample(userScoreExample);
        if (taskNum == 0) {
            return new AnalysisTaskSumVO();
        }
        AnalysisTaskSumVO taskSumVO = new AnalysisTaskSumVO();
        Double sumScore = userScoreMapper.selectSumScoreByTaskId(taskId);
        taskSumVO.setAverageScore(sumScore / taskNum);

        Double totalScore = 0.0;
        userScoreExample.clear();
        userScoreCriteria.andTaskIdEqualTo(taskId);
        userScoreCriteria.andUserIdEqualTo(userId);
        List<UserScore> userScoreList = userScoreMapper.selectByExample(userScoreExample);
        if (userScoreList.size() > 0) {
            totalScore = userScoreList.get(0).getUsFinalScore();
        }
        Integer rank = userScoreMapper.selectCountByScore(totalScore) + 1;
        taskSumVO.setRank(rank);
        taskSumVO.setTotalScore(totalScore);
        return taskSumVO;
    }


    @Override
    public AnalysisClassSkillAverageVO getClassSkillAverage(Integer classId, Integer skillId) {
        AnalysisClassSkillAverageVO analysisClassSkillAverageVO = new AnalysisClassSkillAverageVO();
        List<AnalysisClassSkillAverageItemVO> analysisClassSkillAverageItemVOList = new ArrayList<>();

        SysTaskExample sysTaskExample = new SysTaskExample();
        SysTaskExample.Criteria taskCri = sysTaskExample.createCriteria();
        taskCri.andTaskClassEqualTo(classId);
        List<SysTask> taskList = sysTaskMapper.selectByExample(sysTaskExample);

        for (SysTask task : taskList) {
            AnalysisClassSkillAverageItemVO analysisClasSkillAverageItemVO = new AnalysisClassSkillAverageItemVO();

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
            analysisClassSkillAverageItemVOList.add(analysisClasSkillAverageItemVO);
        }

        analysisClassSkillAverageVO.setClassTaskSkillAverageItemVOList(analysisClassSkillAverageItemVOList);
        return analysisClassSkillAverageVO;
    }

    @Override
    public AnalysisClassTotalVO getClassTotal(Integer classId) {

        AnalysisClassTotalVO analysisClassTotalVO = new AnalysisClassTotalVO();
        Map<String, List<AnalysisClassTotalItemVO>> map = new HashMap<>();

        ClassUserExample classUserExample = new ClassUserExample();
        ClassUserExample.Criteria cuCri = classUserExample.createCriteria();
        cuCri.andClassIdEqualTo(classId);
        //班级下有哪些学生
        List<ClassUser> classUserList = classUserMapper.selectByExample(classUserExample);

        SysTaskExample sysTaskExample = new SysTaskExample();
        SysTaskExample.Criteria taskCri = sysTaskExample.createCriteria();
        taskCri.andTaskClassEqualTo(classId);
        sysTaskExample.setOrderByClause("task_create_at ASC");
        List<SysTask> taskList = sysTaskMapper.selectByExample(sysTaskExample);

        Integer index = 0;
        for (ClassUser classUser : classUserList) {
            for (SysTask task : taskList) {
                AnalysisClassTotalItemVO analysisClassTotalItemVO = new AnalysisClassTotalItemVO();
                UserScoreExample userScoreExample = new UserScoreExample();
                UserScoreExample.Criteria usCri = userScoreExample.createCriteria();
                usCri.andTaskIdEqualTo(task.getTaskId());
                usCri.andUserIdEqualTo(classUser.getUserId());
                List<UserScore> userScoreList = userScoreMapper.selectByExample(userScoreExample);
                if (userScoreList.size() == 0) {
                    //这个学生的这次作业没评分
                    analysisClassTotalItemVO.setTotalScore(0.0);
                } else {
                    analysisClassTotalItemVO.setTotalScore(userScoreList.get(0).getUsFinalScore());
                }
                analysisClassTotalItemVO.setTaskCode(++index);
                analysisClassTotalItemVO.setTaskName(task.getTaskName());
                String account = userDao.get(classUser.getUserId()).getUserAccount();
                if (map.get(account) != null) {
                    List<AnalysisClassTotalItemVO> add = map.get(account);
                    add.add(analysisClassTotalItemVO);
                    map.put(account, add);
                } else {
                    List<AnalysisClassTotalItemVO> add = new ArrayList<>();
                    add.add(analysisClassTotalItemVO);
                    map.put(account, add);
                }
            }
        }

        //累加处理
        for (String account : map.keySet()) {
            List<AnalysisClassTotalItemVO> add = map.get(account);
            for (int i = 1; i < add.size(); ++i) {
                Double pre = add.get(i - 1).getTotalScore();
                AnalysisClassTotalItemVO temp = add.get(i);
                temp.setTotalScore(temp.getTotalScore() + pre);
                add.set(i, temp);
            }
        }
        analysisClassTotalVO.setClassTaskTotalMap(map);

        return analysisClassTotalVO;
    }

    @Override
    public AnalysisSkillSumVO getSkillSum(Integer taskId, Integer userId) {
        AnalysisSkillSumVO analysisSkillSumVO = new AnalysisSkillSumVO();
        List<AnalysisSkillSumItemVO> analysisSkillSumItemVOList = new ArrayList<>();

        TaskSkillExample taskSkillExample = new TaskSkillExample();
        TaskSkillExample.Criteria tsCri = taskSkillExample.createCriteria();
        tsCri.andTaskIdEqualTo(taskId);
        List<TaskSkill> taskSkillList = taskSkillMapper.selectByExample(taskSkillExample);

        for (TaskSkill taskSkill : taskSkillList) {
            AnalysisSkillSumItemVO analysisSkillSumItemVO = new AnalysisSkillSumItemVO();

            SysSkill skill = sysSkillMapper.selectByPrimaryKey(taskSkill.getSkillId());
            analysisSkillSumItemVO.setSkillName(skill.getSkillName());

            SkillScoreExample skillScoreExample = new SkillScoreExample();
            SkillScoreExample.Criteria ssCri = skillScoreExample.createCriteria();
            ssCri.andTaskIdEqualTo(taskId);
            ssCri.andSkillIdEqualTo(taskSkill.getSkillId());
            ssCri.andUserIdEqualTo(userId);

            List<SkillScore> skillScoreList = skillScoreMapper.selectByExample(skillScoreExample);
            Integer rank = 0;
            if (skillScoreList.size() == 0) {
                //未评分
                analysisSkillSumItemVO.setScore(0.0);
            } else {
                analysisSkillSumItemVO.setScore(skillScoreList.get(0).getSsRealScore());
                rank = skillScoreMapper.getRankBySkill(skillScoreList.get(0).getSsRealScore(), taskId, taskSkill.getSkillId()) + 1;
            }

            analysisSkillSumItemVO.setRank(rank);

            SkillScoreExample averageExample = new SkillScoreExample();
            SkillScoreExample.Criteria averageCri = averageExample.createCriteria();
            averageCri.andSkillIdEqualTo(taskSkill.getSkillId());
            averageCri.andTaskIdEqualTo(taskId);
            List<SkillScore> skillScores = skillScoreMapper.selectByExample(averageExample);
            Double sum = 0.0;
            for (SkillScore skillScore : skillScores) {
                sum += skillScore.getSsRealScore();
            }
            if (skillScores.size() > 0) {
                analysisSkillSumItemVO.setAverageScore(sum / skillScores.size());
            } else {
                analysisSkillSumItemVO.setAverageScore(0.0);
            }

            analysisSkillSumItemVOList.add(analysisSkillSumItemVO);
        }
        analysisSkillSumVO.setSkillSumItemVOList(analysisSkillSumItemVOList);
        return analysisSkillSumVO;
    }
}