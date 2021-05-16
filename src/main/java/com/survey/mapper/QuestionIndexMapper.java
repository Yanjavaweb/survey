package com.survey.mapper;


import com.survey.entity.QuestionIndex;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 次类别mapper
 *
 * @Description:
 */
@Repository
public interface QuestionIndexMapper {
    /**
     * 增加次类别
     *
     * @param questionIndex
     * @return
     */
    Integer insert(QuestionIndex questionIndex);

    /**
     * 修改
     *
     * @param questionIndex
     * @return
     */
    Integer update(QuestionIndex questionIndex);

    /**
     * 根据id删除次类别
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查询次类别
     *
     * @param id
     * @return
     */
    QuestionIndex selectById(Integer id);

    /**
     * 根据最大类别的别名查询所有对应的次类别
     *
     * @param index
     * @return
     */
    List<QuestionIndex> selectByIndex(@Param("index") String index);

    /**
     * 查询所有
     *
     * @return
     */
    List<QuestionIndex> selectAll();

    /**
     * 根据number去查询questionlist的type
     *
     * @param number
     * @return
     */
    List<QuestionIndex> selectByNumber(Integer number);

}
