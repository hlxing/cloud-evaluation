package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 作业状态Item视图
 * @author: hlx 2019-05-26
 **/
@Data
public class TaskStatusItemVO {

    @ApiModelProperty(notes = "团队名称", example = "...")
    private String teamName;

    @ApiModelProperty(notes = "团队得分", example = "...")
    private Double teamScore;

    @ApiModelProperty(notes = "状态，0为未打分，1为打分", example = "...")
    private Boolean status;

}
