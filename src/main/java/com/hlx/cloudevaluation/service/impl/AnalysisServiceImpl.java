package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.dao.UserDao;
import com.hlx.cloudevaluation.mapper.SkillScoreMapper;
import com.hlx.cloudevaluation.mapper.SysSkillMapper;
import com.hlx.cloudevaluation.mapper.UserScoreMapper;
import com.hlx.cloudevaluation.model.po.SkillScore;
import com.hlx.cloudevaluation.model.po.SkillScoreExample;
import com.hlx.cloudevaluation.model.po.UserScore;
import com.hlx.cloudevaluation.model.po.UserScoreExample;
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

    @Autowired
    public AnalysisServiceImpl(UserScoreMapper userScoreMapper, UserDao userDao, SkillScoreMapper skillScoreMapper,
                               SysSkillMapper sysSkillMapper) {
        this.userScoreMapper = userScoreMapper;
        this.userDao = userDao;
        this.skillScoreMapper = skillScoreMapper;
        this.sysSkillMapper = sysSkillMapper;
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
}