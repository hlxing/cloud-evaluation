package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @description: 任务添加传输对象
 * @author: hlx 2019-04-29
 **/
@Data
public class TaskAddDTO {

    @NotNull
    @Size(min = 1, max = 100)
    @ApiModelProperty(required = true, notes = "作业名称,最长100", example = "结对编程作业")
    private String taskName;

    @NotNull
    @ApiModelProperty(required = true, notes = "截止时间")
    private Date taskOverAt;

    @NotNull
    @ApiModelProperty(required = true, notes = "班级id")
    private Integer taskClass;

    @NotNull
    @Size(min = 1, max = 100)
    @ApiModelProperty(required = true, notes = "作业连接,最长100", example = "结对编程作业")
    private String taskUrl;

    @ApiModelProperty(required = true, notes = "技能清单")
    private List<TaskSkillAddDTO> skillList;

}
