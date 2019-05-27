package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 作业搜索视图
 * @author: hlx 2019-05-27
 **/
@Data
public class TaskSearchVO {

    @ApiModelProperty(notes = "个人作业列表", example = "...")
    List<TaskVO> taskVOList;

}
