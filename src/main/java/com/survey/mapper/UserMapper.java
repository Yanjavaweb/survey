package com.survey.mapper;

import com.survey.entity.Scale;
import com.survey.entity.Total;
import com.survey.entity.User;
import com.survey.entity.UserDateVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * user mapper层
 *
 * @Description:
 */
@Repository
public interface UserMapper {
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
    Integer update(User user);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    Integer insert(User user);


    /**
     * 验证用户是否登录
     *
     * @param username
     * @param idCard
     * @param phone
     * @return
     */
    Integer verifyPassword(String username, String idCard, String phone);

    /**
     * 根据用户名字去查询用户对应id
     *
     * @param username
     * @return
     */
    Integer selectByName(String username);

    /**
     * 根据年级查询所对应的人
     *
     * @param grade
     * @return
     */
    List<User> selectByGrade(String grade);

    /**
     * 根据userid查询所对应的人数
     *
     * @param Id
     * @return
     */
    List<User> getCount(Integer Id);

    /**
     * 根据年级去分组
     *
     * @return
     */
    List<User> GroupByGrade();

    /**
     * 根据id查询每个年级前十名
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
     * 根据性别分组
     *
     * @return
     */
    List<User> GroupByGender();

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
