package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 老师针对同学总分分析子视图
 * @author: hlx 2019-05-28
 **/
@Data
public class AnalysisTaskTotalItemVO {

    @ApiModelProperty(notes = "学号")
    private String userAccount;

    @ApiModelProperty(notes = "总得分")
    private Double usFinalScore;

}
