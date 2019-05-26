package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 技能得分视图
 * @author: hlx 2019-05-26
 **/
@Data
public class SkillScoreVO {

    @ApiModelProperty(value = "技能id")
    private Integer taskId;

    @ApiModelProperty(value = "技能名称")
    private String skillName;

    @ApiModelProperty(value = "技能类型")
    private String skillType;

    @ApiModelProperty(value = "技能简称")
    private String skillShortName;

    @ApiModelProperty(value = "技能在团队的得分")
    private Double ssScore;

    @ApiModelProperty(value = "技能根据贡献度计算后的实际得分")
    private Double ssRealScore;

}
