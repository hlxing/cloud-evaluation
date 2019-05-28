package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 整个班级而言，每一次作业、不同的评分维度的平均得分率的视图
 * @author: hlx 2019-05-28
 **/
@Data
public class AnalysisClassSkillAverageVO {

    @ApiModelProperty(notes = "作业-维度得分链表")
    private List<AnalysisClasSkillAverageItemVO> classTaskSkillAverageItemVOList;

}
