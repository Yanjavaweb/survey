package com.survey.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * user 实体类
 *
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("user实体类")
public class User {
    @ApiModelProperty("用户id")
    private Integer id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("用户身份证")
    private String idCard;
    @ApiModelProperty("用户电话")
    private String phone;
    @ApiModelProperty("用户测试结果")
    private String result;
    @ApiModelProperty("用户所属年级")
    private String grade;
    @ApiModelProperty("性别")
    private String gender;
    @ApiModelProperty("学号")
    private Integer sno;
    @ApiModelProperty("院系")
    private String college;
    @ApiModelProperty("专业")
    private String major;
    @ApiModelProperty("班级")
    private String classes;
    @ApiModelProperty("微信的openid")
    private String openId;
    @ApiModelProperty("用户账户金额")
    private Integer money;
    @ApiModelProperty("用户的网名")
    private String name;

}
