package com.hlx.cloudevaluation.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @description: 班级视图
 * @author: hlx 2019-02-06
 **/
@Data
public class ClassVO {

    private Integer classId;

    private String className;

    private String classStuToken;

    private String classAssistantToken;

    private Boolean classTeamEdit;

    private Date classCreateAt;

    private Date classUpdateAt;

    private Date classDeleteAt;

}
