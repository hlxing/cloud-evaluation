package com.hlx.cloudevaluation.controller;

import com.hlx.cloudevaluation.model.po.ApiResult;
import com.hlx.cloudevaluation.model.vo.TeacherTaskTotalVO;
import com.hlx.cloudevaluation.service.StatisticsService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @description: 统计控制层
 * @author: hlx 2019-05-28
 **/
@Slf4j
@Validated
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @ApiOperation(value = "单次作业分析", notes = "每个同学的总分的横向条形图")
    @RequiresRoles(value = {"teacher", "assistant"}, logical = Logical.OR)
    @GetMapping("/teacher/task/total")
    public ApiResult<TeacherTaskTotalVO> getTeacherTaskTotal(@RequestParam("taskId") Integer taskId, HttpSession session) {
        TeacherTaskTotalVO teacherTaskTotalVO = statisticsService.getTeacherTaskTotal(taskId, (Integer) session.getAttribute("userId"));
        ApiResult<TeacherTaskTotalVO> apiResult = new ApiResult<>();
        apiResult.setData(teacherTaskTotalVO);
        return apiResult;
    }


}
