package com.survey.controller;

import com.survey.entity.QuestionList;
import com.survey.service.QuestionListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/QuestionListController")
@Api(tags = "/QuestionListController", description = "问题控制层")
public class QuestionListController {
    @Autowired
    private QuestionListService questionListService;

    @PostMapping(value = "/insert")
    @ApiOperation("添加问题")
    public Integer insert(QuestionList questionList) {
        boolean b = questionListService.insertQuestion(questionList);
        if (b) {
            return 1;
        }
        return 0;
    }

    @PostMapping(value = "/delete/{id}")
    @ApiOperation("删除一条问题")
    public Integer delete(@PathVariable Integer id) {
        boolean b = questionListService.deleteQuestion(id);
        if (b) {
            return 1;
        }
        return 0;
    }

    @PostMapping(value = "/update")
    @ApiOperation("修改一条问题")
    public Integer update(QuestionList questionList) {
        boolean b = questionListService.updateQuestion(questionList);
        if (b) {
            return 1;
        }
        return 0;
    }

    @GetMapping(value = "/selectAll")
    @ApiOperation("查询所有问题")
    public List<QuestionList> select() {
        List<QuestionList> questionLists = questionListService.selectAll();
        return questionLists;
    }

    @PostMapping(value = "/selectByNumber")
    @ApiOperation("查询通过number")
    public List<QuestionList> selectByNumber(QuestionList questionList) {
        List<QuestionList> questionLists = questionListService.selectByNumber(questionList);
        return questionLists;
    }

    @PostMapping(value = "/selectByType")
    @ApiOperation("查询通过type")
    public List<QuestionList> selectByType(QuestionList questionList) {
        List<QuestionList> questionLists = questionListService.selectByType(questionList);
        return questionLists;
    }

}
