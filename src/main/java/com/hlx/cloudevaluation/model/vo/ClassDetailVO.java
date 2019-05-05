package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: 班级详情视图
 * @author: hlx 2019-02-06
 **/
@Data
public class ClassDetailVO {

    @ApiModelProperty(notes = "班级用户信息列表")
    private List<ClassUserVO> classUserVOList;

    @ApiModelProperty(notes = "作业信息列表")
    private List<TaskVO> taskVOList;

    @ApiModelProperty(notes = "班级名称")
    private String className;

    @ApiModelProperty(notes = "学生 Token")
    private String classStuToken;

    @ApiModelProperty(notes = "助教 Token")
    private String classAssistantToken;

    @ApiModelProperty(notes = "团队信息是否可编辑")
    private Boolean classTeamEdit;

    @ApiModelProperty(notes = "班级创建时间")
    private Date classCreateAt;

    @ApiModelProperty(notes = "班级修改时间")
    private Date classUpdateAt;

    @ApiModelProperty(notes = "班级删除时间")
    private Date classDeleteAt;

    @ApiModelProperty(notes = "班级状态")
    private Boolean classExist;

}
