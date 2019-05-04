package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @description: 班级授权传输对象
 * @author: hlx 2019-04-29
 **/
@Data
public class ClassAuthDTO {

    @NotNull
    @Size(min = 1, max = 50)
    @ApiModelProperty(required = true, notes = "授权Token", example = "1111")
    private String token;

    @NotNull
    @ApiModelProperty(required = true, notes = "授权代码", example = "0为学生,1为助教")
    private Integer authCode;

    @NotNull
    @ApiModelProperty(required = true, notes = "所在班级", example = "1")
    private Integer classID;

    @NotNull
    @Size(min = 1, max = 50)
    @ApiModelProperty(required = true, notes = "github", example = "http://...")
    private String cuGithub;

    @NotNull
    @Size(min = 1, max = 50)
    @ApiModelProperty(required = true, notes = "blog", example = "http://...")
    private String cuBlog;

    @NotNull
    @Size(min = 1, max = 50)
    @ApiModelProperty(required = true, notes = "email", example = "http://...")
    private String cuEmail;

}
