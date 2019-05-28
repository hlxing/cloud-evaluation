package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 全班同学的总分子视图
 * @author: hlx 2019-05-28
 **/
@Data
public class AnalysisClassTotalItemVO {

    @ApiModelProperty(notes = "作业编号，0开始，根据发布时间递增")
    private Integer taskCode;

    @ApiModelProperty(notes = "作业名称")
    private String taskName;

    @ApiModelProperty(notes = "总分，作业得分的累加和")
    private Double totalScore;

    @ApiModelProperty(notes = "学号")
    private String userAccount;

}
