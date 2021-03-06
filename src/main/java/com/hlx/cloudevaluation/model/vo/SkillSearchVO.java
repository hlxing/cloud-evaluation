package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 技能搜索视图
 * @author: hlx 2019-02-06
 **/
@Data
public class SkillSearchVO {

    @ApiModelProperty(notes = "技能信息列表", example = "...")
    private List<SkillVO> skillVOList;

    @ApiModelProperty(notes = "当前页数", example = "1")
    private Integer pageNum;

    @ApiModelProperty(notes = "最大页数", example = "5")
    private Integer maxPageNum;

}
