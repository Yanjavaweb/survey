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
@ApiModel("心理实体类")
public class Psychic {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("类型")
    private String type;
}
