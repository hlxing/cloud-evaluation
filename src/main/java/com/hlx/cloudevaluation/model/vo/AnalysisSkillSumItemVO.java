package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 每个评分维度的平均分、学生的该维度排名、学生的该维度分数-子视图
 * @author: hlx 2019-05-28
 **/
@Data
public class AnalysisSkillSumItemVO {

    @ApiModelProperty(notes = "维度名称")
    private String skillName;

    @ApiModelProperty(notes = "平均分")
    private Double averageScore;

    @ApiModelProperty(notes = "维度排名")
    private Integer rank;

    @ApiModelProperty(notes = "维度分数")
    private Double score;

}
