package com.hlx.cloudevaluation.service;

import com.hlx.cloudevaluation.model.dto.TaskAddDTO;
import com.hlx.cloudevaluation.model.dto.TaskEvaluateDTO;
import com.hlx.cloudevaluation.model.dto.TaskUpdateDTO;
import com.hlx.cloudevaluation.model.vo.*;

/**
 * @description: 作业服务层
 * @author: hlx 2019-05-05
 **/
public interface TaskService {

    void add(TaskAddDTO taskAddDTO, Integer userId);

    TaskStatusVO getStatus(Integer taskId);

    TaskTeamStatusVO getTeamStatus(Integer taskId, Integer teamId);

    void evaluate(TaskEvaluateDTO taskEvaluateDTO);

    TaskSearchVO search(Integer userId);

    TaskScoreVO getScore(Integer taskId, Integer userId);

    void delete(Integer taskId);

    void update(TaskUpdateDTO taskUpdateDTO);

    TaskSearchVO getList(Integer userId);

    TaskSearchVO getClassTask(Integer classId, Integer userId);

    TaskDetailVO getDetail(Integer taskId, Integer userId);

    TaskSkillListVO getSkillList(Integer taskId);
}
