package com.survey.service.Impl;

import com.survey.mapper.CommentMapper;
import com.survey.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public boolean createComment(Integer circleId, Integer userId, String content) {
        return commentMapper.createComment(circleId, userId, content) > 0;
    }
}
