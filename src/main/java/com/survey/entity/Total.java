package com.survey.entity;

import io.swagger.annotations.ApiModel;
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
@ApiModel("total实体类")
public class Total {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("六种类型")
    private String type;
    @ApiModelProperty("每种类型的人数")
    private Integer count;
    @ApiModelProperty("每种类型的分数")
    private Integer score;
    @ApiModelProperty("所属的userid")
    private Integer userId;
}
