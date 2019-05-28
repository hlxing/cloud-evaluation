package com.hlx.cloudevaluation.controller;

import com.hlx.cloudevaluation.model.po.ApiResult;
import com.hlx.cloudevaluation.model.vo.AnalysisTaskSkillAverageVO;
import com.hlx.cloudevaluation.model.vo.AnalysisTaskSkillVO;
import com.hlx.cloudevaluation.model.vo.AnalysisTaskTotalVO;
import com.hlx.cloudevaluation.service.AnalysisService;
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
@RequestMapping("/analysis")
public class AnalysisController {

    private AnalysisService analysisService;

    @Autowired
    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @ApiOperation(value = "单次作业分析", notes = "每个同学的总分的横向条形图")
    @RequiresRoles(value = {"teacher", "assistant"}, logical = Logical.OR)
    @GetMapping("task/total")
    public ApiResult<AnalysisTaskTotalVO> getTaskTotal(@RequestParam("taskId") Integer taskId, HttpSession session) {
        AnalysisTaskTotalVO taskTotalVO = analysisService.getTaskTotal(taskId, (Integer) session.getAttribute("userId"));
        ApiResult<AnalysisTaskTotalVO> apiResult = new ApiResult<>();
        apiResult.setData(taskTotalVO);
        return apiResult;
    }

    @ApiOperation(value = "单次作业分析", notes = "每个同学的不同分类的分数的横向条形图")
    @RequiresRoles(value = {"teacher", "assistant"}, logical = Logical.OR)
    @GetMapping("task/skill")
    public ApiResult<AnalysisTaskSkillVO> getTaskDetail(@RequestParam("taskId") Integer taskId,
                                                        @RequestParam("skillId") Integer skillId, HttpSession session) {
        AnalysisTaskSkillVO taskSkillVO = analysisService.getTaskDetail(taskId, skillId, (Integer) session.getAttribute("userId"));
        ApiResult<AnalysisTaskSkillVO> apiResult = new ApiResult<>();
        apiResult.setData(taskSkillVO);
        return apiResult;
    }

    @ApiOperation(value = "单次作业分析", notes = "每个评分维度的平均得分率")
    @RequiresRoles(value = {"teacher", "assistant"}, logical = Logical.OR)
    @GetMapping("task/skillAverage")
    public ApiResult<AnalysisTaskSkillAverageVO> getTaskSkillAverage(@RequestParam("taskId") Integer taskId, HttpSession session) {
        AnalysisTaskSkillAverageVO taskSkillAverageVO = analysisService.getTaskSkillAverage(taskId, (Integer) session.getAttribute("userId"));
        ApiResult<AnalysisTaskSkillAverageVO> apiResult = new ApiResult<>();
        apiResult.setData(taskSkillAverageVO);
        return apiResult;
    }


}
