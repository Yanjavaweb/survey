package com.survey.mapper;

import com.survey.entity.ConsultDateVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Repository
public interface ConsultMapper {
    /**
     * 查询所有咨询
     *
     * @return
     */
    List<ConsultDateVo> getAll();
}
