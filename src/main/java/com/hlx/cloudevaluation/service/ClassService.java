package com.hlx.cloudevaluation.service;

import com.hlx.cloudevaluation.model.dto.ClassAddDTO;
import com.hlx.cloudevaluation.model.dto.ClassUpdateDTO;
/**
 * @description: 班级服务层
 * @author: hlx 2019-04-29
 **/
public interface ClassService {

    void add(ClassAddDTO classAddDTO, Integer userId);

    void update(ClassUpdateDTO classUpdateDTO, Integer userId);




}
