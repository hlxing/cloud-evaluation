package com.hlx.cloudevaluation.exception.error;


/**
 * @description: 用户错误枚举
 * @author: hlx 2018-10-02
 **/
public enum UserErrorEnum implements ApiError {

    // 用户名存在
    NICKNAME_EXIST(430,"NICKNAME_EXIST"),

    // 密码错误
    PASSWORD_ERROR(431,"PASSWORD_ERROR"),

    // 用户不存在
    USER_NO_EXIST(432, "USER_NO_EXIST");

    // 响应码
    private final int code;

    // 提示信息
    private final String message;

    UserErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMsg() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

}
