package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: 团队视图
 * @author: hlx 2019-05-26
 **/
@Data
public class TeamVO {

    @NotNull
    @ApiModelProperty(notes = "团队id")
    private Integer teamId;

    @NotNull
    @ApiModelProperty(notes = "团队名称")
    private String teamName;

    @NotNull
    @ApiModelProperty(notes = "团队大小(人数)")
    private Integer teamSize;

    @NotNull
    @ApiModelProperty(notes = "团队队长名称")
    private String teamCaptain;

    @NotNull
    @ApiModelProperty(notes = "团队类型")
    private Integer teamType;
}
