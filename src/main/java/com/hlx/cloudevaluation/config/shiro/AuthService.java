package com.hlx.cloudevaluation.config.shiro;

import com.hlx.cloudevaluation.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 认证服务实现
 * @author: hlx 2018-08-19
 **/
@Slf4j
@Service
public class AuthService extends AuthorizingRealm {

    private UserDao userDao;

    @Autowired
    public AuthService(UserDao userDao) {
        this.userDao = userDao;
    }

    //判断支持的token类型
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AuthToken;
    }

    //根据身份(用户名)获取角色和权限,即权限判断
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Integer userId = Integer.valueOf(principalCollection.toString());

        log.info("用户:" + userId + "权限判断服务");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();


        // TODO : 用户角色权限
//        UserRole userRole = userDao.getRole(userId);
//        if (userRole != null) {
//            Set<String> roles = new HashSet<>();
//            Set<String> permissions = new HashSet<>();
//            String[] roleStr = userRole.getRole()
//                    .split(" ");
//            String[] permissionStr = userRole.getPermission()
//                    .split(" ");
//            roles.addAll(Arrays.asList(roleStr));
//            permissions.addAll(Arrays.asList(permissionStr));
//            simpleAuthorizationInfo.setRoles(roles);
//            simpleAuthorizationInfo.setStringPermissions(permissions);
//        }

        log.info("Role->>" + simpleAuthorizationInfo.getRoles());
        log.info("permission->>" + simpleAuthorizationInfo.getStringPermissions());
        return simpleAuthorizationInfo;
    }

    /**
     * 定义获取用户信息的逻辑,即登录判断(token合法性),错误直接抛出异常(原意)
     *
     * 由于Spring-Session在Restful下的特殊性, {@link (AuthFilter)}在onAccessDenied方法中
     * 已经通过检测session合法性来判断是否登录,此函数仅用来包装SimpleAuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name = authenticationToken.getPrincipal()
                 .toString();
        String token = authenticationToken.getCredentials()
                .toString();
        // SimpleAuthenticationInfo用于后面权限判断,第三个参数为Realm Name
        return new SimpleAuthenticationInfo(name,token,"auService");
    }
}
