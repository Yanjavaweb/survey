package com.survey.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("联表查询所有的")
public class All implements Serializable {
    @ApiModelProperty("最大类型名字")
    private String name;
    @ApiModelProperty("次类型的content")
    private String contentIndex;
    @ApiModelProperty("问题所属最小类型")
    private String type;
    @ApiModelProperty("问题描述")
    private String contentList;


}
