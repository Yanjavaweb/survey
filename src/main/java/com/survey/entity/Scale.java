package com.survey.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("查询每个年级的男女比例")
public class Scale {
    @ApiModelProperty("每个类型的首字母")
    private String type;
    @ApiModelProperty("性别")
    private String gender;
    @ApiModelProperty("男女数量")
    private Integer count;
}
