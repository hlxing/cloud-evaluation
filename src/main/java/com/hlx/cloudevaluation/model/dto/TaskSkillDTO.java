package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 作业技能评分传输对象
 * @author: hlx 2019-05-26
 **/
@Data
public class TaskSkillDTO {

    @ApiModelProperty(value = "技能id")
    private Integer skillId;

    @ApiModelProperty(value = "技能在团队的得分")
    private Double ssScore;

}
