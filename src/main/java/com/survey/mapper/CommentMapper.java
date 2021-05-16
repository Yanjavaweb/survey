package com.survey.mapper;

import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Repository
public interface CommentMapper {
    /**
     * 创建评论
     *
     * @param circleId
     * @param userId
     * @param content
     * @return
     */
    Integer createComment(Integer circleId, Integer userId, String content);
}
