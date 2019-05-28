package com.hlx.cloudevaluation.service;


import com.hlx.cloudevaluation.model.vo.*;

/**
 * @description: 统计服务层
 * @author: hlx 2019-05-28
 **/
public interface AnalysisService {

    AnalysisTaskTotalVO getTaskTotal(Integer taskId, Integer userId);

    AnalysisTaskSkillVO getTaskDetail(Integer taskId, Integer skillId, Integer userId);

    AnalysisTaskSkillAverageVO getTaskSkillAverage(Integer taskId, Integer userId);

    AnalysisClassSkillAverageVO getClassSkillAverage(Integer classId, Integer skillId);

    AnalysisClassTotalVO getClassTotal(Integer classId);

    AnalysisTaskSumVO getTaskSum(Integer taskId, Integer userId);

    AnalysisSkillSumVO getSkillSum(Integer taskId, Integer userId);
}
