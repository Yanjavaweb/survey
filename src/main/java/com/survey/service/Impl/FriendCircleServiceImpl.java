package com.survey.service.Impl;

import com.survey.entity.*;
import com.survey.mapper.FriendCircleMapper;
import com.survey.service.FriendCircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Service
public class FriendCircleServiceImpl implements FriendCircleService {

    @Autowired
    private FriendCircleMapper friendCircleMapper;

    @Override
    public boolean createFriendCircle(Integer flagId, String text) {
        return friendCircleMapper.createFriendCircle(flagId, text) > 0;
    }

    @Override
    public Integer getCircleId(Integer flagId, String text) {
        return friendCircleMapper.getCircleId(flagId, text);
    }

    @Override
    public boolean createImage(Integer circleId, String images) {
        return friendCircleMapper.createImage(circleId, images) > 0;
    }

    @Override
    public List<FriendCircle> selectAll() {
        return friendCircleMapper.selectAll();
    }

    @Override
    public boolean updateCount(Integer circleId) {
        return friendCircleMapper.updateCount(circleId) > 0;
    }

    @Override
    public List<FriendCircleDateVo> getAll() {
        return friendCircleMapper.getAll();
    }

    @Override
    public List<User> selectName() {
        return friendCircleMapper.selectName();
    }

    @Override
    public List<FriendCircleDateVo> selectCircuSeeAll(Integer userId) {
        return friendCircleMapper.selectCircuSeeAll(userId);
    }

    @Override
    public List<CommentDataVo> getComment(Integer circleId) {
        return friendCircleMapper.getComment(circleId);
    }
}
