package com.hlx.cloudevaluation.model.vo;

import lombok.Data;

/**
 * @description: 团队队员视图
 * @author: hlx 2019-05-25
 **/
@Data
public class TeamUserVO {

    private Integer userId;

    private String userAccount;

    private String userName;

    private String cuGithub;

    private String cuBlog;

    private String cuEmail;

    private Boolean isCaptain;

}
