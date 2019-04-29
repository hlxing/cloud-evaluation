package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

/**
 * @description: 班级搜索视图
 * @author: hlx 2019-02-06
 **/
@Data
public class ClassSearchVO {

    @ApiModelProperty(notes = "班级信息列表", example = "...")
    private List<ClassVO> classVOList;

    @ApiModelProperty(notes = "当前页数", example = "1")
    private Integer pageNum;

    @ApiModelProperty(notes = "最大页数", example = "5")
    private Integer maxPageNum;

}
