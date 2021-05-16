package com.survey.mapper;

import com.survey.entity.QuestionList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 问题mapper层
 *
 * @Description:
 */
@Repository
public interface QuestionListMapper {
    /**
     * 查询所有的问题
     *
     * @return
     */
    List<QuestionList> selectAll();

    /**
     * 查询问题通过type
     *
     * @param type：六种类型
     * @return
     */
    List<QuestionList> selectByType(String type);

    /**
     * 查询问题通过number
     *
     * @param number：两种类型
     * @return
     */
    List<QuestionList> selectByNumber(Integer number);

    /**
     * 插入一条问题
     *
     * @param questionList
     * @return
     */
    Integer insertQuestion(QuestionList questionList);

    /**
     * 删除一条问题通过id
     *
     * @param id
     * @return
     */
    Integer deleteQuestion(Integer id);

    /**
     * 修改一条问题通过id
     *
     * @param questionList
     * @return
     */
    Integer updateQuestion(QuestionList questionList);

    /**
     * 根据类型去查询content——list
     *
     * @return
     */
    List<QuestionList> selectContentList();
}
