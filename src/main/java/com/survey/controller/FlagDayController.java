package com.survey.controller;

import com.survey.service.FlagDayService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@RestController
@RequestMapping(value = "/flagDay")
@Api(tags = "/flagDay", description = "按天的控制层")
public class FlagDayController {

    @Autowired
    private FlagDayService flagDayService;
}
