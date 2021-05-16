package com.survey.service.Impl;

import com.survey.entity.Total;
import com.survey.entity.TotalDateVo;
import com.survey.entity.User;
import com.survey.mapper.TotalMapper;
import com.survey.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * total 实现层
 *
 * @Description:
 */
@Service
public class TotalServiceImpl implements TotalService {
    @Autowired
    private TotalMapper totalMapper;

    @Override
    public List<Total> selectAll() {
        List<Total> totals = totalMapper.selectAll();
        return totals;
    }

    @Override
    public List<Total> selectByUserId(Total total) {
        List<Total> totals = totalMapper.selectByUserId(total.getUserId());
        return totals;
    }

    @Override
    public Integer selectByType(Total total) {
        Integer integer = totalMapper.selectByType(total.getType());
        return integer;
    }

    @Override
    public List<Total> selectByScore(Total total) {
//        List<Total> totals = totalMapper.selectByScore(total.getType()).subList(0,10);
        List<Total> totals = totalMapper.selectByScore(total.getType());
        return totals;
    }

    @Override
    public boolean update(Total total) {
        Integer update = totalMapper.update(total);
        return update > 0;
    }

    @Override
    public boolean inserts(Total total) {
        return totalMapper.inserts(total) > 0;
    }

    @Override
    public Integer getTotal() {
        return totalMapper.getTotal();
    }

    @Override
    public Integer getHollandTotal() {
        return totalMapper.getHollandTotal();
    }

    @Override
    public List<Total> selectGroupByType() {
        return totalMapper.selectGroupByType();
    }

    @Override
    public TotalDateVo getCount(String type) {
        return totalMapper.getCount(type);
    }

    @Override
    public List<User> match(String result, Integer PigeSize) {
        return totalMapper.match(result, PigeSize);
    }
}
