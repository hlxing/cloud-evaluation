package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 团队搜索视图
 * @author: hlx 2019-05-26
 **/
@Data
public class TeamSearchVO {

    @ApiModelProperty(notes = "团队列表")
    private List<TeamVO> teamVOList;

}
