package com.survey.mapper;

import com.survey.entity.PsychicDateVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Repository
public interface PsychicMapper {
    /**
     * 查询资源
     *
     * @return
     */
    List<PsychicDateVo> getAll();
}
