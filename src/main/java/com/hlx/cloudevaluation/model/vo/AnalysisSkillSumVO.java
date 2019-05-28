package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 每个评分维度的平均分、学生的该维度排名、学生的该维度分数-视图
 * @author: hlx 2019-05-28
 **/
@Data
public class AnalysisSkillSumVO {

    @ApiModelProperty(notes = "纬度链表")
    private List<AnalysisSkillSumItemVO> skillSumItemVOList;

}
