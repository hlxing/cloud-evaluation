package com.hlx.cloudevaluation.model.po;

import lombok.Data;

import java.util.Date;

/**
 * @description: 技能
 * @author: hlx 2019-04-26
 **/
@Data
public class Skill {

    private Integer skillId;

    private String skillName;

    private Integer skillCreator;

    private Date skillCreateAt;

    private Date skillUpdateAt;

    private Date skillDeleteAt;

}
