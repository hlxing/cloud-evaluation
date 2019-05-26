package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: 作业贡献度传输对象
 * @author: hlx 2019-05-26
 **/
@Data
public class TaskContributeDTO {

    @NotNull
    @ApiModelProperty(required = true, notes = "用户id")
    private Integer userId;

    @NotNull
    @ApiModelProperty(required = true, notes = "用户贡献度")
    private Double usContribute;

}
