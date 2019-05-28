package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 本次作业、每个评分维度的平均得分率视图
 * @author: hlx 2019-05-28
 **/
@Data
public class AnalysisTaskSkillAverageVO {

    @ApiModelProperty(notes = "维度-平均得分链表")
    private List<AnalysisTaskSkillItemVO> skillItemVOList;

}
