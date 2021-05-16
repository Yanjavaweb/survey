package com.survey.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalDateVo {
    @ApiModelProperty("类型")
    private String name;
    @ApiModelProperty("类型的数量")
    private Integer value;
}

