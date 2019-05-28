package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 老师针对同学总分分析视图
 * @author: hlx 2019-05-28
 **/
@Data
public class AnalysisTaskTotalVO {

    @ApiModelProperty(notes = "学号-总分链表")
    private List<AnalysisTaskTotalItemVO> taskTotalItemVOList;

}
