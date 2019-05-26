package com.hlx.cloudevaluation.service;

import com.hlx.cloudevaluation.model.dto.TaskAddDTO;
import com.hlx.cloudevaluation.model.dto.TaskEvaluateDTO;
import com.hlx.cloudevaluation.model.vo.TaskStatusVO;
import com.hlx.cloudevaluation.model.vo.TaskTeamStatusVO;


/**
 * @description: 作业服务层
 * @author: hlx 2019-05-05
 **/
public interface TaskService {

    void add(TaskAddDTO taskAddDTO, Integer userId);

    TaskStatusVO getStatus(Integer taskId);

    TaskTeamStatusVO getTeamStatus(Integer taskId, Integer teamId);

    void evaluate(TaskEvaluateDTO taskEvaluateDTO);
}
