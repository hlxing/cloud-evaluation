package com.hlx.cloudevaluation.service;

import com.hlx.cloudevaluation.model.dto.*;
import com.hlx.cloudevaluation.model.vo.ClassConfigListVO;
import com.hlx.cloudevaluation.model.vo.ClassDetailVO;
import com.hlx.cloudevaluation.model.vo.ClassSearchVO;

import javax.validation.Valid;
/**
 * @description: 班级服务层
 * @author: hlx 2019-04-29
 **/
public interface ClassService {

    void add(ClassAddDTO classAddDTO, Integer userId);

    void update(ClassUpdateDTO classUpdateDTO, Integer userId);

    void delete(Integer classId, Integer userId);

    void auth(ClassAuthDTO classAuthDTO, Integer userId);

    ClassSearchVO search(ClassSearchDTO classSearchDTO, Integer userId);

    ClassDetailVO getDetail(ClassGetDetailDTO classGetDetailDTO, Integer userId);

}
