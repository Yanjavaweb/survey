package com.survey.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * 测试类型实体类
 *
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("测试类型实体类")
public class Test {
    @ApiModelProperty("测试类型id")
    private Integer id;
    @ApiModelProperty("测试类型名称")
    private String name;
    @ApiModelProperty("测试类型别名")
    private String alias;
    @ApiModelProperty("提交每个测试类型的人数")
    private Integer testCount;
}
