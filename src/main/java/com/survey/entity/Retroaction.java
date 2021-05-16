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
@ApiModel("投诉的实体类")
public class Retroaction {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("投诉类型")
    private String type;
    @ApiModelProperty("发布朋友圈的id")
    private Integer circleId;
}
