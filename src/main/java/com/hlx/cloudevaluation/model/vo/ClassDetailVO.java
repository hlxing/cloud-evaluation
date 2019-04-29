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

    @ApiModelProperty(notes = "当前页数", example = "1")
    private Integer pageNum;

    @ApiModelProperty(notes = "最大页数", example = "5")
    private Integer maxPageNum;

    @ApiModelProperty(notes = "班级名称")
    private String className;

    @ApiModelProperty(notes = "班级创建时间")
    private Date classCreateAt;

    @ApiModelProperty(notes = "班级修改时间")
    private Date classUpdateAt;

    @ApiModelProperty(notes = "班级删除时间")
    private Date classDeleteAt;

}
