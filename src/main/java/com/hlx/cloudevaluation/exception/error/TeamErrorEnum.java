package com.hlx.cloudevaluation.exception.error;


/**
 * @description: 团队错误枚举
 * @author: hlx 2018-10-02
 **/
public enum TeamErrorEnum implements ApiError {

    // 团队名重复
    TEAM_NAME_EXIST(730, "TEAM_NAME_EXIST"),

    // 学生还未加入班级
    ACTIVE_CLASS_NOT_EXIST(731, "ACTIVE_CLASS_NOT_EXIST"),

    // 班级中团队信息不允许修改
    CLASS_TEAM_EDIT_LIMIT(732, "CLASS_TEAM_EDIT_LIMIT"),

    // token 非法
    TOKEN_INVALID(733, "TOKEN_INVALID"),

    // 团队已存在
    TEAM_EXIST(734, "TEAM_EXIST"),

    // 团队人数限制
    TEAM_NUMBER_LIMIT(735, "TEAM_NUMBER_LIMIT"),

    // 团队中团队信息不允许修改
    TEAM_EDIT_LIMIT(736, "TEAM_EDIT_LIMIT"),

    // 学生不存在团队
    TEAM_NOT_EXIST(737, "TEAM_NOT_EXIST");

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
