package com.survey.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Data
public class PsychicDateVo {
    @ApiModelProperty("类型名称")
    private String name;
    @ApiModelProperty("类型id")
    private Integer id;
    private List<PsychicDateVos> psychicDateVos;
}

@Data
class PsychicDateVos {
    @ApiModelProperty("此类型")
    private String twoType;
    @ApiModelProperty("网址")
    private String website;
    @ApiModelProperty("描述")
    private String content;
}
