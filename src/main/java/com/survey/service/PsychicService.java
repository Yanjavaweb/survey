package com.survey.service;

import com.survey.entity.PsychicDateVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public interface PsychicService {
    /**
     * 查询资源
     *
     * @return
     */
    List<PsychicDateVo> getAll();
}
