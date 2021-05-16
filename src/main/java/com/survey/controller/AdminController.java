package com.survey.controller;

import com.survey.service.AdminService;
import com.survey.utils.Consts.ConstsUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description: 管理员控制层
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/AdminController")
@Api(tags = "/AdminController", description = "管理员")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/login")
    @ApiOperation("用来处理管理员登录的")
    public Integer loginStatus(@RequestParam String user_name, String user_pwd, HttpSession session) {
        boolean flag = adminService.verifyPassword(user_name, user_pwd);
        System.out.println(flag);
        if (flag) {
            session.setAttribute(ConstsUtils.NAME, user_name);
            session.setAttribute(ConstsUtils.PASSWORD, user_pwd);
            return 1;
        }
        return 0;
    }

    @PostMapping(value = "/Session")
    @ApiOperation("验证Session是否过期")
    public Integer getSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object name = session.getAttribute("name");
        Object pwd = session.getAttribute("password");
        if (name.equals(null) || pwd.equals(null) ){
            return 0;
        }
        return 1;
    }
}
