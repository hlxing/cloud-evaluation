package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @description: 班级详情信息传输对象
 * @author: hlx 2019-2-06
 **/
@Data
public class ClassGetDetailDTO {

    @ApiModelProperty(notes = "班级id", example = "1")
    private Integer classId;

    @NotNull
    @Min(1)
    @ApiModelProperty(required = true, notes = "页数", example = "1")
    private Integer pageNum;

    @NotNull
    @Min(1)
    @ApiModelProperty(required = true, notes = "每页显示数量", example = "9")
    private Integer pageSize;

}
