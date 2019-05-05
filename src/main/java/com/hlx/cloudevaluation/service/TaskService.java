package com.hlx.cloudevaluation.service;

import com.hlx.cloudevaluation.model.dto.TaskAddDTO;


/**
 * @description: 作业服务层
 * @author: hlx 2019-05-05
 **/
public interface TaskService {

    void add(TaskAddDTO taskAddDTO, Integer userId);
}
