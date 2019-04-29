package com.hlx.cloudevaluation.controller;

import com.hlx.cloudevaluation.model.dto.ClassAddDTO;
import com.hlx.cloudevaluation.model.po.ApiResult;
import com.hlx.cloudevaluation.service.ClassService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @description: 班级控制器
 * @author: hlx 2019-04-29
 **/
@Slf4j
@Validated
@RestController
@RequestMapping("/class")
public class ClassController {

    private ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @ApiOperation(value = "新建班级", notes = "学号15位，密码50位，学校100位，姓名20位")
    @PostMapping("/add")
    public ApiResult<String> add(@RequestBody @Valid ClassAddDTO classAddDTO, HttpSession session) {
        classService.add(classAddDTO, (Integer) session.getAttribute("userId"));
        return new ApiResult<>("add class success");
    }


}
