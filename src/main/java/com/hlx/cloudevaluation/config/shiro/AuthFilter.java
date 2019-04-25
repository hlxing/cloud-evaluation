package com.hlx.cloudevaluation.config.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description: 认证拦截器, 拦截登录请求, 自定义登录逻辑
 * @author: hlx 2018-08-19
 **/
@Slf4j
public class AuthFilter extends AccessControlFilter{

    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        System.out.println(httpServletRequest.getRequestURI());
        // 获取session,且不自动创建
        HttpSession httpSession = httpServletRequest.getSession(false);
        // 无session代表请求头无session标志,或者该session标志无效(过期/错误)
        if (httpSession == null) {
            ((HttpServletResponse) response).setStatus(401);
            return false;
        }
        AuthToken authToken = new AuthToken(httpSession);
        //登录判断,错误则抛出异常
        getSubject(request, response).login(authToken);
        logger.info("token->>" + authToken + "登录验证成功");
        return true;
    }


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }
}
