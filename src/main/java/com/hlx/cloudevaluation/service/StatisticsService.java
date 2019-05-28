package com.hlx.cloudevaluation.service;

import com.hlx.cloudevaluation.model.vo.TeacherTaskTotalVO;

/**
 * @description: 统计服务层
 * @author: hlx 2019-05-28
 **/
public interface StatisticsService {

    TeacherTaskTotalVO getTeacherTaskTotal(Integer taskId, Integer userId);
}
