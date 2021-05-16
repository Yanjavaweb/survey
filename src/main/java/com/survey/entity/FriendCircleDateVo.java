package com.survey.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Data
public class FriendCircleDateVo {
    private String name;
    //    private List<FriendCircleDateVos> list;
    private Integer flagId;
    private String flagName;
    private Integer money;
    private Integer circleId;
    @ApiModelProperty("点赞数")
    private Integer count;
    private String text;
    private String images;
    private String createTime;
}
//@Data
//class FriendCircleDateVos{
//    private Integer flagId;
//    private String flagName;
//    private Integer money;
//    private Integer circleId;
//    @ApiModelProperty("点赞数")
//    private Integer count;
//    private String text;
//    private String images;
//    private Date createTime;
//}
