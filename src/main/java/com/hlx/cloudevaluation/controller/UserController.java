package com.hlx.cloudevaluation.controller;


import com.hlx.cloudevaluation.model.dto.*;
import com.hlx.cloudevaluation.model.po.ApiResult;
import com.hlx.cloudevaluation.model.vo.UserLoginVO;
import com.hlx.cloudevaluation.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @description: 用户控制层
 * @author: hlx 2019-01-20
 **/
@Slf4j
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "注册用户", notes = "学号15位，密码50位，学校100位，姓名20位")
    @PostMapping("/register")
    public ApiResult<String> register(@RequestBody @Valid UserRegisterDTO userRegisterDTO) {
        userService.register(userRegisterDTO);
        ApiResult<String> apiResult = new ApiResult<>();
        apiResult.setData("register success");
        return apiResult;
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public ApiResult<UserLoginVO> login(@RequestBody @Valid UserLoginDTO userLoginDTO, HttpServletRequest request) {
        UserLoginVO userLoginVO = userService.login(userLoginDTO, request);
        ApiResult<UserLoginVO> apiResult = new ApiResult<>();
        apiResult.setText("login success");
        apiResult.setData(userLoginVO);
        return apiResult;
    }

    @ApiOperation(value = "检测会话")
    @GetMapping("/tokenCheck")
    public ApiResult<String> tokenCheck() {
        return new ApiResult<>("token check success");
    }

}
