package com.hlx.cloudevaluation.controller;

import com.hlx.cloudevaluation.model.dto.TaskAddDTO;
import com.hlx.cloudevaluation.model.dto.TaskEvaluateDTO;
import com.hlx.cloudevaluation.model.dto.TaskUpdateDTO;
import com.hlx.cloudevaluation.model.po.ApiResult;
import com.hlx.cloudevaluation.model.vo.*;
import com.hlx.cloudevaluation.service.TaskService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @description: 作业控制层
 * @author: hlx 2019-05-05
 **/
@Slf4j
@Validated
@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @ApiOperation(value = "添加作业")
    @RequiresRoles(value = {"teacher", "assistant"}, logical = Logical.OR)
    @PostMapping("/add")
    public ApiResult<String> add(@RequestBody @Valid TaskAddDTO taskAddDTO, HttpSession session) {
        taskService.add(taskAddDTO, (Integer) session.getAttribute("userId"));
        return new ApiResult<>("add task success");
    }

    @ApiOperation(value = "老师作业列表")
    @RequiresRoles(value = {"teacher", "assistant"}, logical = Logical.OR)
    @GetMapping("/list")
    public ApiResult<TaskSearchVO> getList(HttpSession session) {
        TaskSearchVO taskSearchVO = taskService.getList((Integer) session.getAttribute("userId"));
        ApiResult<TaskSearchVO> apiResult = new ApiResult<>();
        apiResult.setData(taskSearchVO);
        return apiResult;
    }

    @ApiOperation(value = "某班级的作业列表")
    @GetMapping("/classTask")
    public ApiResult<TaskSearchVO> getClassTask(@RequestParam("classId") Integer classId, HttpSession session) {
        TaskSearchVO taskSearchVO = taskService.getClassTask(classId, (Integer) session.getAttribute("userId"));
        ApiResult<TaskSearchVO> apiResult = new ApiResult<>();
        apiResult.setData(taskSearchVO);
        return apiResult;
    }


    @ApiOperation(value = "作业打分状态")
    @RequiresRoles(value = {"teacher", "assistant"}, logical = Logical.OR)
    @GetMapping("/status")
    public ApiResult<TaskStatusVO> getStatus(@RequestParam("taskId") Integer taskId) {
        TaskStatusVO taskStatusVO = taskService.getStatus(taskId);
        ApiResult<TaskStatusVO> apiResult = new ApiResult<>();
        apiResult.setData(taskStatusVO);
        return apiResult;
    }

    @ApiOperation(value = "作业团队打分状态")
    @RequiresRoles(value = {"teacher", "assistant"}, logical = Logical.OR)
    @GetMapping("/team/status")
    public ApiResult<TaskTeamStatusVO> getTeamStatus(@RequestParam("taskId") Integer taskId, @RequestParam("teamId") Integer teamId) {
        TaskTeamStatusVO taskTeamStatusVO = taskService.getTeamStatus(taskId, teamId);
        ApiResult<TaskTeamStatusVO> apiResult = new ApiResult<>();
        apiResult.setData(taskTeamStatusVO);
        return apiResult;
    }

    @ApiOperation(value = "作业打分")
    @RequiresRoles(value = {"teacher", "assistant"}, logical = Logical.OR)
    @PostMapping("/evaluate")
    public ApiResult<String> evaluate(@Valid @RequestBody TaskEvaluateDTO taskEvaluateDTO) {
        taskService.evaluate(taskEvaluateDTO);
        return new ApiResult<>("evaluate success");
    }

    @ApiOperation(value = "作业删除")
    @RequiresRoles(value = {"teacher", "assistant"}, logical = Logical.OR)
    @GetMapping("/delete")
    public ApiResult<String> delete(@RequestParam("taskId") Integer taskId) {
        taskService.delete(taskId);
        return new ApiResult<>("delete task success");
    }

    @ApiOperation(value = "作业修改")
    @RequiresRoles(value = {"teacher", "assistant"}, logical = Logical.OR)
    @GetMapping("/update")
    public ApiResult<String> update(@Valid @RequestBody TaskUpdateDTO taskUpdateDTO) {
        taskService.update(taskUpdateDTO);
        return new ApiResult<>("delete task success");
    }

    @ApiOperation(value = "老师作业查看")
    @RequiresRoles(value = {"teacher", "assistant"}, logical = Logical.OR)
    @GetMapping("/detail")
    public ApiResult<TaskDetailVO> getDetail(@RequestParam("taskId") Integer taskId, HttpSession session) {
        TaskDetailVO taskDetailVO = taskService.getDetail(taskId, (Integer) session.getAttribute("userId"));
        ApiResult<TaskDetailVO> apiResult = new ApiResult<>();
        apiResult.setData(taskDetailVO);
        return apiResult;
    }

    @ApiOperation(value = "作业维度查看")
    @GetMapping("/skill/list")
    public ApiResult<TaskSkillListVO> getSkillList(@RequestParam("taskId") Integer taskId) {
        TaskSkillListVO skillListVO = taskService.getSkillList(taskId);
        ApiResult<TaskSkillListVO> apiResult = new ApiResult<>();
        apiResult.setData(skillListVO);
        return apiResult;
    }


    @ApiOperation(value = "学生作业查看")
    @GetMapping("/search")
    public ApiResult<TaskSearchVO> search(HttpSession session) {
        TaskSearchVO taskSearchVO = taskService.search((Integer) session.getAttribute("userId"));
        ApiResult<TaskSearchVO> apiResult = new ApiResult<>();
        apiResult.setData(taskSearchVO);
        return apiResult;
    }

    @ApiOperation(value = "学生作业打分查看")
    @GetMapping("/score")
    public ApiResult<TaskScoreVO> getScore(@RequestParam("taskId") Integer taskId, HttpSession session) {
        TaskScoreVO taskScoreVO = taskService.getScore(taskId, (Integer) session.getAttribute("userId"));
        ApiResult<TaskScoreVO> apiResult = new ApiResult<>();
        apiResult.setData(taskScoreVO);
        return apiResult;
    }

}
