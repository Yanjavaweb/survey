package com.survey.mapper;

import com.survey.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 管理员mapper
 *
 * @Description:
 */
@Repository
public interface AdminMapper {
    /**
     * 验证管理员信息
     *
     * @param name
     * @param password
     * @return
     */
    Integer verifyPassword(String name, String password);
}
