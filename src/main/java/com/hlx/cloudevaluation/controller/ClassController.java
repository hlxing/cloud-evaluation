package com.hlx.cloudevaluation.controller;

import com.hlx.cloudevaluation.model.dto.*;
import com.hlx.cloudevaluation.model.po.ApiResult;
import com.hlx.cloudevaluation.model.vo.ClassDetailVO;
import com.hlx.cloudevaluation.model.vo.ClassSearchVO;
import com.hlx.cloudevaluation.service.ClassService;
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

    @ApiOperation(value = "新建班级")
    @RequiresRoles("teacher")
    @PostMapping("/add")
    public ApiResult<String> add(@RequestBody @Valid ClassAddDTO classAddDTO, HttpSession session) {
        classService.add(classAddDTO, (Integer) session.getAttribute("userId"));
        return new ApiResult<>("add class success");
    }

    @ApiOperation(value = "编辑班级")
    @RequiresRoles("teacher")
    @PostMapping("/update")
    public ApiResult<String> update(@RequestBody @Valid ClassUpdateDTO classUpdateDTO, HttpSession session) {
        classService.update(classUpdateDTO, (Integer) session.getAttribute("userId"));
        return new ApiResult<>("update class success");
    }

    @ApiOperation(value = "删除班级")
    @RequiresRoles("teacher")
    @GetMapping("/delete")
    public ApiResult<String> delete(@RequestParam("classId") Integer classId, HttpSession session) {
        classService.delete(classId, (Integer) session.getAttribute("userId"));
        return new ApiResult<>("delete class success");
    }

    @ApiOperation(value = "班级查询")
    @PostMapping("/search")
    public ApiResult<ClassSearchVO> search(@RequestBody @Valid ClassSearchDTO classSearchDTO, HttpSession session) {
        ApiResult<ClassSearchVO> apiResult = new ApiResult<>();
        ClassSearchVO classSearchVO = classService.search(classSearchDTO, (Integer) session.getAttribute("userId"));
        apiResult.setData(classSearchVO);
        return apiResult;
    }

    @ApiOperation(value = "班级详情")
    @PostMapping("/detail")
    public ApiResult<ClassDetailVO> getDetail(@RequestBody @Valid ClassGetDetailDTO classGetDetailDTO, HttpSession session) {
        ApiResult<ClassDetailVO> apiResult = new ApiResult<>();
        ClassDetailVO classDetailVO = classService.getDetail(classGetDetailDTO, (Integer) session.getAttribute("userId"));
        apiResult.setData(classDetailVO);
        return apiResult;
    }

    @ApiOperation(value = "班级授权", notes = "授权成为班级的学生, 助教")
    @PostMapping("/auth")
    public ApiResult<String> auth(@RequestBody @Valid ClassAuthDTO classAuthDTO, HttpSession session) {
        classService.auth(classAuthDTO, (Integer) session.getAttribute("userId"));
        return new ApiResult<>("auth class success");
    }

}
