package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.dao.UserDao;
import com.hlx.cloudevaluation.exception.error.ApiException;
import com.hlx.cloudevaluation.exception.error.UserErrorEnum;
import com.hlx.cloudevaluation.model.dto.UserLoginDTO;
import com.hlx.cloudevaluation.model.dto.UserRegisterDTO;
import com.hlx.cloudevaluation.model.po.User;
import com.hlx.cloudevaluation.model.vo.UserLoginVO;
import com.hlx.cloudevaluation.service.UserService;
import com.hlx.cloudevaluation.util.AESUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description: 用户服务实现
 * @author: hlx 2019-01-20
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private ModelMapper modelMapper;

    // 数据库session-AES-密钥
    private static final String SESSION_PWD = "8X1V2EoXH79CZ3zS";

    // Spring-Session-Redis操作DAO,管理控制session
    private RedisOperationsSessionRepository sessionRepository;

    @Autowired
    public UserServiceImpl(UserDao userDao, ModelMapper modelMapper,
                           RedisOperationsSessionRepository sessionRepository) {
        this.userDao = userDao;
        this.modelMapper = modelMapper;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        User test = userDao.getByAccount(userRegisterDTO.getUserAccount());
        if (test != null) {
            throw new ApiException(UserErrorEnum.NICKNAME_EXIST);
        } else {
            String encryptPass = DigestUtils.sha1Hex(userRegisterDTO.getUserPass());
            userRegisterDTO.setUserPass(encryptPass);
            User user = modelMapper.map(userRegisterDTO, User.class);
            userDao.save(user);
        }
    }

    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO, HttpServletRequest request) {
        User rightUser = userDao.getByAccount(userLoginDTO.getUserAccount());
        String encryptPass = DigestUtils.sha1Hex(userLoginDTO.getUserPass());
        if (rightUser == null) {
            throw new ApiException(UserErrorEnum.USER_NO_EXIST);
        } else if (!rightUser.getUserPass().equals(encryptPass)) {
            throw new ApiException(UserErrorEnum.PASSWORD_ERROR);
        } else {
            initSession(request, rightUser.getUserId());
        }
        return modelMapper.map(rightUser, UserLoginVO.class);
    }

    private void initSession(HttpServletRequest request, Integer userId) {
        // 清除已有的sessionID,保证同一时间一处登录
        String sessionId = userDao.getSessionIdByUserId(userId);
        if (sessionId != null) {
            // 解密AES-Session
            sessionId = AESUtil.decrypt(sessionId, SESSION_PWD);
            sessionRepository.deleteById(sessionId);
        }

        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("userId", userId);

        String encryptSessionId = AESUtil.encrypt(httpSession.getId(), SESSION_PWD);
        userDao.updateSessionIdByUserId(userId, encryptSessionId);

    }

}
