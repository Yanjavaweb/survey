package com.survey.service.Impl;

import cn.gjing.http.HttpClient;
import cn.gjing.http.HttpMethod;
import com.survey.entity.Scale;
import com.survey.entity.User;
import com.survey.entity.UserDateVo;
import com.survey.mapper.UserMapper;
import com.survey.service.UserService;
import com.survey.utils.Md5.Md5Utils;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.survey.utils.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created with IntelliJ IDEA.
 * user 实现层
 *
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public boolean update(User user) {
        return userMapper.update(user) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return userMapper.delete(id) > 0;
    }

    @Override
    public boolean insert(User user) {
        String md5Str = Md5Utils.getMD5Str(user.getIdCard());
        user.setIdCard(md5Str);
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean verifyPassword(User user) {
        return userMapper.verifyPassword(user.getUsername(), Md5Utils.getMD5Str(user.getIdCard()), user.getPhone()) > 0;
    }

    @Override
    public Integer selectByName(String username) {
        return userMapper.selectByName(username);
    }

    @Override
    public List<User> selectByGrade(String grade) {
        return userMapper.selectByGrade(grade);
    }

    @Override
    public List<User> getCount(Integer userId) {
        return userMapper.getCount(userId);
    }

    @Override
    public List<User> GroupByGrade() {
        return userMapper.GroupByGrade();
    }

    @Override
    public List<UserDateVo> getFirstTen(String type, String grade) {
        return userMapper.getFirstTen(type, grade);
    }

    @Override
    public Scale getScale(String type, String gender, String grade) {
        return userMapper.getScale(type, gender, grade);
    }

    @Override
    public List<User> GroupByGender() {
        return userMapper.GroupByGender();
    }

    @Override
    public Object getLogin(String loginId, String password) {
        return null;
    }

    @Override
    public Scale getScales(String type, String gender) {
        return userMapper.getScales(type, gender);
    }

    @Override
    public User getOpenId(String openId) {
        return userMapper.getOpenId(openId);
    }

    @Override
    public User selectByUserId(Integer userId) {
        return userMapper.selectByUserId(userId);
    }
}
