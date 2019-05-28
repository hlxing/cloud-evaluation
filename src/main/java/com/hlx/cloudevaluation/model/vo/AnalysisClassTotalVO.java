package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 全班同学的总分视图
 * @author: hlx 2019-05-28
 **/
@Data
public class AnalysisClassTotalVO {

    @ApiModelProperty(notes = "作业-得分链表")
    private List<AnalysisClassTotalItemVO> classTaskTotalItemVOList;

}
