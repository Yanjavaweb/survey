package com.survey.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clock {
    private Integer flagId;
    private String flagName;
    private Integer circuseeCount;
    private String recentTime;
    private Integer isflag;
    private Integer money;
    private Integer finishCount;
    private Integer flagCount;
    private String result;
}
