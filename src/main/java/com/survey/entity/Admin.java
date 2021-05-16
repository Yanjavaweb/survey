package com.survey.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * 管理员信息
 *
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("管理员实体类")
public class Admin {
    @ApiModelProperty("管理员id")
    private int id;
    @ApiModelProperty("管理员账号")
    private String name;
    @ApiModelProperty("管理员密码")
    private String password;
}
