package com.survey.entity;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Data
public class FlagDayCircleDataVo {
    private String name;
    private String flagName;
    private Integer circuSeeCount;
    private Integer finishCount;
    private Integer flagCount;
    private Integer money;
    private Integer isFlag;
    private List<FlagDayCircleDataVos> list;
}

@Data
class FlagDayCircleDataVos {
    private String text;
    private String createTime;
    private String images;


}
