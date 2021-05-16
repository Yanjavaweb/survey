package com.survey.mapper;

import com.survey.entity.Total;
import com.survey.entity.TotalDateVo;
import com.survey.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * total mapper层
 *
 * @Description:
 */
@Repository
public interface TotalMapper {
    /**
     * 查询所有
     *
     * @return
     */
    List<Total> selectAll();

    /**
     * 根据userId查询用户的六种类型
     *
     * @param userId
     * @return
     */
    List<Total> selectByUserId(Integer userId);

    /**
     * 根据type查询此类型所有的人数
     *
     * @param type
     * @return
     */
    Integer selectByType(String type);

    /**
     * 查询某个类型的前十名
     *
     * @param type
     * @return
     */
    List<Total> selectByScore(String type);

    /**
     * 修改
     *
     * @param total
     * @return
     */
    Integer update(Total total);

    /**
     * 插入
     *
     * @param total
     * @return
     */
    Integer inserts(Total total);

    /**
     * 查询所有参与人数
     *
     * @return
     */
    Integer getTotal();

    /**
     * 显示所有Holland人数
     *
     * @return
     */
    Integer getHollandTotal();

    /**
     * 根据分组查询现有的几种类型
     *
     * @return
     */
    List<Total> selectGroupByType();

    /**
     * json格式
     *
     * @param type
     * @return
     */
    TotalDateVo getCount(String type);

    /**
     * 根据用户需求查询学生
     *
     * @param result
     * @param PigeSize
     * @return
     */
    List<User> match(String result, Integer PigeSize);
}
