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
@ApiModel("此类型实体类")
public class TwoPsychic {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("类型id")
    private Integer psychicId;
    @ApiModelProperty("此类型")
    private String twoType;
    @ApiModelProperty("网址")
    private String website;
}
