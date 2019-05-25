package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: 团队详情视图
 * @author: hlx 2019-05-23
 **/
@Data
public class TeamDetailVO {

    @ApiModelProperty(notes = "班级用户信息列表")
    private List<TeamUserVO> classUserVOList;

    @ApiModelProperty(notes = "团队id")
    private Integer teamId;

    @ApiModelProperty(notes = "团队token")
    private String teamToken;

    @ApiModelProperty(notes = "团队限制人数")
    private Integer teamLimit;

    @ApiModelProperty(notes = "团队队长Id")
    private Integer teamCaptain;

    @ApiModelProperty(notes = "团队类型，结对（0）/团队（1）")
    private Integer teamType;

    @ApiModelProperty(notes = "团队是否可编辑")
    private Boolean teamEdit;

    @ApiModelProperty(notes = "团队状态，0不存在，1存在")
    private Boolean teamExit;

    private Date teamCreateAt;

    private Date teamUpdateAt;

    private Date teamDeleteAt;

}
