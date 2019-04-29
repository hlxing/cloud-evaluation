package com.hlx.cloudevaluation.exception.error;

public enum ClassErrorEnum implements ApiError {

    CLASS_NO_EXIST(630, "CLASS_NO_EXIST"),

    //学生已存在
    STU_EXIST(631, "STU_EXIST"),

    EXIST_IN_CLASS_ROLE(632, "EXIST_IN_CLASS_ROLE");

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