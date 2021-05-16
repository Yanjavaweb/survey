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
@ApiModel("评论实体类")
public class Comment {
    @ApiModelProperty("评论id")
    private Integer id;
    @ApiModelProperty("朋友圈id")
    private Integer circleId;
    @ApiModelProperty("发布此朋友圈的用户id")
    private Integer userId;
    @ApiModelProperty("评论此条朋友圈的用户id")
    private Integer userUserId;
    @ApiModelProperty("评论内容")
    private String content;
    @ApiModelProperty("评论时间")
    private Date createTime;
}
