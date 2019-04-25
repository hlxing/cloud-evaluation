package com.hlx.cloudevaluation.service;


import com.hlx.cloudevaluation.model.dto.UserLoginDTO;
import com.hlx.cloudevaluation.model.dto.UserRegisterDTO;
import com.hlx.cloudevaluation.model.vo.UserLoginVO;
import javax.servlet.http.HttpServletRequest;

/**
 * @description: 用户服务接口
 * @author: hlx 2019-01-20
 **/
public interface UserService {

    void register(UserRegisterDTO userRegisterDTO);

    UserLoginVO login(UserLoginDTO userLoginDTO, HttpServletRequest request);
}
