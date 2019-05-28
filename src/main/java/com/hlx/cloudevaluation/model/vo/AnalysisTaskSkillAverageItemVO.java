package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 本次作业、每个评分维度的平均得分率子视图
 * @author: hlx 2019-05-28
 **/
@Data
public class AnalysisTaskSkillAverageItemVO {

    @ApiModelProperty(notes = "维度")
    private String skillName;

    @ApiModelProperty(notes = "平均得分")
    private Double averageScore;

}
