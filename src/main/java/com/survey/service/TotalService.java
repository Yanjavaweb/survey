package com.survey.service;

import com.survey.entity.Total;
import com.survey.entity.TotalDateVo;
import com.survey.entity.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * total Service层
 *
 * @Description:
 */
public interface TotalService {
    /**
     * 查询所有
     *
     * @return
     */
    List<Total> selectAll();

    /**
     * 根据userId查询用户的六种类型
     *
     * @param total
     * @return
     */
    List<Total> selectByUserId(Total total);

    /**
     * 根据type查询此类型所有的人数
     *
     * @param total
     * @return
     */
    Integer selectByType(Total total);

    /**
     * 查询某个类型的前十名
     *
     * @param total
     * @return
     */
    List<Total> selectByScore(Total total);

    /**
     * 修改
     *
     * @param total
     * @return
     */
    boolean update(Total total);

    /**
     * 插入
     *
     * @param total
     * @return
     */
    boolean inserts(Total total);

    /**
     * 显示所有参与人数
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
     * 根据用户需求来查询学生
     *
     * @param result
     * @param PigeSize
     * @return
     */
    List<User> match(String result, Integer PigeSize);
}
