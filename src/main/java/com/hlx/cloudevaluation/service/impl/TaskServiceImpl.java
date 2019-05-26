package com.hlx.cloudevaluation.service.impl;

import com.hlx.cloudevaluation.mapper.SysTaskMapper;
import com.hlx.cloudevaluation.mapper.TaskSkillMapper;
import com.hlx.cloudevaluation.model.dto.TaskAddDTO;
import com.hlx.cloudevaluation.model.dto.TaskEvaluateDTO;
import com.hlx.cloudevaluation.model.dto.TaskSkillAddDTO;
import com.hlx.cloudevaluation.model.po.SysTask;
import com.hlx.cloudevaluation.model.po.TaskSkill;
import com.hlx.cloudevaluation.model.vo.TaskStatusVO;
import com.hlx.cloudevaluation.model.vo.TaskTeamStatusVO;
import com.hlx.cloudevaluation.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
/**
 * @description: 作业服务实现层
 * @author: hlx 2019-05-05
 **/
@Service
public class TaskServiceImpl implements TaskService {

    private SysTaskMapper sysTaskMapper;

    private TaskSkillMapper taskSkillMapper;

    private ModelMapper modelMapper;

    public TaskServiceImpl(SysTaskMapper sysTaskMapper, TaskSkillMapper taskSkillMapper, ModelMapper modelMapper) {
        this.sysTaskMapper = sysTaskMapper;
        this.taskSkillMapper = taskSkillMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(TaskAddDTO taskAddDTO, Integer userId) {
        SysTask sysTask = modelMapper.map(taskAddDTO, SysTask.class);
        sysTask.setTaskCreator(userId);
        sysTask.setTaskCreateAt(new Date());
        List<TaskSkillAddDTO> skillAddDTOList = taskAddDTO.getSkillList();
        sysTaskMapper.insert(sysTask);
        for (TaskSkillAddDTO item : skillAddDTOList) {
            TaskSkill taskSkill = new TaskSkill();
            taskSkill.setSkillId(item.getSkillId());
            taskSkill.setSkillNumber(item.getSkillNumber());
            taskSkill.setTaskId(sysTask.getTaskId());
            taskSkillMapper.insertSelective(taskSkill);
        }
    }

    @Override
    public TaskStatusVO getStatus(Integer taskId) {
        return null;
    }

    @Override
    public TaskTeamStatusVO getTeamStatus(Integer taskId, Integer teamId) {
        return null;
    }

    @Override
    public void evaluate(TaskEvaluateDTO taskEvaluateDTO) {

    }
}
