package com.hlx.cloudevaluation.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @description: 用户登录传输对象
 * @author: hlx 2019-01-20
 **/
@Data
public class UserLoginDTO {

    @NotNull
    @Size(min = 1, max = 15)
    @ApiModelProperty(required = true, notes = "用户名,最长15位", example = "hlx")
    private String userAccount;

    @NotNull
    @Size(min = 1, max = 50)
    @ApiModelProperty(required = true, notes = "密码,最长50位", example = "123456")
    private String userPass;

}
