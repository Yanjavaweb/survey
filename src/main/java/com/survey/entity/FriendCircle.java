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
@ApiModel("朋友圈实体类")
public class FriendCircle {
    @ApiModelProperty("朋友圈id")
    private Integer id;
    @ApiModelProperty("发布此朋友圈的目标id")
    private Integer flagId;
    @ApiModelProperty("朋友圈的文本内容")
    private String text;
    @ApiModelProperty("点赞总量")
    private Integer count;
}
