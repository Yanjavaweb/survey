package com.survey.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * 次类别实体类
 *
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("次类别实体类")
public class QuestionIndex {
    @ApiModelProperty("次类别id")
    private Integer id;
    @ApiModelProperty("最大类别别名")
    private String index;
    @ApiModelProperty("次类别编号")
    private Integer number;
    @ApiModelProperty("次类别类名")
    private String contentIndex;

    public QuestionIndex(String index) {
        this.index = index;
    }
}
