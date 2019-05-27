package com.hlx.cloudevaluation.controller;

import com.hlx.cloudevaluation.model.dto.TaskAddDTO;
import com.hlx.cloudevaluation.model.dto.TaskEvaluateDTO;
import com.hlx.cloudevaluation.model.dto.TaskUpdateDTO;
import com.hlx.cloudevaluation.model.po.ApiResult;
import com.hlx.cloudevaluation.model.vo.TaskScoreVO;
import com.hlx.cloudevaluation.model.vo.TaskSearchVO;
import com.hlx.cloudevaluation.model.vo.TaskStatusVO;
import com.hlx.cloudevaluation.model.vo.TaskTeamStatusVO;
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

    @ApiOperation(value = "作业打分状态")
    @GetMapping("/status")
    public ApiResult<TaskStatusVO> getStatus(@RequestParam("taskId") Integer taskId) {
        TaskStatusVO taskStatusVO = taskService.getStatus(taskId);
        ApiResult<TaskStatusVO> apiResult = new ApiResult<>();
        apiResult.setData(taskStatusVO);
        return apiResult;
    }

    @ApiOperation(value = "作业团队打分状态")
    @GetMapping("/team/status")
    public ApiResult<TaskTeamStatusVO> getTeamStatus(@RequestParam("taskId") Integer taskId, @RequestParam("teamId") Integer teamId) {
        TaskTeamStatusVO taskTeamStatusVO = taskService.getTeamStatus(taskId, teamId);
        ApiResult<TaskTeamStatusVO> apiResult = new ApiResult<>();
        apiResult.setData(taskTeamStatusVO);
        return apiResult;
    }

    @ApiOperation(value = "作业打分")
    @PostMapping("/evaluate")
    public ApiResult<String> evaluate(@Valid @RequestBody TaskEvaluateDTO taskEvaluateDTO) {
        taskService.evaluate(taskEvaluateDTO);
        return new ApiResult<>("evaluate success");
    }

    @ApiOperation(value = "作业删除")
    @GetMapping("/delete")
    public ApiResult<String> delete(@RequestParam("taskId") Integer taskId) {
        taskService.delete(taskId);
        return new ApiResult<>("delete task success");
    }

    @ApiOperation(value = "作业修改")
    @GetMapping("/update")
    public ApiResult<String> update(@Valid @RequestBody TaskUpdateDTO taskUpdateDTO) {
        taskService.update(taskUpdateDTO);
        return new ApiResult<>("delete task success");
    }


    @ApiOperation(value = "作业查看")
    @GetMapping("/search")
    public ApiResult<TaskSearchVO> search(HttpSession session) {
        TaskSearchVO taskSearchVO = taskService.search((Integer) session.getAttribute("userId"));
        ApiResult<TaskSearchVO> apiResult = new ApiResult<>();
        apiResult.setData(taskSearchVO);
        return apiResult;
    }

    @ApiOperation(value = "作业打分查看")
    @GetMapping("/score")
    public ApiResult<TaskScoreVO> getScore(@RequestParam("taskId") String taskId, HttpSession session) {
        TaskScoreVO taskScoreVO = taskService.getScore(taskId, (Integer) session.getAttribute("userId"));
        ApiResult<TaskScoreVO> apiResult = new ApiResult<>();
        apiResult.setData(taskScoreVO);
        return apiResult;
    }

}
