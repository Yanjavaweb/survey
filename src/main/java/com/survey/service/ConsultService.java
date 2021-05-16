package com.survey.service;

import com.survey.entity.ConsultDateVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public interface ConsultService {
    /**
     * 查询所有咨询
     *
     * @return
     */
    List<ConsultDateVo> getAll();
}
