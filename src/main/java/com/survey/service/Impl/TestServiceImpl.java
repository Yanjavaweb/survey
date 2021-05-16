package com.survey.service.Impl;


import com.survey.entity.QuestionDateVo;
import com.survey.entity.QuestionIndex;
import com.survey.entity.Test;
import com.survey.mapper.TestMapper;
import com.survey.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 测试类型的Service的实现
 *
 * @Description:
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> allTest() {
        List<Test> testList = testMapper.allTest();
        return testList;
    }

    @Override
    public Test selectById(Integer id) {
        Test test = testMapper.selectById(id);
        return test;
    }

    @Override
    public boolean countById(Test test) {
        return testMapper.countById(test.getId()) > 0;
    }

    @Override
    public boolean updateTest(Test test) {
        return testMapper.updateTest(test) > 0;
    }

    @Override
    public boolean deleteTest(Integer id) {
        return testMapper.deleteTest(id) > 0;
    }

    @Override
    public boolean insertTest(Test test) {
        return testMapper.insertTest(test) > 0;
    }

    @Override
    public List<QuestionIndex> selectByAlias(String alias) {
        return testMapper.selectByAlias(alias);
    }

    @Override
    public List<QuestionDateVo> getList() {
        return testMapper.getList();
    }

//    @Override
//    public List<All> selectByAlias() {
//        List<All> objects = testMapper.selectByAlias();
//        for (Object s : objects){
//            System.out.println(s);
//        }
//
//        return testMapper.selectByAlias();
//    }
}
