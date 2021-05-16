package com.survey.controller;

import com.survey.entity.Test;
import com.survey.service.TestService;
import com.survey.utils.Status.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 测试类型的控制层
 *
 * @author 闫宏伟
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/TestController")
@Api(tags = "/TestController", description = "测试类型")
public class TestController {
    @Autowired
    private TestService testService;

    @ApiOperation("添加测试类型")
    @PostMapping(value = "/insert")
    public Integer insertTest(Test test) {
        boolean flag = testService.insertTest(test);
        if (flag) {
            return 1;
        } else {
            return 0;
        }
    }

    @ApiOperation("修改测试类型")
    @PostMapping(value = "/update")
    public Integer udateTest(Test test) {
        boolean flag = testService.updateTest(test);
        if (flag) {
            return 1;
        } else {
            return 0;
        }
    }

    @ApiOperation("删除测试类型")
    @GetMapping(value = "/delete/{id}")
    public Integer deleteTest(@PathVariable Integer id) {
        boolean flag = testService.deleteTest(id);
        if (flag) {
            return 1;
        }
        return 0;
    }

    @ApiOperation("查询所有测试类型")
    @GetMapping(value = "/allTest")
    public Object allTest() {
        List<Test> testList = testService.allTest();
        if (testList != null) {
            return AjaxResult.success("查询所有评论成功", testList);
        }
        return AjaxResult.error("查询所有评论失败");
    }

    @ApiOperation("根据id查询每个类别的提交人数")
    @PostMapping(value = "/selectById/{id}")
    public Object selectById(@PathVariable Integer id) {
        Test test = testService.selectById(id);
        if (test != null) {
            return AjaxResult.success("查询成功", test);
        }
        return AjaxResult.error("查询失败");
    }

    @ApiOperation("更新提交人数")
    @PostMapping(value = "/countById")
    public Integer countById(Test test) {
        boolean b = testService.countById(test);
        if (b) {
            return 1;
        }
        return 0;
    }

}
