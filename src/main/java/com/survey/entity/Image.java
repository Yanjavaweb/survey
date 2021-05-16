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
@ApiModel("照片实体类")
public class Image {
    @ApiModelProperty("照片id")
    private Integer id;
    @ApiModelProperty("朋友圈的id")
    private Integer circleId;
    @ApiModelProperty("照片路径")
    private String images;
}
