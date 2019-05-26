package com.hlx.cloudevaluation.controller;

import com.hlx.cloudevaluation.model.dto.TeamAddDTO;
import com.hlx.cloudevaluation.model.dto.TeamUpdateDTO;
import com.hlx.cloudevaluation.model.po.ApiResult;
import com.hlx.cloudevaluation.model.vo.TeamDetailVO;
import com.hlx.cloudevaluation.model.vo.TeamSearchVO;
import com.hlx.cloudevaluation.service.TeamService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "创建团队")
    @PostMapping("/add")
    public ApiResult<String> add(@Valid TeamAddDTO teamAddDTO, HttpSession session) {
        String token = teamService.add(teamAddDTO, (Integer) session.getAttribute("userId"));
        ApiResult<String> apiResult = new ApiResult<>();
        apiResult.setData(token);
        return apiResult;
    }

    @ApiOperation(value = "加入团队")
    @GetMapping("/join")
    public ApiResult<String> join(@RequestParam("teamToken") String token, HttpSession session) {
        teamService.join(token, (Integer) session.getAttribute("userId"));
        return new ApiResult<>("join success");
    }

    @ApiOperation(value = "获取团队信息")
    @GetMapping("/detail")
    public ApiResult<TeamDetailVO> getDetail(HttpSession session) {
        TeamDetailVO teamDetailVO = teamService.getDetail((Integer) session.getAttribute("userId"));
        ApiResult<TeamDetailVO> apiResult = new ApiResult<>();
        apiResult.setData(teamDetailVO);
        return apiResult;
    }

    @ApiOperation(value = "修改团队信息")
    @PostMapping("/update")
    public ApiResult<String> update(@Valid TeamUpdateDTO teamUpdateDTO, HttpSession session) {
        teamService.update(teamUpdateDTO, (Integer) session.getAttribute("userId"));
        return new ApiResult<>("update team success");
    }

    @ApiOperation(value = "退出团队", notes = "队长退出即解散团队")
    @GetMapping("/exit")
    public ApiResult<String> exit(HttpSession session) {
        teamService.exit((Integer) session.getAttribute("userId"));
        return new ApiResult<>("exit team success");
    }

    @ApiOperation(value = "团队解散", notes = "队长才能解散")
    @GetMapping("/clear")
    public ApiResult<String> clear(@RequestParam("teamId") Integer teamId, HttpSession session) {
        teamService.clear(teamId, (Integer) session.getAttribute("userId"));
        return new ApiResult<>("clear team success");
    }

    @ApiOperation(value = "团队搜索，获取班级所有团队")
    @GetMapping("/search")
    public ApiResult<TeamSearchVO> search(@RequestParam("classId") Integer classId, HttpSession session) {
        TeamSearchVO teamSearchVO = teamService.search(classId, (Integer) session.getAttribute("userId"));
        ApiResult<TeamSearchVO> apiResult = new ApiResult<>();
        apiResult.setData(teamSearchVO);
        return apiResult;
    }

}