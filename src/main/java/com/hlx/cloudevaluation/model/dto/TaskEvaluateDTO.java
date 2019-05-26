package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description: 作业评分传输对象
 * @author: hlx 2019-05-26
 **/
@Data
public class TaskEvaluateDTO {

    @NotNull
    @ApiModelProperty(required = true, notes = "任务id", example = "0")
    private Integer taskId;

    @NotNull
    @ApiModelProperty(required = true, notes = "团队id", example = "0")
    private Integer teamId;

    @NotNull
    @ApiModelProperty(required = true, notes = "贡献度列表", example = "...")
    private List<TaskContributeDTO> taskContributeDTOList;

    @NotNull
    @ApiModelProperty(required = true, notes = "技能列表", example = "...")
    private List<TaskSkillDTO> taskSkillDTOList;

}
