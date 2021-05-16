package com.survey.service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public interface ClientService {
    /**
     * 短信验证码
     */
    Object check(String phone, String phoneCode);
}
