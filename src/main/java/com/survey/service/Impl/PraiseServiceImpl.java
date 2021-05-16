package com.survey.service.Impl;

import com.survey.entity.Praise;
import com.survey.mapper.PraiseMapper;
import com.survey.service.PraiseService;
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
public class PraiseServiceImpl implements PraiseService {

    @Autowired
    private PraiseMapper praiseMapper;

    @Override
    public boolean createCount(Integer circleId, Integer userId) {
        return praiseMapper.createCount(circleId, userId) > 0;
    }

    @Override
    public List<Praise> selectAll() {
        return praiseMapper.selectAll();
    }
}
