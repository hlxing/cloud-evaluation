package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 本次作业的总分的平均分、学生的总分排名、学生的总分分数-视图
 * @author: hlx 2019-05-28
 **/
@Data
public class AnalysisTaskSumVO {

    @ApiModelProperty(notes = "平均分")
    private Double averageScore;

    @ApiModelProperty(notes = "排名")
    private Integer rank;

    @ApiModelProperty(notes = "总分")
    private Double totalScore;

}
