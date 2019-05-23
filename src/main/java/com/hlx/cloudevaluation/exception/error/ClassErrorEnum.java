package com.hlx.cloudevaluation.exception.error;

public enum ClassErrorEnum implements ApiError {

    CLASS_NO_EXIST(630, "CLASS_NO_EXIST"),

    // 已经授权
    EXIST_IN_CLASS_ROLE(632, "EXIST_IN_CLASS_ROLE"),

    // 班级 id 非法
    CLASS_ID_INVALID(633, "CLASS_ID_INVALID"),

    // token 错误
    TOKEN_INVALID(634, "TOKEN_INVALID"),

    // 学生信息未补充
    STU_INFO_LACK(635, "STU_INFO_LACK");

    // 响应码
    private final int code;

    // 提示信息
    private final String message;

    ClassErrorEnum(int code, String message) {
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
