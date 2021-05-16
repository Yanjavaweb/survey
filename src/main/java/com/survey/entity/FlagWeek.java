package com.survey.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("按周的坚持天数的实体类")
public class FlagWeek {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("目标的id")
    private Integer flagId;
    @ApiModelProperty("完成的次数")
    private Integer finishCount;
    @ApiModelProperty("设定的目标次数")
    private Integer flagCount;
    @ApiModelProperty("围观此条目标的人数")
    private Integer circuseeCount;
    @ApiModelProperty("设定的目标是否完成，1为完成，0未完成")
    private Integer isFlag;
    @ApiModelProperty("结束时间")
    private Date endTime;
}
