package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 整个班级而言，每一次作业、不同的评分维度的平均得分率的视图
 * @author: hlx 2019-05-28
 **/
@Data
public class AnalysisClassSkillAverageItemVO {

    @ApiModelProperty(notes = "作业编号，0开始，根据发布时间递增")
    private Integer taskCode;

    @ApiModelProperty(notes = "作业id")
    private Integer taskId;

    @ApiModelProperty(notes = "作业名称")
    private String taskName;

    @ApiModelProperty(notes = "维度得分")
    private Double score;

}
