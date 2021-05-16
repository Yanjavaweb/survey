package com.survey.service.Impl;

import com.survey.entity.FlagWeek;
import com.survey.mapper.FlagWeekMapper;
import com.survey.service.FlagWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Service
public class FlagWeekServiceImpl implements FlagWeekService {

    @Autowired
    private FlagWeekMapper flagWeekMapper;

    @Override
    public List<FlagWeek> selectWeekFlagId() {
        return flagWeekMapper.selectWeekFlagId();
    }

    @Override
    public boolean updateCircuSeeCount(Integer flagId) {
        return flagWeekMapper.updateCircuSeeCount(flagId) > 0;
    }

    @Override
    public boolean updatefinishCount(Integer flagId) {
        return flagWeekMapper.updatefinishCount(flagId) > 0;
    }

    @Override
    public boolean createFlagWeek(Integer flagId, Date end, Integer flagCount) {
        return flagWeekMapper.createFlagWeek(flagId, end, flagCount) > 0;
    }

    @Override
    public List<FlagWeek> selectAll() {
        return flagWeekMapper.selectAll();
    }

    @Override
    public boolean updateIsFlag(Integer flagId) {
        return flagWeekMapper.updateIsFlag(flagId) > 0;
    }
}
