package com.hlx.cloudevaluation.service;


import com.hlx.cloudevaluation.model.dto.SkillAddDTO;
import com.hlx.cloudevaluation.model.dto.SkillSearchDTO;
import com.hlx.cloudevaluation.model.dto.SkillUpdateDTO;
import com.hlx.cloudevaluation.model.vo.SkillSearchVO;
import com.hlx.cloudevaluation.model.vo.SkillVO;

/**
 * @description: 技能服务接口
 * @author: hlx 2019-01-20
 **/
public interface SkillService {

    void add(SkillAddDTO skillAddDTO, Integer userId);

    void delete(Integer skillId, Integer userId);

    SkillSearchVO search(SkillSearchDTO skillSearchDTO, Integer userId);

    void update(SkillUpdateDTO skillUpdateDTO, Integer userId);

    SkillVO getDetail(Integer skillId);
}
