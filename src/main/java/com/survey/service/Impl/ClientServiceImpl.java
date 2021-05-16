package com.survey.service.Impl;


import com.survey.entity.Client;
import com.survey.service.ClientService;
import org.springframework.stereotype.Service;


/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Service
public class ClientServiceImpl implements ClientService {

    public Object check(String phone, String phoneCode) {
        Client client = new Client();
        client.setAppId("hw_10180");    //开发者ID，在【设置】-【开发设置】中获取hw_10180
        client.setSecretKey("39ba02e863c66e3ca48f988ad2b02415");  //开发者密钥，在【设置】-【开发设置】中获取39ba02e863c66e3ca48f988ad2b02415
        client.setVersion("1.0");

        Client.Request request = new Client.Request();
        // 这里是json字符串，可自行实现,短信签名填写审核后的签名本身，不需要填写签名id  //'"+phoneCode+"'
        request.setBizContent("{" +
                "\"mobile\" : [\"" + phone + "\"], " +
                "\"template_id\" : \"ST_2021041300000001\"," +
                " \"type\" : \"0\"," +
                " \"sign\" : \"高校人才大数据平台\"," +
                " \"send_time\" : \"null\"," +
                " \"params\" : { \"code\" : \"" + phoneCode + "\" }}");
        request.setMethod("sms.message.send");  //sms.template.list
//        System.out.println(client.execute(request));
        return client.execute(request);
    }

}
