package com.hlx.cloudevaluation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hlx.cloudevaluation.exception.error.ApiException;
import com.hlx.cloudevaluation.exception.error.SkillErrorEnum;
import com.hlx.cloudevaluation.mapper.SysSkillMapper;
import com.hlx.cloudevaluation.model.dto.SkillAddDTO;
import com.hlx.cloudevaluation.model.dto.SkillSearchDTO;
import com.hlx.cloudevaluation.model.dto.SkillUpdateDTO;
import com.hlx.cloudevaluation.model.po.SysSkill;
import com.hlx.cloudevaluation.model.po.SysSkillExample;
import com.hlx.cloudevaluation.model.vo.SkillSearchVO;
import com.hlx.cloudevaluation.model.vo.SkillVO;
import com.hlx.cloudevaluation.service.SkillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private SysSkillMapper sysSkillMapper;

    private ModelMapper modelMapper;

    @Autowired
    public SkillServiceImpl(SysSkillMapper sysSkillMapper, ModelMapper modelMapper) {
        this.sysSkillMapper = sysSkillMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(SkillAddDTO skillAddDTO, Integer userId) {
        SysSkillExample example = new SysSkillExample();
        SysSkillExample.Criteria criteria = example.createCriteria();
        criteria.andSkillNameEqualTo(skillAddDTO.getSkillName());
        if (sysSkillMapper.selectByExample(example).size() == 0) {//不存在
            SysSkill sysSkill = modelMapper.map(skillAddDTO, SysSkill.class);
            sysSkill.setSkillCreator(userId);
            sysSkill.setSkillCreateAt(new Date());
            sysSkillMapper.insertSelective(sysSkill);
        } else {//已存在，不能添加到数据库
            throw new ApiException(SkillErrorEnum.SKILL_NAME_EXIST);
        }
    }

    @Override
    public void delete(Integer skillId, Integer userId) {
        if (sysSkillMapper.selectByPrimaryKey(skillId) == null) {
            throw new ApiException(SkillErrorEnum.SKILL_ID_NO_EXIST);
        }
        sysSkillMapper.deleteByPrimaryKey(skillId);
    }

    @Override
    public SkillSearchVO search(SkillSearchDTO skillSearchDTO, Integer userId) {
        Integer pageNum = skillSearchDTO.getPageNum();
        Integer pageSize = skillSearchDTO.getPageSize();
        PageHelper.startPage(pageNum, pageSize);

        SysSkillExample example = new SysSkillExample();
        SysSkillExample.Criteria criteria = example.createCriteria();
        if (skillSearchDTO.getSkillName() != null) {
            criteria.andSkillNameLike("%" + skillSearchDTO.getSkillName() + "%");
        }
        List<SysSkill> sysSkillList = sysSkillMapper.selectByExample(example);
        PageInfo<SysSkill> pageInfo = new PageInfo<>(sysSkillList);

        SkillSearchVO skillSearchVO = new SkillSearchVO();
        skillSearchVO.setMaxPageNum(pageInfo.getPages());
        skillSearchVO.setPageNum(pageInfo.getPageNum());
        List<SkillVO> skillVOList = new ArrayList<>();
        for (SysSkill sysSkill : sysSkillList) {
            skillVOList.add(modelMapper.map(sysSkill, SkillVO.class));
        }
        skillSearchVO.setSkillVOList(skillVOList);

        return skillSearchVO;
    }

    @Override
    public void update(SkillUpdateDTO skillUpdateDTO, Integer userId) {
        SysSkill sysSkill = modelMapper.map(skillUpdateDTO, SysSkill.class);
        sysSkill.setSkillUpdateAt(new Date());
        sysSkillMapper.updateByPrimaryKeySelective(sysSkill);
    }
}
