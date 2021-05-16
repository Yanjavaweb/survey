package com.survey.mapper;

import com.survey.entity.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 测试类型实体类
 *
 * @Description:
 */
@Repository
public interface TestMapper {
    /**
     * 查询所有类别
     *
     * @return
     */
    List<Test> allTest();

    /**
     * 增加测试类型
     *
     * @param test
     * @return
     */
    Integer insertTest(Test test);

    /**
     * 根据id删除测试类型
     *
     * @param id
     * @return
     */
    Integer deleteTest(Integer id);

    /**
     * 根据id修改测试类型
     *
     * @param test
     * @return
     */
    Integer updateTest(Test test);

    /**
     * 根据id查询每个测试类别提交的人数
     *
     * @param id
     * @return
     */
    Test selectById(Integer id);

    /**
     * 根据id来累加每个类别的提交人数
     *
     * @param id
     * @return
     */
    Integer countById(Integer id);

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
