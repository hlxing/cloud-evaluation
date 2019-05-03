package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @description: 技能信息搜索传输对象
 * @author: hlx 2019-2-06
 **/
@Data
public class SkillSearchDTO {

    @Size(min = 1, max = 20)
    @ApiModelProperty(notes = "技能名称", example = "博客")
    private String skillName;

    @Size(min = 1, max = 50)
    @ApiModelProperty(required = true, notes = "技能类型,最长50", example = "工程能力")
    private String skillType;

    @Size(min = 1, max = 10)
    @ApiModelProperty(required = true, notes = "技能代号", example = "A")
    private String skillShortName;

    @NotNull
    @Min(1)
    @ApiModelProperty(required = true, notes = "页数", example = "1")
    private Integer pageNum;

    @NotNull
    @Min(1)
    @ApiModelProperty(required = true, notes = "每页显示数量", example = "9")
    private Integer pageSize;

}
