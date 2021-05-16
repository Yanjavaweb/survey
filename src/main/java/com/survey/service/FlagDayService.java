package com.survey.service;

import com.survey.entity.FlagDay;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public interface FlagDayService {
    /**
     * 创建按天的目标相关字段
     *
     * @param flagId
     * @param startTime
     * @param endTime
     * @param flagCount
     * @return
     */
    boolean createFlagDay(Integer flagId, Date startTime, Date endTime, Integer flagCount);

    /**
     * 修改围观次数
     *
     * @return
     */
    boolean updateCircuSeeCount(Integer flagId);

    /**
     * 查询所有按天打卡的flag的id
     *
     * @return
     */
    List<FlagDay> selectDayFlagId();

    boolean updatefinishCount(Integer flagId);

    /**
     * 查询所有信息
     *
     * @return
     */
    List<FlagDay> getAll();

    /**
     * 修改按天的是否完成任务
     *
     * @return
     */
    boolean updateIsFlag(Integer flagId);
}
