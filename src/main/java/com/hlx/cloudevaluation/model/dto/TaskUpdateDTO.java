package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @description: 作业修改传输对象
 * @author: hlx 2019-05-27
 **/
@Data
public class TaskUpdateDTO {

    @Size(min = 1, max = 100)
    @ApiModelProperty(notes = "作业名称,最长100", example = "结对编程作业")
    private String taskName;

    @ApiModelProperty(notes = "截止时间")
    private Date taskOverAt;

    @ApiModelProperty(notes = "班级id")
    private Integer taskClass;

    @Size(min = 1, max = 100)
    @ApiModelProperty(notes = "作业连接,最长100", example = "结对编程作业")
    private String taskUrl;

    @ApiModelProperty(notes = "技能清单")
    private List<TaskSkillAddDTO> skillList;

}
