package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.mapper.SysClassMapper;
import com.hlx.cloudevaluation.model.dto.ClassAddDTO;
import com.hlx.cloudevaluation.model.dto.ClassAuthDTO;
import com.hlx.cloudevaluation.model.dto.ClassUpdateDTO;
import com.hlx.cloudevaluation.model.po.SysClass;
import com.hlx.cloudevaluation.model.po.SysClassExample;
import com.hlx.cloudevaluation.service.ClassService;
import com.hlx.cloudevaluation.util.GetRandomToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClassServiceImpl implements ClassService {

    private SysClassMapper sysClassMapper;

    private ModelMapper modelMapper;

    @Autowired
    public ClassServiceImpl(SysClassMapper sysClassMapper, ModelMapper modelMapper) {
        this.sysClassMapper = sysClassMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public void update(ClassUpdateDTO classUpdateDTO, Integer userId) {
        SysClass sysClass = modelMapper.map(classUpdateDTO, SysClass.class);
        sysClass.setClassUpdateAt(new Date());
        sysClassMapper.updateByPrimaryKeySelective(sysClass);
    }

    @Override
    public void delete(Integer classId, Integer userId) {
        SysClassExample example = new SysClassExample();
        SysClassExample.Criteria criteria = example.createCriteria();
        criteria.andClassIdEqualTo(classId);
        SysClass sysClass = new SysClass();
        sysClass.setClassExist(false);
        sysClass.setClassUpdateAt(new Date());
        sysClass.setClassDeleteAt(new Date());

        sysClassMapper.updateByExampleSelective(sysClass, example);
    }

    @Override
    public void auth(ClassAuthDTO classAuthDTO, Integer userId) {

    }

    @Override
    public void add(ClassAddDTO classAddDTO, Integer userId) {
        SysClass sysClass = modelMapper.map(classAddDTO, SysClass.class);
        sysClass.setClassCreator(userId);
        sysClass.setClassCreateAt(new Date());
        sysClass.setClassAssistantToken(GetRandomToken.getRandomToken());
        sysClass.setClassStuToken(GetRandomToken.getRandomToken());
        sysClassMapper.insertSelective(sysClass);
    }


}
