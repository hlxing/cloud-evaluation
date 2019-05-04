package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @description: 班级修改传输对象
 * @author: hlx 2019-04-29
 **/
@Data
public class ClassUpdateDTO {

    @Size(min = 1, max = 255)
    @ApiModelProperty(notes = "班级名称,最长255", example = "2016软件工程四班")
    private String className;

    @ApiModelProperty(notes = "班级团队信息是否可以修改", example = "true")
    private Boolean classTeamEdit;

    @NotNull
    @ApiModelProperty(required = true, notes = "班级id", example = "1")
    private Integer classId;

}
