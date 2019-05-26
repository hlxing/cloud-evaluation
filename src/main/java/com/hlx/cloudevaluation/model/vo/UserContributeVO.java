package com.hlx.cloudevaluation.model.vo;

import lombok.Data;

/**
 * @description: 用户贡献度视图
 * @author: hlx 2019-05-26
 **/
@Data
public class UserContributeVO {

    private Integer userId;

    private String userName;

    private Double usContribute;

}
