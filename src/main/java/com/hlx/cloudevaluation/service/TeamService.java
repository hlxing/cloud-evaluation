package com.hlx.cloudevaluation.service;


import com.hlx.cloudevaluation.model.dto.SkillAddDTO;
import com.hlx.cloudevaluation.model.dto.SkillSearchDTO;
import com.hlx.cloudevaluation.model.dto.SkillUpdateDTO;
import com.hlx.cloudevaluation.model.dto.TeamAddDTO;
import com.hlx.cloudevaluation.model.vo.SkillSearchVO;
import com.hlx.cloudevaluation.model.vo.SkillVO;

import javax.validation.Valid;

/**
 * @description: 团队服务接口
 * @author: hlx 2019-01-20
 **/
public interface TeamService {

    String add(TeamAddDTO teamAddDTO, Integer userId);

}
