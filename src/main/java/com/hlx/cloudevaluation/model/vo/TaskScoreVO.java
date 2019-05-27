package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 作业打分视图
 * @author: hlx 2019-05-27
 **/
@Data
public class TaskScoreVO {

    @ApiModelProperty(notes = "个人作业评分列表", example = "...")
    private List<SkillScoreVO> skillScoreVOList;

    @ApiModelProperty(notes = "平均贡献度", example = "...")
    private Double averageContribute;

    @ApiModelProperty(notes = "贡献度", example = "...")
    private Double usContribute;

    @ApiModelProperty(notes = "最后得分", example = "...")
    private Double usFinalScore;

}
