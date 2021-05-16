package com.survey.service.Impl;

import com.survey.entity.QuestionList;
import com.survey.mapper.QuestionListMapper;
import com.survey.service.QuestionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Service
public class QuestionListServiceImpl implements QuestionListService {

    @Autowired
    private QuestionListMapper questionListMapper;

    @Override
    public List<QuestionList> selectAll() {
        List<QuestionList> questionLists = questionListMapper.selectAll();
        return questionLists;
    }

    @Override
    public List<QuestionList> selectByType(QuestionList questionList) {
        List<QuestionList> questionLists = questionListMapper.selectByType(questionList.getType());
        return questionLists;
    }

    @Override
    public List<QuestionList> selectByNumber(QuestionList questionList) {
        List<QuestionList> questionLists = questionListMapper.selectByNumber(questionList.getNumber());
        return questionLists;
    }

    @Override
    public boolean insertQuestion(QuestionList questionList) {
        return questionListMapper.insertQuestion(questionList) > 0;
    }

    @Override
    public boolean deleteQuestion(Integer id) {
        return questionListMapper.deleteQuestion(id) > 0;
    }

    @Override
    public boolean updateQuestion(QuestionList questionList) {
        return questionListMapper.updateQuestion(questionList) > 0;
    }
}
