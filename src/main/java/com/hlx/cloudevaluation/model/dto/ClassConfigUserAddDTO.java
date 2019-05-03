package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @description: 班级用户配置信息传输对象
 * @author: hlx 2019-05-03
 **/
@Data
public class ClassConfigUserAddDTO {

    @NotNull
    @Size(min = 1, max = 16)
    @ApiModelProperty(required = true, notes = "配置名称", example = "Github")
    private String classConfigName;

    @NotNull
    @Size(min = 1, max = 64)
    @ApiModelProperty(required = true, notes = "配置内容", example = "http://....")
    private String classConfigValue;

}
