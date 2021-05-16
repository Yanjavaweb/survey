package com.survey.service.Impl;

import com.survey.entity.PsychicDateVo;
import com.survey.mapper.PsychicMapper;
import com.survey.service.PsychicService;
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
public class PsychicServiceImpl implements PsychicService {
    @Autowired
    private PsychicMapper psychicMapper;

    @Override
    public List<PsychicDateVo> getAll() {
        return psychicMapper.getAll();
    }
}
