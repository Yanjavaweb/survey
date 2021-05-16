package com.survey.service;

import com.survey.entity.*;
;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public interface FlagService {
    /**
     * 根据传来的参数去创建目标
     *
     * @param userId
     * @param flagName
     * @param money
     * @return
     */
    boolean createFlag(String flagName, Integer userId, Integer money);

    /**
     * 根据名字查询flag的id
     *
     * @param flagName
     * @param userId
     * @return
     */
    Integer getFlagId(String flagName, Integer userId);

    /**
     * 查询所有flag信息
     *
     * @return
     */
    List<Flag> getAll();

    /**
     * 根据userid返回按day的数据
     *
     * @param userId
     * @return
     */
    List<Clock> getDayClock(Integer userId);

    /**
     * 根据userid返回按week的数据
     *
     * @param userId
     * @return
     */
    List<Clock> getWeekClock(Integer userId);

    /**
     * 根据flag的id查询用户的挑战金额
     *
     * @param flagId
     * @return
     */
    Integer getMoney(Integer flagId);

    /**
     * 根据flag的id查询对应用户id
     *
     * @param flagId
     * @return
     */
    List<CircleSee> selectUserId(Integer flagId);

    /**
     * 修改用户的账户金额
     *
     * @param userId
     * @param money
     * @return
     */
    boolean updateUserMoney(Integer userId, Integer money);

    /**
     * 修改挑战金额
     *
     * @param flagId
     * @return
     */
    boolean updateFlagMoney(Integer flagId);

    /**
     * 在用户账户为0时修改用户的账户金额
     *
     * @param userId
     * @param money1
     * @return
     */
    boolean updateFlagMosey1(Integer userId, Integer money1);

    /**
     * 更具flagId查询所有对应朋友圈
     *
     * @param flagId
     * @param userId
     * @return
     */
    List<FlagDayCircleDataVo> selectFlagCircle(Integer flagId, Integer userId);

    /**
     * 根据flagid查询对应的用户id
     *
     * @param flagId
     * @return
     */
    Integer selectByFlagId(Integer flagId);

    /**
     * 更具flagId查询所有对应朋友圈
     *
     * @param flagId
     * @param userId
     * @return
     */
    List<FlagDayCircleDataVo> selectFlagCircleWeek(Integer flagId, Integer userId);
}
