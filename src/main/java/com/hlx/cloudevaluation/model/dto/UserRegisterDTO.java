package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @description: 用户注册传输对象
 * @author: hlx 2019-01-20
 **/
@Data
public class UserRegisterDTO {

    @NotNull
    @Size(min = 1, max = 15)
    @ApiModelProperty(required = true, notes = "学号/教工号,最长15", example = "hlx")
    private String userAccount;

    @NotNull
    @Size(min = 1, max = 50)
    @ApiModelProperty(required = true, notes = "密码,最长50", example = "123456")
    private String userPass;

    @NotNull
    @Size(min = 1, max = 100)
    @ApiModelProperty(required = true, notes = "学校,最长100", example = "福州大学")
    private String userSchool;

    @NotNull
    @Size(min = 1, max = 20)
    @ApiModelProperty(required = true, notes = "姓名,最长20", example = "hlxing")
    private String userName;

}
