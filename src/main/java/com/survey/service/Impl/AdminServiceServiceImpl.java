package com.survey.service.Impl;

import com.survey.entity.Admin;
import com.survey.mapper.AdminMapper;
import com.survey.service.AdminService;
import com.survey.utils.Md5.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Service
public class AdminServiceServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean verifyPassword(String user_name, String user_pwd) {
        return adminMapper.verifyPassword(user_name, user_pwd) > 0;
    }
}
