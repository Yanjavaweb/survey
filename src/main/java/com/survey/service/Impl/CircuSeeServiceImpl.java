package com.survey.service.Impl;

import com.survey.entity.CircleSee;
import com.survey.mapper.CircuSeeMapper;
import com.survey.service.CircuSeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Service
public class CircuSeeServiceImpl implements CircuSeeService {

    @Autowired
    private CircuSeeMapper circuSeeMapper;

    @Override
    public boolean createCirCuSee(Integer flagId, Integer userId) {
        return circuSeeMapper.createCircuSee(flagId, userId) > 0;
    }

    @Override
    public List<CircleSee> getAll() {
        return circuSeeMapper.getAll();
    }

    @Override
    public Integer getUserCount(Integer flagId) {
        return circuSeeMapper.getUserCount(flagId);
    }

    @Override
    public boolean deleteFlag(Integer flagId) {
        return circuSeeMapper.deleteFlag(flagId) > 0;
    }

    @Override
    public Integer selectCount(Integer userId) {
        return circuSeeMapper.selectCount(userId);
    }
}
