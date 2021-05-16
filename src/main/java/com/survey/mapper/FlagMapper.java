package com.survey.mapper;

import com.survey.entity.CircleSee;
import com.survey.entity.Clock;
import com.survey.entity.Flag;
import com.survey.entity.FlagDayCircleDataVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Repository
public interface FlagMapper {
    /**
     * 根据传来的参数去创建目标
     *
     * @param userId
     * @param flagName
     * @param money
     * @return
     */
    Integer createFlag(String flagName, Integer userId, Integer money);

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
     * 根据userid返回按day数据
     *
     * @param userId
     * @return
     */
    List<Clock> getDayClock(Integer userId);

    /**
     * 根据userid返回按week数据
     *
     * @param userId
     * @return
     */
    List<Clock> getWeekClock(Integer userId);

    /**
     * 根据flag的id获取当前用户的挑战金额
     *
     * @param flagId
     * @return
     */
    Integer getMoney(Integer flagId);

    /**
     * 根据flag的id查询对应的用户id
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
    Integer updateUserMoney(Integer userId, Integer money);

    /**
     * 修改用户的挑战金额
     *
     * @param flagId
     * @return
     */
    Integer updateFlagMoney(Integer flagId);

    /**
     * 在用户账户为0时修改用户的账户金额
     *
     * @param userId
     * @param money1
     * @return
     */
    Integer updateFlagMoney1(Integer userId, Integer money1);

    /**
     * 根据flagid查询对应的朋友圈
     *
     * @param flagId
     * @param userId
     * @return
     */
    List<FlagDayCircleDataVo> selectFlagCircle(Integer flagId, Integer userId);

    /**
     * @param flagId
     * @return
     */
    Integer selectByFlagId(Integer flagId);

    /**
     * 根据flagid查询对应的朋友圈
     *
     * @param flagId
     * @param userId
     * @return
     */
    List<FlagDayCircleDataVo> selectFlagCircleWeek(Integer flagId, Integer userId);
}
