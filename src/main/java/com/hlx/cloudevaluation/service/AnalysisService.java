package com.hlx.cloudevaluation.service;


import com.hlx.cloudevaluation.model.vo.AnalysisTaskSkillAverageVO;
import com.hlx.cloudevaluation.model.vo.AnalysisTaskSkillVO;
import com.hlx.cloudevaluation.model.vo.AnalysisTaskTotalVO;

/**
 * @description: 统计服务层
 * @author: hlx 2019-05-28
 **/
public interface AnalysisService {

    AnalysisTaskTotalVO getTaskTotal(Integer taskId, Integer userId);

    AnalysisTaskSkillVO getTaskDetail(Integer taskId, Integer skillId, Integer userId);

    AnalysisTaskSkillAverageVO getTaskSkillAverage(Integer taskId, Integer userId);

}
