package com.survey.mapper;

import com.survey.entity.FlagDay;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Repository
public interface FlagDayMapper {
    /**
     * 创建按天的目标相关字段
     *
     * @param flagId
     * @param startTime
     * @param endTime
     * @param flagCount
     * @return
     */
    Integer createFlagDay(Integer flagId, Date startTime, Date endTime, Integer flagCount);

    /**
     * 修改围观人数
     *
     * @param flagId
     * @return
     */
    Integer updateCircuSeeCount(Integer flagId);

    /**
     * 查询所有按天的flag的id
     *
     * @return
     */
    List<FlagDay> selectDayFlagId();

    /**
     * 根据flag的id修改finish的次数
     *
     * @param flagId
     * @return
     */
    Integer updatefinishCount(Integer flagId);

    /**
     * 查询所有信息
     *
     * @return
     */
    List<FlagDay> getAll();

    /**
     * 修改按天的是否完成任务的
     *
     * @return
     */
    Integer updateIsFlag(Integer flagId);
}
