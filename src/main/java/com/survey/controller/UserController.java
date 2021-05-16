package com.survey.controller;

import com.survey.entity.Scale;
import com.survey.entity.Total;
import com.survey.entity.User;
import com.survey.entity.UserDateVo;
import com.survey.service.ClientService;
import com.survey.service.TotalService;
import com.survey.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * user 控制层
 *
 * @author 闫宏伟
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/UserController")
@Api(tags = "/UserController", description = "user控制层")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TotalService totalService;
    @Autowired
    private ClientService clientService;
    static String phoneCode = UUID.randomUUID().toString().substring(0, 4);

    @GetMapping(value = "/selectAll")
    @ApiOperation("查询所有用户")
    public Object selectAll() {
        List<User> users = userService.selectAll();
        return users;
    }

    @PostMapping(value = "/update")
    @ApiOperation("修改用户")
    public Integer update(User user) {
        boolean update = userService.update(user);
        if (update) {
            return 1;
        }
        return 0;
    }

    @PostMapping(value = "/insert")
    @ApiOperation("插入用户")
    public Integer insert(User user) {
        boolean insert = userService.insert(user);
        if (insert) {
            return 1;
        }
        return 0;
    }

    @PostMapping(value = "/delete")
    @ApiOperation("删除用户")
    public Integer delete(Integer id) {
        boolean delete = userService.delete(id);
        if (delete) {
            return 1;
        }
        return 0;
    }

    //    @GetMapping(value = "/login")
