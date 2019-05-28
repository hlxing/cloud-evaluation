package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 老师针对同学不同分类的分数子视图
 * @author: hlx 2019-05-28
 **/
@Data
public class AnalysisTaskSkillItemVO {

    @ApiModelProperty(notes = "学号")
    private String userAccount;

    @ApiModelProperty(notes = "得分")
    private Double score;
}
