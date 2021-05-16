package com.survey.service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public interface CommentService {
    /**
     * 创建评论
     *
     * @param circleId
     * @param userId
     * @param content
     * @return
     */
    boolean createComment(Integer circleId, Integer userId, String content);
}
