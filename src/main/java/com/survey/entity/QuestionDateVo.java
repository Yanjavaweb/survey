package com.survey.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * json格式：对象映射
 */
@Data
public class QuestionDateVo {
    @ApiModelProperty("次类别类名")
    private String contentIndex;
    @ApiModelProperty("选项集合")
    List<QuestionDateListVo> questionDateListVos;
}

@Data
class QuestionDateListVo {
    String type;
    List<QuestioncontentDateListVo> contentList;

}

@Data
class QuestioncontentDateListVo {
    String content;
}

