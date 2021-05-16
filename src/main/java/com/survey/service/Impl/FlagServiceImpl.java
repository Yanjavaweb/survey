package com.survey.service.Impl;

import com.survey.entity.CircleSee;
import com.survey.entity.Clock;
import com.survey.entity.Flag;
import com.survey.entity.FlagDayCircleDataVo;
import com.survey.mapper.FlagMapper;
import com.survey.service.FlagService;
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
public class FlagServiceImpl implements FlagService {

    @Autowired
    private FlagMapper flagMapper;

    @Override
    public boolean createFlag(String flagName, Integer userId, Integer money) {
        return flagMapper.createFlag(flagName, userId, money) > 0;
    }

    @Override
    public Integer getFlagId(String flagName, Integer userId) {
        return flagMapper.getFlagId(flagName, userId);
    }

    @Override
    public List<Flag> getAll() {
        return flagMapper.getAll();
    }

    @Override
    public List<Clock> getDayClock(Integer userId) {
        return flagMapper.getDayClock(userId);
    }

    @Override
    public List<Clock> getWeekClock(Integer userId) {
        return flagMapper.getWeekClock(userId);
    }

    @Override
    public Integer getMoney(Integer flagId) {
        return flagMapper.getMoney(flagId);
    }

    @Override
    public List<CircleSee> selectUserId(Integer flagId) {
        return flagMapper.selectUserId(flagId);
    }

    @Override
    public boolean updateUserMoney(Integer userId, Integer money) {
        return flagMapper.updateUserMoney(userId, money) > 0;
    }

    @Override
    public boolean updateFlagMoney(Integer flagId) {
        return flagMapper.updateFlagMoney(flagId) > 0;
    }

    @Override
    public boolean updateFlagMosey1(Integer userId, Integer money1) {
        return flagMapper.updateFlagMoney1(userId, money1) > 0;
    }

    @Override
    public List<FlagDayCircleDataVo> selectFlagCircle(Integer flagId, Integer userId) {
        return flagMapper.selectFlagCircle(flagId, userId);
    }

    @Override
    public Integer selectByFlagId(Integer flagId) {
        return flagMapper.selectByFlagId(flagId);
    }

    @Override
    public List<FlagDayCircleDataVo> selectFlagCircleWeek(Integer flagId, Integer userId) {
        return flagMapper.selectFlagCircleWeek(flagId, userId);
    }
}
