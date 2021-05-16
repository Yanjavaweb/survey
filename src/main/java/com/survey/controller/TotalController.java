package com.survey.controller;

import com.survey.entity.Total;
import com.survey.entity.TotalDateVo;
import com.survey.service.TotalService;
import com.survey.utils.Status.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * total 控制层
 *
 * @author 闫宏伟
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/TotalController")
@Api(tags = "/TotalController", description = "total控制层")
public class TotalController {
    @Autowired
    private TotalService totalService;

    @GetMapping(value = "selectAll")
    @ApiOperation("查询所有")
    public Object selectAll() {
        List<Total> totals = totalService.selectAll();
        return totals;
    }

    @PostMapping(value = "selectByUserId")
    @ApiOperation("根据userId查询用户的六种类型")
    public Object selectByUserId(Total total) {
        List<Total> totals = totalService.selectByUserId(total);
        return totals;
    }

    @GetMapping(value = "/selectByType")
    @ApiOperation("根据type查询次类型所有的人数")
    public Object selectByType() {
        List<Total> totals = totalService.selectGroupByType();
        List<TotalDateVo> lists = new ArrayList<>();
        TotalDateVo count = new TotalDateVo();
        for (Total total : totals) {
            count = totalService.getCount(total.getType());
            lists.add(count);
        }
        return AjaxResult.success(lists);
    }

    @PostMapping(value = "/selectByScore")
    @ApiOperation("查询某个类型的前十名")
    public Object selectByScore(Total total) {
        List<Total> totals = totalService.selectByScore(total);
        return totals;
    }

    @PostMapping(value = "/update")
    @ApiOperation("修改")
    public Integer update(Total total) {
        boolean update = totalService.update(total);
        if (update) {
            return 1;
        }
        return 0;
    }

    @GetMapping(value = "/total")
    @ApiOperation("显示所有参与人数")
    public Integer total() {
        return totalService.getTotal() / 6;
    }

    @GetMapping(value = "/HollandTotal")
    @ApiOperation("显示所有Holland人数")
    public Integer HollandTotal() {
        return totalService.getHollandTotal() / 6;
    }

    @PostMapping(value = "/match")
    @ApiOperation("根据用户需求来查询学生")
    public List match(@RequestParam String result, @RequestParam Integer PigeSize) {
        return totalService.match(result, PigeSize);
    }
}
