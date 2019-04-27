package com.hlx.cloudevaluation.exception.error;


/**
 * @description: 技能错误枚举
 * @author: hlx 2018-10-02
 **/
public enum SkillErrorEnum implements ApiError {

    // id 不存在
    SKILL_ID_NO_EXIST(530, "SKILL_ID_NO_EXIST");

    // 响应码
    private final int code;

    // 提示信息
    private final String message;

    SkillErrorEnum(int code, String message) {
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
