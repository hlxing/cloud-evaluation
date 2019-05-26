package com.hlx.cloudevaluation.service;

import com.hlx.cloudevaluation.model.dto.TeamAddDTO;
import com.hlx.cloudevaluation.model.dto.TeamUpdateDTO;
import com.hlx.cloudevaluation.model.vo.TeamDetailVO;
import com.hlx.cloudevaluation.model.vo.TeamSearchVO;

/**
 * @description: 团队服务接口
 * @author: hlx 2019-01-20
 **/
public interface TeamService {

    String add(TeamAddDTO teamAddDTO, Integer userId);

    void join(String token, Integer userId);

    TeamDetailVO getDetail(Integer userId);

    void update(TeamUpdateDTO teamUpdateDTO, Integer userId);

    void exit(Integer userId);

    void clear(Integer teamId, Integer userId);

    TeamSearchVO search(Integer userId);
}
