package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: 作业状态视图
 * @author: hlx 2019-05-26
 **/
@Data
public class TaskStatusVO {

    @ApiModelProperty(notes = "团队打分列表", example = "...")
    private List<TaskStatusItemVO> taskStatusItemVOList;

    @ApiModelProperty(notes = "作业名称", example = "...")
    private String taskName;

    @ApiModelProperty(notes = "作业链接地址", example = "...")
    private String taskUrl;

    @ApiModelProperty(notes = "作业创建时间", example = "...")
    private Date taskCreateAt;

    @ApiModelProperty(notes = "作业截止时间", example = "...")
    private Date taskOverAt;

    @ApiModelProperty(notes = "作业修改时间", example = "...")
    private Date taskUpdateAt;

}
