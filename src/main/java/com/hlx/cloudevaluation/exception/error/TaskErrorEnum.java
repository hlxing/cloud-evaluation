package com.hlx.cloudevaluation.exception.error;

public enum TaskErrorEnum implements ApiError {

    // 评分后不能删除作业
    NOT_DELETE_AFTER_SCORE(830, "NOT_DELETE_AFTER_SCORE"),

    // 作业ID不存在
    TASK_ID_INVALID(831, "TASK_ID_INVALID"),

    // 非作者创建者
    NOT_TASK_CREATOR(832, "NOT_TASK_CREATOR");

    // 响应码
    private final int code;

    // 提示信息
    private final String message;

    TaskErrorEnum(int code, String message) {
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
