package com.survey.service;

import com.survey.entity.CircleSee;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public interface CircuSeeService {
    /**
     * 插入围观的信息
     *
     * @param flagId
     * @param userId
     * @return
     */
    boolean createCirCuSee(Integer flagId, Integer userId);

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
    boolean deleteFlag(Integer flagId);

    /**
     * 根据userid查询是否围观10人，围观10人则不可在围观
     *
     * @param userId
     * @return
     */
    Integer selectCount(Integer userId);
}
