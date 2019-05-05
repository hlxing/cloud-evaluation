package com.hlx.cloudevaluation.controller;

import com.hlx.cloudevaluation.model.dto.TaskAddDTO;
import com.hlx.cloudevaluation.model.po.ApiResult;
import com.hlx.cloudevaluation.service.TaskService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
