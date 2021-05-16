package com.survey.mapper;

import com.survey.entity.Praise;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Repository
public interface PraiseMapper {
    /**
     * @param circleId
     * @param userId
     * @return
     */
    Integer createCount(Integer circleId, Integer userId);

    /**
     * 查询所有点赞
     *
     * @return
     */
    List<Praise> selectAll();
}
