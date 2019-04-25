package com.hlx.cloudevaluation.dao;

import com.hlx.cloudevaluation.model.po.User;
import org.apache.ibatis.annotations.Param;
/**
 * @description: 用户
 * @author: hlx 2019-01-20
 **/
public interface UserDao {

    void save(User user);

    User getByAccount(@Param("userAccount") String userAccount);

    String getSessionIdByUserId(Integer userId);

    void updateSessionIdByUserId(@Param("userId") Integer userId, @Param("sessionId") String sessionId);
}
