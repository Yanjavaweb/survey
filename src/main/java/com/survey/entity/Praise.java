package com.survey.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("点赞实体类")
public class Praise {
    @ApiModelProperty("点赞id")
    private Integer id;
    @ApiModelProperty("朋友圈的id")
    private Integer circleId;
    @ApiModelProperty("点赞这条朋友圈的用户id")
    private Integer userId;
}
