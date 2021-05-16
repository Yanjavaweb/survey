package com.survey.service;

import com.survey.entity.QuestionList;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 问题service层
 *
 * @Description:
 */

public interface QuestionListService {
    /**
     * 查询所有的问题
     *
     * @return
     */
    List<QuestionList> selectAll();

    /**
     * 查询问题通过type
     *
     * @param questionList：六种类型
     * @return
     */
    List<QuestionList> selectByType(QuestionList questionList);

    /**
     * 查询问题通过number
     *
     * @param questionList：两种类型
     * @return
     */
    List<QuestionList> selectByNumber(QuestionList questionList);

    /**
     * 插入一条问题
     *
     * @param questionList
     * @return
     */
    boolean insertQuestion(QuestionList questionList);

    /**
     * 删除一条问题通过id
     *
     * @param id
     * @return
     */
    boolean deleteQuestion(Integer id);

    /**
     * 修改一条问题通过id
     *
     * @param questionList
     * @return
     */
    boolean updateQuestion(QuestionList questionList);
}
