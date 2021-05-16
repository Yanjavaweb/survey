package com.survey.mapper;

import com.survey.entity.CircleSee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Repository
public interface CircuSeeMapper {
    /**
     * 插入围观的信息
     *
     * @param flagId
     * @param userId
     * @return
     */
    Integer createCircuSee(Integer flagId, Integer userId);

    /**
     * 查询所有
     *
     * @return
     */
    List<CircleSee> getAll();

    /**
     * 根据flag的id查询围观的总人数
     *
     * @param flagId
     * @return
     */
    Integer getUserCount(Integer flagId);

    /**
     * 根据flag的id删除围观
     *
     * @param flagId
     * @return
     */
    Integer deleteFlag(Integer flagId);

    /**
     * 根据userid查询此用户围观的人数，10人则不可再围观
     *
     * @param userId
     * @return
     */
    Integer selectCount(Integer userId);
}
