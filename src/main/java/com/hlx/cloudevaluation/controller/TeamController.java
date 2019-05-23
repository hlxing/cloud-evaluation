package com.hlx.cloudevaluation.controller;

import com.hlx.cloudevaluation.model.dto.TeamAddDTO;
import com.hlx.cloudevaluation.model.po.ApiResult;
import com.hlx.cloudevaluation.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @description: 技能控制层
 * @author: hlx 2019-05-23
 **/
@Slf4j
@Validated
@RestController
@RequestMapping("/team")
public class TeamController {

    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    public ApiResult<String> add(@Valid TeamAddDTO teamAddDTO, HttpSession session) {
        String token = teamService.add(teamAddDTO, (Integer) session.getAttribute("userId"));
        ApiResult<String> apiResult = new ApiResult<>();
        apiResult.setData(token);
        return apiResult;
    }

}
