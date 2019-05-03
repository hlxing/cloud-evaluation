package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @description: 技能修改传输对象
 * @author: hlx 2019-04-26
 **/
@Data
public class SkillUpdateDTO {

    @NotNull
    @Size(min = 1, max = 20)
    @ApiModelProperty(required = true, notes = "技能名称,最长20", example = "答辩")
    private String skillName;

    @NotNull
    @Size(min = 1, max = 50)
    @ApiModelProperty(required = true, notes = "技能类型,最长50", example = "工程能力")
    private String skillType;

    @NotNull
    @Size(min = 1, max = 10)
    @ApiModelProperty(required = true, notes = "技能代号", example = "A")
    private String skillShortName;

    @NotNull
    @ApiModelProperty(required = true, notes = "技能Id", example = "1001")
    private Integer skillId;

}
