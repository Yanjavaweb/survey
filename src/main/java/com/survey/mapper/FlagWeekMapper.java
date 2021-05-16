package com.survey.mapper;

import com.survey.entity.FlagWeek;
import org.springframework.stereotype.Repository;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Repository
public interface FlagWeekMapper {
    /**
     * 查询所有
     *
     * @return
     */
    List<FlagWeek> selectWeekFlagId();

    Integer updateCircuSeeCount(Integer flagId);

    /**
     * 根据flag的id去修改finish的次数
     *
     * @param flagId
     * @return
     */
    Integer updatefinishCount(Integer flagId);

    /**
     * 创建按周的目标
     *
     * @param flagId
     * @param end
     * @param flagCount
     * @return
     */
    Integer createFlagWeek(Integer flagId, Date end, Integer flagCount);

    /**
     * 查询按周的信息
     *
     * @return
     */
    List<FlagWeek> selectAll();

    /**
     * 修改按周的是否完成任务
     *
     * @param flagId
     * @return
     */
    Integer updateIsFlag(Integer flagId);
}
