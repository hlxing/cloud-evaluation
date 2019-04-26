package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.model.dto.SkillAddDTO;
import com.hlx.cloudevaluation.model.dto.SkillSearchDTO;
import com.hlx.cloudevaluation.model.dto.SkillUpdateDTO;
import com.hlx.cloudevaluation.model.vo.SkillSearchVO;
import com.hlx.cloudevaluation.service.SkillService;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {

    @Override
    public void add(SkillAddDTO skillAddDTO, Integer userId) {

    }

    @Override
    public void delete(Integer skillId, Integer userId) {

    }

    @Override
    public SkillSearchVO search(SkillSearchDTO skillSearchDTO, Integer userId) {
        return null;
    }

    @Override
    public void update(SkillUpdateDTO skillUpdateDTO, Integer userId) {

    }
}
