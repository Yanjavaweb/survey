package com.survey.controller;


import com.survey.entity.QuestionIndex;
import com.survey.service.QuestionIndexService;
import com.survey.utils.Status.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 次类型控制层
 *
 * @author 闫宏伟
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/QuestionIndexController")
@Api(tags = "/QuestionIndexController", description = "次类型控制层")
public class QuestionIndexController {
    @Autowired
    private QuestionIndexService questionIndexService;

    @PostMapping(value = "/insert")
    @ApiOperation("添加次类型")
    public Integer insert(QuestionIndex questionIndex) {
        boolean flag = questionIndexService.insert(questionIndex);
        if (flag) {
            return 1;
        }
        return 0;
    }

    @PostMapping(value = "/delete/{id}")
    @ApiOperation("删除次类型")
    public Integer delete(@PathVariable Integer id) {
        boolean flag = questionIndexService.delete(id);
        if (flag) {
            return 1;
        }
        return 0;
    }

    @PostMapping(value = "/update")
    @ApiOperation("修改次类型")
    public Integer update(QuestionIndex questionIndex) {
        boolean flag = questionIndexService.update(questionIndex);
        if (flag) {
            return 1;
        }
        return 0;
    }

    @GetMapping(value = "/selectAll")
    @ApiOperation("查询所有次类型")
    public Object select() {
        List<QuestionIndex> questionIndexList = questionIndexService.allSelect();
        if (questionIndexList != null) {
            return AjaxResult.success("查询所有成功", questionIndexList);
        }
        return AjaxResult.error("查询失败");
    }

    @PostMapping(value = "/selectById/{id}")
    @ApiOperation("根据id查询次类别")
    public Object selectById(@PathVariable Integer id) {
        QuestionIndex questionIndex = questionIndexService.selectById(id);
        if (questionIndex != null) {
            return AjaxResult.success("根据id查询次类别成功", questionIndex);
        }
        return AjaxResult.error("根据id查询次类别失败");
    }
}
