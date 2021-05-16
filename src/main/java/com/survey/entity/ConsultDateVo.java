package com.survey.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Data
public class ConsultDateVo {
    private String type;
    private List<ConsultDateVos> consultDateVos;
}

@Data
class ConsultDateVos {
    private String title;
    private String content;
    private String website;
    private String vator;
    private String createTime;
}
