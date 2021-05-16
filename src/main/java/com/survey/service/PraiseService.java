package com.survey.service;

import com.survey.entity.Praise;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public interface PraiseService {
    /**
     * 插入点赞数
     *
     * @param circleId
     * @param userId
     * @return
     */
    boolean createCount(Integer circleId, Integer userId);

    /**
     * 查询所有点赞
     *
     * @return
     */
    List<Praise> selectAll();
}
