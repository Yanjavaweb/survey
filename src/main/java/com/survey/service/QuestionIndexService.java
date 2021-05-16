package com.survey.service;


import com.survey.entity.QuestionIndex;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 次类型Service
 *
 * @Description:
 */
public interface QuestionIndexService {
    /**
     * 增加
     *
     * @param questionIndex
     * @return
     */
    boolean insert(QuestionIndex questionIndex);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 修改
     *
     * @param questionIndex
     * @return
     */
    boolean update(QuestionIndex questionIndex);

    /**
     * 查询所有的
     *
     * @return
     */
    List<QuestionIndex> allSelect();

    /**
     * 根据id查询次类别
     *
     * @param id
     * @return
     */
    QuestionIndex selectById(Integer id);

    /**
     * 根据最大类别查询所有的对应类型的次类别
     *
     * @param questionIndex
     * @return
     */
    List<QuestionIndex> selectByIndex(QuestionIndex questionIndex);

    /**
     * 根据number去查询questionlist的type
     *
     * @param number
     * @return
     */
    List<QuestionIndex> selectByNumber(Integer number);


}
