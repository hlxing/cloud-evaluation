package com.hlx.cloudevaluation.controller;

import com.hlx.cloudevaluation.model.po.ApiResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 连接控制层
 * @author: hlx 2019-02-15
 **/
@Slf4j
@RestController
@RequestMapping("/connect")
public class ConnectController {

    @ApiOperation(value = "请求测试")
    @GetMapping("/test")
    public ApiResult<String> test() {
        log.info("测试请求成功!");
        return new ApiResult<>("Test Success");
    }

    @ApiOperation(value = "登录测试")
    @GetMapping("/testLogin")
    public ApiResult<String> testLogin() {
        log.info("测试登录成功!");
        return new ApiResult<>("Test Login Success");
    }

    @ApiOperation(value = "admin权限测试")
    @RequiresPermissions("user:add")
    @GetMapping("/testAdmin")
    public ApiResult<String> testAdmin() {
        log.info("测试管理员权限成功!");
        return new ApiResult<>("Test Admin Success");
    }

}
