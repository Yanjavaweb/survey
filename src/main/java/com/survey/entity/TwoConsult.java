package com.survey.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("此咨询类型实体类")
public class TwoConsult {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("咨询id")
    private Integer consultId;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("描述")
    private String content;
    @ApiModelProperty("网址")
    private String website;
    @ApiModelProperty("图片链接")
    private String vator;
    @ApiModelProperty("创建时间")
    private Date createTime;
}
