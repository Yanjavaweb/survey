package com.survey.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDateVo {
    @ApiModelProperty("用户姓名")
    private String username;
    @ApiModelProperty("用户所属年级")
    private String grade;
    @ApiModelProperty("用户类型")
    private String type;
    @ApiModelProperty("用户总分")
    private Integer count;
    @ApiModelProperty("用户类型的分数")
    private Integer score;
}
