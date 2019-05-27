package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 作业技能得分视图
 * @author: hlx 2019-05-26
 **/
@Data
public class TaskSkillScoreVO {

    @ApiModelProperty(value = "技能id")
    private Integer skillId;

    @ApiModelProperty(value = "技能名称")
    private String skillName;

    @ApiModelProperty(value = "技能类型")
    private String skillType;

    @ApiModelProperty(value = "技能简称")
    private String skillShortName;

    @ApiModelProperty(value = "技能在团队的得分")
    private Double ssScore;

}