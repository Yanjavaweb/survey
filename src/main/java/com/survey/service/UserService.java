package com.survey.service;

import com.survey.entity.Scale;
import com.survey.entity.Total;
import com.survey.entity.User;
import com.survey.entity.UserDateVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * user Service层
 *
 * @Description:
 */
public interface UserService {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> selectAll();

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    boolean update(User user);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    boolean insert(User user);

    /**
     * 验证用户是否登录
     *
     * @param user
     * @return
     */
    boolean verifyPassword(User user);

    /**
     * 根据用户名字去查询用户对应id
     *
     * @param username
     * @return
     */
    Integer selectByName(String username);

    /**
     * 根据年级来查询所对应的人
     *
     * @return
     */
    List<User> selectByGrade(String grade);

    /**
     * 根据userid
     *
     * @param userId
     * @return
     */
    List<User> getCount(Integer userId);

    /**
     * 根据年级去分组
     *
     * @return
     */
    List<User> GroupByGrade();

    /**
     * 分组id查询年级前十名
     *
     * @param type
     * @param grade
     * @return
     */
    List<UserDateVo> getFirstTen(String type, String grade);

    /**
     * 查询每个年级的男女比例
     *
     * @param type
     * @param gender
     * @param grade
     * @return
     */
    Scale getScale(String type, String gender, String grade);

    /**
     * 根据性别去分组
     *
     * @return
     */
    List<User> GroupByGender();

    /**
     * 处理登录
     *
     * @param loginId
     * @param password
     * @return
     */
    Object getLogin(String loginId, String password);

    /**
     * 获取整个的结果首字母的男女比例
     *
     * @return
     */
    Scale getScales(String type, String gender);

    /**
     * 判断openid是否存在
     *
     * @param openId
     * @return
     */
    User getOpenId(String openId);


    /**
     * 根据userid查询用户
     *
     * @param userId
     * @return
     */
    User selectByUserId(Integer userId);
}
