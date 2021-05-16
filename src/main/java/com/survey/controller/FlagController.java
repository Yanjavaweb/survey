package com.survey.controller;

import com.survey.entity.*;
import com.survey.service.*;
import com.survey.utils.Status.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.xml.stream.events.StartElement;
import java.io.File;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@RestController
@RequestMapping(value = "/flag")
@Api(tags = "/flag", description = "创建目标的控制层")
public class FlagController {

    @Autowired
    private FlagService flagService;
    @Autowired
    private FlagDayService flagDayService;
    @Autowired
    private FlagWeekService flagWeekService;
    @Autowired
    private FriendCircleService friendCircleService;
    @Autowired
    private CircuSeeService circuSeeService;
    @Autowired
    private PraiseService praiseService;
    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/createFlagDay")
    @ApiOperation("创建目标按天")
    public Object createFlag(@RequestParam String flagName, @RequestParam Integer userId, @RequestParam Integer money, @RequestParam String startTime, @RequestParam String endTime, @RequestParam Integer flagCount) {
        Date starts = null;
        Date ends = null;
        try {
            List<Flag> all = flagService.getAll();
            for (Flag flag : all) {
                if (flagName.equals(flag.getFlagName()) && userId == flag.getUserId()) {
                    return 2;
                }
            }
            boolean flag1 = flagService.createFlag(flagName, userId, money);
            Integer flagId = flagService.getFlagId(flagName, userId);
            starts = new SimpleDateFormat("yyyy-MM-dd").parse(startTime);
            ends = new SimpleDateFormat("yyyy-MMdd").parse(endTime);
            boolean flagDay1 = flagDayService.createFlagDay(flagId, starts, ends, flagCount);
            if (!flag1 || !flagDay1) {
                return -1;
            }
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @PostMapping(value = "/friendCircle")
    @ApiOperation("设定好任务后，朋友圈打卡")
    public Object friendCircle(@RequestParam("files") MultipartFile[] multipartFiles, Integer flagId, String text) {
        List<FriendCircle> friendCircles = friendCircleService.selectAll();
        for (FriendCircle friendCircle : friendCircles) {
            if (flagId.equals(friendCircle.getFlagId()) && text.equals(friendCircle.getText())) {
                return "重复提交啦";
            }
        }
        boolean friendCircle = friendCircleService.createFriendCircle(flagId, text);
        Integer circleId = friendCircleService.getCircleId(flagId, text);
        for (MultipartFile multipartFile : multipartFiles) {
            if (multipartFile.isEmpty()) {
                System.out.println("文件上传失败");
                return AjaxResult.error("文件上传失败");
            }
            /*文件名=当前时间的毫秒值+原文件名*/
            String fileName = System.currentTimeMillis() + multipartFile.getOriginalFilename();
            /*文件路径*/
            String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                    + System.getProperty("file.separator") + "circlePic";
            File file1 = new File(filePath);
            if (!file1.exists()) {  //如果文件路径不存在，创建路径
                file1.mkdirs();
            }
            //实际的文件地址
            File dest = new File(filePath + System.getProperty("file.separator") + fileName);
            //相对的文件地址
            String storeAvatorPath = "/img/circlePic/" + fileName;
            System.out.println(storeAvatorPath + ".....................");
            try {
                multipartFile.transferTo(dest);
                boolean image = friendCircleService.createImage(circleId, storeAvatorPath);
            } catch (Exception e) {
                System.out.println("插入图片失败" + e.getMessage());
                return AjaxResult.error("插入图片失败" + e.getMessage());
            }
        }
        if (!friendCircle) {
            return AjaxResult.error("插入朋友圈失败");
        }
        //写打卡的业务。根据打卡次数修改任务的完成次数
        try {
            List<FriendCircle> friendCircless = friendCircleService.selectAll();
            for (FriendCircle friendCircle1 : friendCircless) {
                if (flagId.equals(friendCircle1.getFlagId()) && text.equals(friendCircle1.getText())) {
                    //想想怎样在打卡成功后只更新一次,想想条件如何变
                    boolean b = flagDayService.updatefinishCount(friendCircle1.getFlagId());
                    List<FlagDay> all = flagDayService.getAll();
                    for (FlagDay flagDay : all) {
                        //如果完成次数等于设定的目标次数，就将isFlag修改为 1
                        System.out.println(flagDay.getFinishCount() + "--------" + flagDay.getFlagCount());
                        if (flagDay.getFinishCount().equals(flagDay.getFlagCount())) {
//                            System.out.println("++++++++++++++");
                            boolean b1 = flagDayService.updateIsFlag(flagDay.getFlagId());
                        }
                    }
                }
                if (flagId.equals(friendCircle1.getFlagId()) && text.equals(friendCircle1.getText())) {
                    boolean b1 = flagWeekService.updatefinishCount(friendCircle1.getFlagId());
                    List<FlagWeek> flagWeeks = flagWeekService.selectAll();
                    for (FlagWeek flagWeek : flagWeeks) {
                        if (flagWeek.getFinishCount().equals(flagWeek.getFlagCount())) {
                            boolean b = flagWeekService.updateIsFlag(flagWeek.getFlagId());
                        }
                    }
                }
            }
        } catch (Exception e) {
            return AjaxResult.error("打卡失败");
        }
        //成功以后返回信息
        return 1;
    }

    //按天的脚本
//    @PostMapping(value = "/day")
//    @ApiOperation("day脚本")
//    @Scheduled(cron = "0 0 0 * * ?")
    public void Day() {
        List<FlagDay> all = flagDayService.getAll();
        //获取现在时间的毫秒值
        Date date1 = new Date();
        long time = date1.getTime();
        try {
            for (FlagDay flagDay : all) {
                if (flagDay.getIsFlag().equals(0)) {
                    Date startTime = flagDay.getStartTime();
                    long time1 = startTime.getTime();
                    int l = (int) (time - time1) / (1000 * 3600 * 24);
                    System.out.println(l + "=====");
                    if (flagDay.getFinishCount().equals(l)) {
//                        //如果完成次数等于设定的目标次数，就将isFlag修改为 1
//                        if (flagDay.getFinishCount().equals(flagDay.getFlagCount())) {
//                            boolean b = flagDayService.updateIsFlag(flagDay.getFlagId());
//                        }
                        continue;
                    } else {
                        //未完成任务的业务...  1、要将这个目标在围观用户中删除掉  2、将他的金额平均分给围观他的用户,将他的金额设为0
                        Integer moneys = flagService.getMoney(flagDay.getFlagId());
                        Integer userCount = circuSeeService.getUserCount(flagDay.getFlagId());
                        if (!userCount.equals(0)) {
                            Integer money1 = moneys / userCount;
                            System.out.println(money1 + "=====");
                            List<CircleSee> circleSees = flagService.selectUserId(flagDay.getFlagId());
                            for (CircleSee circleSee : circleSees) {
                                System.out.println(money1 + "=====" + circleSee.getUserId());
                                boolean b = flagService.updateUserMoney(circleSee.getUserId(), money1);
                            }
                            boolean b = flagService.updateFlagMoney(flagDay.getFlagId());
                            boolean b1 = circuSeeService.deleteFlag(flagDay.getFlagId());
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //    @PostMapping(value = "/a")
//    @ApiOperation("kjg")
    public void Week() {
        List<FlagWeek> flagWeeks = flagWeekService.selectAll();
        //获取现在时间的毫秒值
        Date date1 = new Date();
        long time = date1.getTime();
        try {
            for (FlagWeek flagWeek : flagWeeks) {
                Date startTime = flagWeek.getEndTime();
                long time1 = startTime.getTime();
                int l = (int) (time - time1) / (1000 * 3600 * 24);
                System.out.println(l + "=====");
                if (flagWeek.getFlagCount().equals(l)) {
                    //如果完成次数等于设定的目标次数，就将isFlag修改为 1
//                    boolean b = flagWeekService.updateIsFlag(flagWeek.getFlagId());
                    continue;
                } else {
                    //未完成任务的业务...  1、要将这个目标在围观用户中删除掉  2、将他的金额平均分给围观他的用户,将他的金额设为0
                    Integer moneys = flagService.getMoney(flagWeek.getFlagId());
                    Integer userCount = circuSeeService.getUserCount(flagWeek.getFlagId());
                    if (!userCount.equals(0)) {
                        Integer money1 = moneys / userCount;
                        System.out.println(money1 + "=====");
                        List<CircleSee> circleSees = flagService.selectUserId(flagWeek.getFlagId());
                        for (CircleSee circleSee : circleSees) {
                            System.out.println(money1 + "=====" + circleSee.getUserId());
                            boolean b = flagService.updateUserMoney(circleSee.getUserId(), money1);
                        }
                        boolean b = flagService.updateFlagMoney(flagWeek.getFlagId());
                        boolean b1 = circuSeeService.deleteFlag(flagWeek.getFlagId());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @PostMapping(value = "/clock")
    @ApiOperation("打卡记录")
    public Object gerClock(@RequestParam Integer userId) {
        HashMap<String, List<Clock>> map = new HashMap<>();
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
//        try {
        List<Clock> dayClock = flagService.getDayClock(userId);
        List<Clock> weekClock = flagService.getWeekClock(userId);
        List<List<Clock>> lists = new ArrayList<>();
        lists.add(dayClock);
        lists.add(weekClock);
        List<Clock> clock1 = new ArrayList<>();
        List<Clock> clock2 = new ArrayList<>();
        String result = "";
        for (List<Clock> list : lists) {
            for (Clock clock : list) {
                if (clock.getIsflag().equals(0)) {
//                        if (clock.getFlagCount() != 0 && clock.getFinishCount() != 0){
                    result = numberFormat.format((float) clock.getFinishCount() / (float) clock.getFlagCount() * 100) + "%";
//                        }else {
//                            result = "0.00%";
//                        }
                    clock.setResult(result);
//                        System.out.println(clock.getRecentTime()+"............");
                    if (null == clock.getRecentTime()) {
                        clock.setRecentTime(null);
                    } else {
                        clock.setRecentTime(clock.getRecentTime().substring(0, 10));
                    }
                    clock1.add(clock);
                    map.put("0", clock1);
                }
                if (clock.getIsflag().equals(1)) {
//                        if (clock.getFlagCount() != 0 && clock.getFinishCount() != 0){
                    result = numberFormat.format((float) clock.getFinishCount() / (float) clock.getFlagCount() * 100) + "%";
//                        }else {
//                            result = "0.00%";
//                        }
                    clock.setResult(result);
                    if (null == clock.getRecentTime()) {
                        clock.setRecentTime(null);
                    } else {
                        clock.setRecentTime(clock.getRecentTime().substring(0, 10));
                    }
                    clock2.add(clock);
                    map.put("1", clock2);
                }
            }
        }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return 0+e.getMessage();
//        }
        return map;
    }

    @PostMapping(value = "/circusee")
    @ApiOperation("围观事件")
    public Integer circuseeCount(CircleSee circleSee) {
        List<CircleSee> all = circuSeeService.getAll();
        //根据userid查询此用户的围观人数，超过10人则不可再围观
        Integer integer = circuSeeService.selectCount(circleSee.getUserId());
        for (CircleSee circleSee1 : all) {
            if (circleSee.getFlagId().equals(circleSee1.getFlagId()) && circleSee.getUserId().equals(circleSee1.getUserId()) && integer > 10) {
                System.out.println("大于10个或者flag的id和user的id相同");
                return 0;
            }
        }
        boolean cirCuSee = circuSeeService.createCirCuSee(circleSee.getFlagId(), circleSee.getUserId());
        if (!cirCuSee) {
            System.out.println("没有插入进去朋友圈");
            return 0;
        }
        List<FlagDay> flagDays = flagDayService.selectDayFlagId();
        List<FlagWeek> flagWeeks = flagWeekService.selectWeekFlagId();
        try {
            for (FlagDay flagDay : flagDays) {
                if (flagDay.getFlagId().equals(circleSee.getFlagId())) {
                    boolean b = flagDayService.updateCircuSeeCount(circleSee.getFlagId());
                }
            }
            for (FlagWeek flagWeek : flagWeeks) {
                if (flagWeek.getFlagId().equals(circleSee.getFlagId())) {
                    boolean b1 = flagWeekService.updateCircuSeeCount(circleSee.getFlagId());
                }
            }
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @PostMapping(value = "/createFlagWeek")
    @ApiOperation("创建目标按周")
    public Object createFlagWeek(@RequestParam String flagName, @RequestParam Integer userId, @RequestParam Integer money, @RequestParam String endTime, @RequestParam Integer flagCount) {
        Date ends = null;
        try {
            List<Flag> all = flagService.getAll();
            for (Flag flag : all) {
                if (flagName.equals(flag.getFlagName()) && userId == flag.getUserId() && money == flag.getMoney()) {
                    System.out.println("重复啦");
                    return 2;
                }
            }
            boolean flag1 = flagService.createFlag(flagName, userId, money);
            Integer flagId = flagService.getFlagId(flagName, userId);
            ends = new SimpleDateFormat("yyyy-MM-dd").parse(endTime);
            boolean flagWeek = flagWeekService.createFlagWeek(flagId, ends, flagCount);
            if (!flag1 || !flagWeek) {
                System.out.println("插入失败");
                return -1;
            }
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @PostMapping(value = "/praise")
    @ApiOperation("点赞数")
    public Integer praise(@RequestParam Integer circleId, @RequestParam Integer userId) {
        List<Praise> praises = praiseService.selectAll();
        for (Praise praise : praises) {
            if (circleId.equals(praise.getCircleId()) && userId.equals(praise.getUserId())) {
                System.out.println("重复啦");
                return 0;
            }
        }
        //插入点赞
        boolean count = praiseService.createCount(circleId, userId);
        //修改点赞数
        System.out.println(circleId + "=========" + userId);
        boolean b = friendCircleService.updateCount(circleId);
        if (!count || !b) {
            return 0;
        }
        return 1;
    }

    @PostMapping(value = "/comment")
    @ApiOperation("评论")
    public Integer comment(@RequestParam Integer userId, @RequestParam Integer circleId, @RequestParam String content) {
        boolean comment = commentService.createComment(circleId, userId, content);
        if (!comment) {
            return 0;
        }
        return 1;
    }

    @GetMapping("/friendCircleall")
    @ApiOperation("所有的朋友圈信息")
    public List<FriendCircleDateVo> all() {
        List<FriendCircleDateVo> all = friendCircleService.getAll();
        return all;
    }

    @PostMapping(value = "/getComment")
    @ApiOperation("评论")
    public List<CommentDataVo> getComment(@RequestParam Integer circleId) {
        List<CommentDataVo> comment = friendCircleService.getComment(circleId);
        return comment;
    }


    @PostMapping(value = "/circuSeeAll")
    @ApiOperation("用户围观的目标")
    public List<FriendCircleDateVo> getCircuSeeAll(@RequestParam Integer userId) {
        List<FriendCircleDateVo> friendCircleDateVos = friendCircleService.selectCircuSeeAll(userId);
        return friendCircleDateVos;
    }

    @PostMapping(value = "/FlagCircle")
    @ApiOperation("根据目标Id来查询目标的所有的朋友圈")
    public List FlagCircle(@RequestParam Integer flagId) {
        Integer integer = flagService.selectByFlagId(flagId);
        List<FlagDay> all = flagDayService.getAll();
        List<FlagWeek> flagWeeks = flagWeekService.selectAll();
        List<FlagDayCircleDataVo> flagDayCircleDataVos = null;
        for (FlagDay flagDay : all) {
            if (flagId.equals(flagDay.getFlagId())) {
                flagDayCircleDataVos = flagService.selectFlagCircle(flagId, integer);
            }
        }
        for (FlagWeek flagWeek : flagWeeks) {
            if (flagId.equals(flagWeek.getFlagId())) {
                flagDayCircleDataVos = flagService.selectFlagCircleWeek(flagId, integer);
            }
        }
        return flagDayCircleDataVos;
    }

}
