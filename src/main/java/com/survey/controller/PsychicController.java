package com.survey.controller;

import com.survey.entity.PsychicDateVo;
import com.survey.service.PsychicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@RestController
@RequestMapping(value = "/psychic")
@Api(tags = "/psychic", description = "资源控制层")
public class PsychicController {
    @Autowired
    private PsychicService psychicService;

    @GetMapping(value = "/select")
    @ApiOperation("查询资源")
    public List<PsychicDateVo> getAll() {
        List<PsychicDateVo> all = psychicService.getAll();
        return all;
    }

}
