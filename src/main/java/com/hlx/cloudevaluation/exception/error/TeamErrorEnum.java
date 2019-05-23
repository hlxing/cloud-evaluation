package com.hlx.cloudevaluation.exception.error;


/**
 * @description: 团队错误枚举
 * @author: hlx 2018-10-02
 **/
public enum TeamErrorEnum implements ApiError {

    // 团队名重复
    TEAM_NAME_EXIST(730, "TEAM_NAME_EXIST"),

    // 不存在活动班级
    ACTIVE_CLASS_NOT_EXIST(731, "ACTIVE_CLASS_NOT_EXIST"),

    // 班级中团队信息不允许修改
    CLASS_TEAM_LIMIT(732, "CLASS_TEAM_LIMIT");

    // 响应码
    private final int code;

    // 提示信息
    private final String message;

    TeamErrorEnum(int code, String message) {
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
