package com.survey.service.Impl;

import com.survey.entity.ConsultDateVo;
import com.survey.mapper.ConsultMapper;
import com.survey.service.ConsultService;
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
public class ConsultServiceImpl implements ConsultService {

    @Autowired
    private ConsultMapper consultMapper;

    @Override
    public List<ConsultDateVo> getAll() {
        return consultMapper.getAll();
    }
}
