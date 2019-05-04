package com.hlx.cloudevaluation.controller;

import com.hlx.cloudevaluation.model.dto.SkillAddDTO;
import com.hlx.cloudevaluation.model.dto.SkillSearchDTO;
import com.hlx.cloudevaluation.model.dto.SkillUpdateDTO;
import com.hlx.cloudevaluation.model.po.ApiResult;
import com.hlx.cloudevaluation.model.vo.SkillSearchVO;
import com.hlx.cloudevaluation.model.vo.SkillVO;
import com.hlx.cloudevaluation.service.SkillService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
/**
 * @description: 技能控制层
 * @author: hlx 2019-04-26
 **/
@Slf4j
@Validated
@RestController
@RequestMapping("/skill")
public class SkillController {

    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @ApiOperation(value = "新建能力")
    @PostMapping("/add")
    public ApiResult<String> add(@RequestBody @Valid SkillAddDTO skillAddDTO, HttpSession session) {
        skillService.add(skillAddDTO, (Integer) session.getAttribute("userId"));
        return new ApiResult<>("add skill success");
    }

    @ApiOperation(value = "删除能力")
    @GetMapping("/delete")
    public ApiResult<String> delete(@RequestParam("skillId") Integer skillId, HttpSession session) {
        skillService.delete(skillId, (Integer) session.getAttribute("userId"));
        return new ApiResult<>("delete skill success");
    }

    @ApiOperation(value = "查询能力")
    @PostMapping("/search")
    public ApiResult<SkillSearchVO> search(@RequestBody @Valid SkillSearchDTO skillSearchDTO, HttpSession session) {
        SkillSearchVO skillSearchVO = skillService.search(skillSearchDTO, (Integer) session.getAttribute("userId"));
        ApiResult<SkillSearchVO> apiResult = new ApiResult<>();
        apiResult.setData(skillSearchVO);
        return apiResult;
    }

    @ApiOperation(value = "查询详细能力")
    @GetMapping("/detail")
    public ApiResult<SkillVO> getDetail(@RequestParam("skillId") Integer skillId) {
        ApiResult<SkillVO> apiResult = new ApiResult<>();
        SkillVO skillVO = skillService.getDetail(skillId);
        apiResult.setData(skillVO);
        return apiResult;
    }

    @ApiOperation(value = "修改能力")
    @PostMapping("/update")
    public ApiResult<String> add(@RequestBody @Valid SkillUpdateDTO skillUpdateDTO, HttpSession session) {
        skillService.update(skillUpdateDTO, (Integer) session.getAttribute("userId"));
        return new ApiResult<>("update skill success");
    }
}
