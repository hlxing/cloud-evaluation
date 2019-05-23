package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @description: 创建团队传输对象
 * @author: hlx 2019-05-23
 **/
@Data
public class TeamAddDTO {

    @NotNull
    @Size(min = 1, max = 64)
    @ApiModelProperty(required = true, notes = "团队名,最长64位", example = "不知道叫啥队")
    private String teamName;

    @NotNull
    @Min(1)
    @ApiModelProperty(required = true, notes = "团队限制人数", example = "5")
    private Integer teamLimit;

    @NotNull
    @ApiModelProperty(required = true, notes = "团队类型,结对（0）/团队（1）", example = "0")
    private Integer teamType;

}
