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
@ApiModel("围观实体类")
public class CircleSee {
    @ApiModelProperty("围观id")
    private Integer id;
    @ApiModelProperty("目标的id")
    private Integer flagId;
    @ApiModelProperty("围观此朋友圈的用户id")
    private Integer userId;
}
