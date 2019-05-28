package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 老师针对同学不同分类的分数视图
 * @author: hlx 2019-05-28
 **/
@Data
public class AnalysisTaskSkillVO {

    @ApiModelProperty(notes = "学号-分数链表")
    private List<AnalysisTaskSkillItemVO> skillItemVOList;

}
