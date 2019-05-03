package com.hlx.cloudevaluation.model.vo;

import lombok.Data;
import java.util.Date;

/**
 * @description: 技能视图
 * @author: hlx 2019-02-06
 **/
@Data
public class SkillVO {

    private Integer skillId;

    private String skillName;

    private String skillType;

    private String skillShortName;

    private Date skillCreateAt;

    private Date skillUpdateAt;

    private Date skillDeleteAt;
}
