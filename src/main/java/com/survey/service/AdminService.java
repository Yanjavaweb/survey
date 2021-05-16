package com.survey.service;

import com.survey.entity.Admin;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * 管理员service
 *
 * @Description:
 */
public interface AdminService {
    /**
     * 验证管理员是否存在
     *
     * @param user_name
     * @param user_pwd
     * @return
     */
    boolean verifyPassword(String user_name, String user_pwd);
}
