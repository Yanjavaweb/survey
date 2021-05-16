package com.survey.controller;


import com.survey.entity.Common;
import com.survey.entity.QuestionDateVo;
import com.survey.entity.Test;
import com.survey.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
@RestController
@RequestMapping(value = "/QuestionDataVoController")
@Api(tags = "/QuestionDataVoController", description = "格式")
public class QuestionDataVoController {

    @Autowired
    private TestService testService;

    @GetMapping(value = "/getJson")
    @ApiOperation("用json格式返回问题列表")
    public Common getJson() {
        Test test = testService.selectById(1);
        List<QuestionDateVo> list = testService.getList();
        Common common = new Common();
        common.setName(test.getName());
        common.setList(list);
        return common;
    }
}

