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
@ApiModel("按天的坚持天数")
public class FlagDay {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("目标id")
    private Integer flagId;
    @ApiModelProperty("完成的次数")
    private Integer finishCount;
    @ApiModelProperty("设定的目标次数")
    private Integer flagCount;
    @ApiModelProperty("围观此条目标的人数")
    private Integer circuseeCount;
    @ApiModelProperty("是否完成设定的任务，1为完成，0未完成")
    private Integer isFlag;
    @ApiModelProperty("目标开始时间")
    private Date startTime;
    @ApiModelProperty("目标结束时间")
    private Date endTime;
}
