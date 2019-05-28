package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.model.vo.AnalysisTaskSkillAverageVO;
import com.hlx.cloudevaluation.model.vo.AnalysisTaskSkillVO;
import com.hlx.cloudevaluation.model.vo.AnalysisTaskTotalVO;
import com.hlx.cloudevaluation.service.AnalysisService;
import org.springframework.stereotype.Service;

/**
 * @description: 统计服务实现层
 * @author: hlx 2019-05-28
 **/
@Service
public class AnalysisServiceImpl implements AnalysisService {


    @Override
    public AnalysisTaskTotalVO getTaskTotal(Integer taskId, Integer userId) {
        return null;
    }

    @Override
    public AnalysisTaskSkillVO getTaskDetail(Integer taskId, Integer skillId, Integer userId) {
        return null;
    }

    @Override
    public AnalysisTaskSkillAverageVO getTaskSkillAverage(Integer taskId, Integer userId) {
        return null;
    }
}
