package com.survey.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
public class CommentDataVo {
    private String name;
    //   private List<CommentDataVos> list;
    private Integer circleId;
    private String content;
    private String createTime;
}
//@Data
//class CommentDataVos{
//    private Integer circleId;
//    private String content;
//    private Date createTime;
//}

