package com.hlx.cloudevaluation.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 作业团队打分情况
 * @author: hlx 2019-05-26
 **/
@Data
public class TaskTeamStatusVO {

    @ApiModelProperty(value = "用户贡献度列表")
    private List<UserContributeVO> userContributeVOList;

    @ApiModelProperty(value = "技能得分列表")
    private List<SkillScoreVO> skillVOList;

}
