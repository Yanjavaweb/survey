package com.survey.service;

import com.survey.entity.All;
import com.survey.entity.QuestionDateVo;
import com.survey.entity.QuestionIndex;
import com.survey.entity.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 测试Service层
 *
 * @Description:
 */
public interface TestService {
    /**
     * 查询所有的测试类型
     *
     * @return
     */
    List<Test> allTest();

    /**
     * 根据id修改测试类型
     *
     * @param test
     * @return
     */
    boolean updateTest(Test test);

    /**
     * 根据id查询每个类别提交的人数
     *
     * @param id
     * @return
     */
    Test selectById(Integer id);

    /**
     * 根据id来累加每个类别的提交人数
     *
     * @param test
     * @return
     */
    boolean countById(Test test);

    /**
     * 根据id删除测试类型
     *
     * @param id
     * @return
     */
    boolean deleteTest(Integer id);

    /**
     * 添加一条测试类型
     *
     * @param test
     * @return
     */
    boolean insertTest(Test test);

    /**
     * 根据别名查询所对应questionIndex表
     *
     * @param alias
     * @return
     */
    List<QuestionIndex> selectByAlias(String alias);

    /**
     * 返回json格式
     *
     * @return
     */
    List<QuestionDateVo> getList();
}
