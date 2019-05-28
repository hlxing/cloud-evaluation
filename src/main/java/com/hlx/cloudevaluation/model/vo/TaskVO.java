package com.hlx.cloudevaluation.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @description: 任务视图
 * @author: hlx 2019-02-06
 **/
@Data
public class TaskVO {

    private Integer taskId;

    private Integer taskCreator;

    private String taskCreatorName;

    private String taskCreatorAccount;

    private String taskName;

    private String taskUrl;

    private String taskClassName;

    private Date taskCreateAt;

    private Date taskOverAt;

    private Date taskUpdateAt;

}
