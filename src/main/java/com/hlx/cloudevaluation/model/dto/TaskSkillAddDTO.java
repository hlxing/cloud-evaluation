package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @description: 作业技能添加传输对象
 * @author: hlx 2019-05-05
 **/
@Data
public class TaskSkillAddDTO {

    @NotNull
    @ApiModelProperty(required = true, notes = "技能id")
    private Integer skillId;

    @NotNull
    @ApiModelProperty(required = true, notes = "taskId")
    private Integer taskId;


    @NotNull
    @Min(0)
    @ApiModelProperty(required = true, notes = "技能分数")
    private Double skillNumber;

}
