package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @description: 班级添加传输对象
 * @author: hlx 2019-04-29
 **/
@Data
public class ClassAddDTO {

    @NotNull
    @Size(min = 1, max = 255)
    @ApiModelProperty(required = true, notes = "班级名称,最长255", example = "2016软件工程四班")
    private String className;

    @ApiModelProperty(required = true, notes = "班级配置信息", example = "*")
    private List<String> classConfigs;

}
