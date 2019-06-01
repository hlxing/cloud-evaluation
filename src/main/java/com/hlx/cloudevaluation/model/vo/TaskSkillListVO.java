package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 作业维度视图
 * @author: hlx 2019-05-30
 **/
@Data
public class TaskSkillListVO {

    @ApiModelProperty(notes = "维度链表")
    private List<SkillVO> skillVOList;

}