//    @ApiOperation("用来处理用户登录的")
//    public Integer loginStatus(User user, HttpSession session, @PathVariable("code") String code){
//        if (ObjectUtils.isEmpty(user.getUsername()) || ObjectUtils.isEmpty(user.getIdCard()) || !code.equals(phoneCode)) {
//            return 0;
//        }
//        boolean flag = userService.verifyPassword(user);
//        System.out.println(flag);
//        if(flag){
//            session.setAttribute(ConstsUtils.NAME,user);
//            return 1;
//        }
//        return 0;
//    }
    @PostMapping(value = "/openid")
    @ApiOperation("判断openid是否存在")
    public Integer openId(@RequestParam String openId) {
        User openId1 = userService.getOpenId(openId);
        try {
            if (!openId.equals(openId1.getOpenId())) {
                return 0;
            }
        } catch (NullPointerException e) {
            return 0;
        }
        return openId1.getId();
    }

    @PostMapping(value = "/login")
    @ApiOperation("用来处理用户登录的")
    public Integer login(User user, HttpSession session, String code) {
        String nameRegex = "[\\u4E00-\\u9FA5]{2,5}(?:·[\\u4E00-\\u9FA5]{2,5})*";
        String idCardRegex = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        String phoneRegex = "1[35678][0-9]{9}";
        System.out.println(user.getUsername() + user.getIdCard() + user.getPhone() + "==============================");
        System.out.println(user.getUsername().matches(nameRegex) + " ===" + user.getIdCard().matches(idCardRegex) + "===" + user.getPhone().matches(phoneRegex));
        if (!user.getUsername().matches(nameRegex) || !user.getIdCard().matches(idCardRegex) || !user.getPhone().matches(phoneRegex) || !phoneCode.equals(code)) {
            return 0;
        }
        Integer[] arr = {18, 19, 20};
        return arr[new Random().nextInt(arr.length - 1)];
    }

    @PostMapping(value = "/register")
    @ApiOperation("用来处理用户注册的")
    public Integer register(User user) {
//        String nameRegex = "[\\u4E00-\\u9FA5]{2,5}(?:·[\\u4E00-\\u9FA5]{2,5})*";
//        String phoneRegex = "1[35678][0-9]{9}";
        return 0;
    }

    @PostMapping(value = "/check")
    @ApiOperation("用来处理短信验证码的")
    public Object check(String phone) {
        System.out.println(phone);
        return clientService.check(phone, phoneCode);
    }

    @PostMapping(value = "/submit")
    @ApiOperation("用来处理用户提交过来的数据的")
    public Integer submit(HttpServletRequest request) {
        String name, idCard, phone, result, grade, R, I, A, S, E, C;
        try {
            name = request.getParameter("name").trim();
            idCard = request.getParameter("idCard").trim();
            phone = request.getParameter("phone").trim();
            result = request.getParameter("result").trim();
            grade = request.getParameter("grade").trim();
            R = request.getParameter("R").trim();
            I = request.getParameter("I").trim();
            A = request.getParameter("A").trim();
            S = request.getParameter("S").trim();
            E = request.getParameter("E").trim();
            C = request.getParameter("C").trim();

        } catch (NullPointerException e) {
            return 0;
        }
        Map<String, String> map = new HashMap();
        map.put("R", R);
        map.put("I", I);
        map.put("A", A);
        map.put("S", S);
        map.put("E", E);
        map.put("C", C);
        User user = new User();
        user.setUsername(name);
        user.setIdCard(idCard);
        user.setPhone(phone);
        user.setResult(result);
        user.setGrade(grade);
//        boolean update = userService.update(user);
//            List<User> users = userService.selectAll();
//            for (User user1 : users){
//                if (user1.equals(name)){
//                    return 0;
//                }
//            }
        List<User> users = userService.selectAll();
        for (User user1 : users) {
            if (user1.getUsername().equals(name)) {
                return 0;
            }
        }
        boolean insert = userService.insert(user);
        if (!insert) {
            return 0;
        }

        Integer integer = userService.selectByName(name);
        for (String key : map.keySet()) {
            Total total = new Total();
            total.setUserId(integer);
            total.setType(key);
            total.setCount(Integer.parseInt(R) + Integer.parseInt(I) + Integer.parseInt(A) + Integer.parseInt(S) + Integer.parseInt(E) + Integer.parseInt(C));
            Integer score = Integer.parseInt(map.get(key));
            total.setScore(score);
            boolean inserts = totalService.inserts(total);
            if (!inserts) {
                return 0;
            }
        }
        return 1;

    }

    @GetMapping(value = "/gradeCount")
    @ApiOperation("显示每个年级的提交人数")
    public Map gradeCount() {
        List<User> users = userService.GroupByGrade();
        Map<String, Integer> map = new HashMap<>();
        Integer count = 0;
        for (User user : users) {
            List<User> users1 = userService.selectByGrade(user.getGrade());
            for (int i = 0; i < users1.size(); i++) {
//                System.out.println(users1.get(i)+"==========");
                List<User> count1 = userService.getCount(users1.get(i).getId());
                if (count1.size() > 0) {
                    count += count1.size() / 6;
                    map.put(user.getGrade(), count);
                }

//                System.out.println(count+"============");
            }
            count = 0;
        }
        return map;
    }

    @GetMapping(value = "/firstTen")
    @ApiOperation("显示每个年级的每个类型的总分前十名")
    public Object firstTen() {
        List<User> users = userService.GroupByGrade();
        Map<String, List<List<UserDateVo>>> map = new HashMap<>();
        List<Total> totals = totalService.selectGroupByType();
        List<List<UserDateVo>> count2 = new ArrayList<>();
        List<UserDateVo> count1 = new ArrayList<>();
        for (User user : users) {
            System.out.println(user.getId() + "====");
            for (Total total : totals) {
                count1 = userService.getFirstTen(total.getType(), user.getGrade());
                count2.add(count1);
                map.put(user.getGrade(), count2);
            }
            count2 = new ArrayList<>();
        }
        return map;
    }

    @PostMapping(value = "/scale")
    @ApiOperation("每个年级的男女比例")
    public Object scale() {
        Map<String, List<Scale>> map = new HashMap<>();
        List<Scale> list = new ArrayList<>();
        List<User> users = userService.GroupByGrade();
        List<User> users1 = userService.GroupByGender();
        List<Total> totals = totalService.selectGroupByType();
        for (User user : users) {
            for (User user1 : users1) {
                for (Total total : totals) {
                    Scale scale = userService.getScale(total.getType(), user1.getGender(), user.getGrade());
                    scale.setType(total.getType());
                    list.add(scale);
                    map.put(user.getGrade(), list);
                }
            }
            list = new ArrayList<>();
        }
        return map;
    }

    @PostMapping(value = "/getscale")
    @ApiOperation("所有的结果首字母开头的男女比例")
    public Object getscale() {
        List<Scale> list = new ArrayList<>();
        List<User> users1 = userService.GroupByGender();
        List<Total> totals = totalService.selectGroupByType();
        for (User user1 : users1) {
            for (Total total : totals) {
                Scale scale = userService.getScales(total.getType(), user1.getGender());
                scale.setType(total.getType());
                list.add(scale);
            }
        }
        return list;
    }

    @PostMapping(value = "/login1")
    @ApiOperation("用来处理用户登录的")
    public Object login1(@RequestParam String loginId, @RequestParam String password) {
        Object login = userService.getLogin(loginId, password);
        return login;
    }

}
