package com.survey.mapper;

import com.survey.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Repository
public interface FriendCircleMapper {
    /**
     * 朋友圈打卡
     *
     * @param flagId
     * @param text
     * @return
     */
    Integer createFriendCircle(Integer flagId, String text);

    /**
     * 根据userid和text查询对应的id
     *
     * @param flagId
     * @param text
     * @return
     */
    Integer getCircleId(Integer flagId, String text);

    /**
     * 插入图片
     *
     * @param circleId
     * @param images
     * @return
     */
    Integer createImage(Integer circleId, String images);

    /**
     * 查询所有朋友圈
     *
     * @return
     */
    List<FriendCircle> selectAll();

    /**
     * 根据朋友圈id修改点赞数
     *
     * @param circleId
     * @return
     */
    Integer updateCount(Integer circleId);

    /**
     * 所有的朋友圈信息
     *
     * @return
     */
    List<FriendCircleDateVo> getAll();

    /**
     * 查询所有网名
     *
     * @return
     */
    List<User> selectName();

    /**
     * 获取围观的朋友圈
     *
     * @param userId
     * @return
     */
    List<FriendCircleDateVo> selectCircuSeeAll(Integer userId);

    /**
     * 查询对应朋友圈的评论
     *
     * @param circleId
     * @return
     */
    List<CommentDataVo> getComment(Integer circleId);
}
