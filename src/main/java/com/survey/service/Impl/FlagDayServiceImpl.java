package com.survey.service.Impl;

import com.survey.entity.FlagDay;
import com.survey.mapper.FlagDayMapper;
import com.survey.service.FlagDayService;
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
public class FlagDayServiceImpl implements FlagDayService {

    @Autowired
    private FlagDayMapper flagDayMapper;

    @Override
    public boolean createFlagDay(Integer flagId, Date startTime, Date endTime, Integer flagCount) {
        return flagDayMapper.createFlagDay(flagId, startTime, endTime, flagCount) > 0;
    }

    @Override
    public boolean updateCircuSeeCount(Integer flagId) {
        return flagDayMapper.updateCircuSeeCount(flagId) > 0;
    }

    @Override
    public List<FlagDay> selectDayFlagId() {
        return flagDayMapper.selectDayFlagId();
    }

    @Override
    public boolean updatefinishCount(Integer flagId) {
        return flagDayMapper.updatefinishCount(flagId) > 0;
    }

    @Override
    public List<FlagDay> getAll() {
        return flagDayMapper.getAll();
    }

    @Override
    public boolean updateIsFlag(Integer flagId) {
        return flagDayMapper.updateIsFlag(flagId) > 0;
    }
}
