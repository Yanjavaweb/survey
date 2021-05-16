package com.survey.controller;

import com.survey.entity.ConsultDateVo;
import com.survey.service.ConsultService;
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
@RequestMapping(value = "/consult")
@Api(tags = "/consult", description = "咨询控制层")
public class ConsultController {

    @Autowired
    private ConsultService consultService;

    @GetMapping("/getAll")
    @ApiOperation("查询所有咨询信息")
    public List<ConsultDateVo> getAll() {
        List<ConsultDateVo> all = consultService.getAll();
        return all;
    }
}
