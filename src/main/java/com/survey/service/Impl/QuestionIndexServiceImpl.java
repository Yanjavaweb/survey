package com.survey.service.Impl;


import com.survey.entity.QuestionIndex;
import com.survey.mapper.QuestionIndexMapper;
import com.survey.service.QuestionIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 此类型实现类
 *
 * @Description:
 */
@Service("questionIndexService")
public class QuestionIndexServiceImpl implements QuestionIndexService {
    @Autowired
    private QuestionIndexMapper questionIndexMapper;

    @Override
    public boolean insert(QuestionIndex questionIndex) {
        return questionIndexMapper.insert(questionIndex) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return questionIndexMapper.delete(id) > 0;
    }

    @Override
    public boolean update(QuestionIndex questionIndex) {
        return questionIndexMapper.update(questionIndex) > 0;
    }

    @Override
    public List<QuestionIndex> allSelect() {
        return questionIndexMapper.selectAll();
    }


    @Override
    public QuestionIndex selectById(Integer id) {
        QuestionIndex questionIndex = questionIndexMapper.selectById(id);
        return questionIndex;
    }

    @Override
    public List<QuestionIndex> selectByIndex(QuestionIndex questionIndex) {
        List<com.survey.entity.QuestionIndex> questionIndexList = questionIndexMapper.selectByIndex(questionIndex.getIndex());
        return questionIndexList;
    }

    @Override
    public List<QuestionIndex> selectByNumber(Integer number) {
        return questionIndexMapper.selectByNumber(number);
    }
}
