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
@ApiModel("问题实体类")
public class QuestionList {
    @ApiModelProperty("问题id")
    private Integer id;
    @ApiModelProperty("所属类型编号")
    private Integer number;
    @ApiModelProperty("所属次类型")
    private String type;
    @ApiModelProperty("问题描述")
    private String contentList;

    public QuestionList(Integer number) {
        this.number = number;
    }

    public QuestionList(String type) {
        this.type = type;
    }
}
