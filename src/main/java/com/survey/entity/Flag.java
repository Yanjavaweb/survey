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
@ApiModel("flag实体类")
public class Flag {
    @ApiModelProperty("flag的id")
    private Integer id;
    @ApiModelProperty("flag的名称")
    private String flagName;
    @ApiModelProperty("用户立flag的挑战金数额")
    private Integer money;
    @ApiModelProperty("立flag的用户id")
    private Integer userId;
}
