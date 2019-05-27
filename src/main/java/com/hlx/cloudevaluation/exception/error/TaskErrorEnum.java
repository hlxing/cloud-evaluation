package com.hlx.cloudevaluation.exception.error;

public enum TaskErrorEnum implements ApiError {

    //评分后不能删除作业
    NOT_DELETE_AFTER_SCORE(800, "NOT_DELETE_AFTER_SCORE");

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
