package com.survey.service;

import com.survey.entity.FlagWeek;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public interface FlagWeekService {
    /**
     * 查询所有的按周的flag的id
     *
     * @return
     */
    List<FlagWeek> selectWeekFlagId();

    /**
     * 修改按周的flag的围观人数
     *
     * @param flagId
     * @return
     */
    boolean updateCircuSeeCount(Integer flagId);

    /**
     * 根据flag的id去修改finish的次数
     *
     * @param flagId
     * @return
     */
    boolean updatefinishCount(Integer flagId);

    /**
     * 创建按周的目标
     *
     * @param flagId
     * @param end
     * @param flagCount
     * @return
     */
    boolean createFlagWeek(Integer flagId, Date end, Integer flagCount);

    /**
     * 查询所有按周的信息
     *
     * @return
     */
    List<FlagWeek> selectAll();

    /**
     * 修改按周的是否完成
     *
     * @param flagId
     * @return
     */
    boolean updateIsFlag(Integer flagId);
}
