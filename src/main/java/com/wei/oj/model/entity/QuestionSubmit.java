package com.wei.oj.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 题目提交
 *
 * @TableName question_submit
 */
@TableName(value = "question_submit")
@Data
public class QuestionSubmit implements Serializable {
    /**
     * id
     * IdType.ASSIGN_ID，非连续自增
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;

    /**
     * 判题信息（json 对象）
     */
    private String judgeInfo;

    /**
     * 判题状态（0 - 待判题、1 - 判题中、2 - 成功、3 - 失败）
     */
    private Integer status;

    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     *
     * @TableLogic是MyBatis Plus中的一个注解，主要用于标识实体类中的字段作为逻辑删除标记。
     * 通过这个注解，开发者可以更简单地实现逻辑删除功能，而无需手动维护删除状态。
     * 这是通过在实体类字段上添加@TableLogic注解来实现的。
     * 当调用删除方法时，实际上会更新这些字段的值，而不是从数据库中物理删除记录。
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}