package com.survey.service;

import com.survey.entity.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public interface FriendCircleService {
    /**
     * 朋友圈打卡
     *
     * @param flagId
     * @param text
     * @return
     */
    boolean createFriendCircle(Integer flagId, String text);

    /**
     * 根据flagid和text去查询对应的id
     *
     * @param flagId
     * @param text
     * @return
     */
    Integer getCircleId(Integer flagId, String text);

    /**
     * 插入朋友圈打卡的图片
     *
     * @param images
     * @param circleId
     * @return
     */
    boolean createImage(Integer circleId, String images);

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
    boolean updateCount(Integer circleId);

    /**
     * 所有的朋友圈信息
     *
     * @return
     */
    List<FriendCircleDateVo> getAll();

    /**
     * 查询所有用户的网名
     *
     * @return
     */
    List<User> selectName();

    /**
     * 查询围观的朋友圈
     *
     * @param userId
     * @return
     */
    List<FriendCircleDateVo> selectCircuSeeAll(Integer userId);

    /**
     * 查询评论
     *
     * @param circleId
     * @return
     */
    List<CommentDataVo> getComment(Integer circleId);
}
