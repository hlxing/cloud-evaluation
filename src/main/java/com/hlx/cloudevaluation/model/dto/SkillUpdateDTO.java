package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @description: 技能添加传输对象
 * @author: hlx 2019-04-26
 **/
@Data
public class SkillUpdateDTO {

    @NotNull
    @Size(min = 1, max = 20)
    @ApiModelProperty(required = true, notes = "技能名称,最长20", example = "答辩")
    private String skillName;

    @NotNull
    @ApiModelProperty(required = true, notes = "技能Id", example = "1001")
    private Integer skillId;

}
