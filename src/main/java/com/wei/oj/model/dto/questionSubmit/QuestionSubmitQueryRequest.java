package com.wei.oj.model.dto.questionSubmit;

import com.wei.oj.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询请求
 */
//@EqualsAndHashCode是 Lombok 库中的一个注解，用于自动生成 equals 和 hashCode 方法
//callSuper = true 的具体含义是：在生成的 equals 和 hashCode 方法中，将会调用超类（父类）的 equals 和 hashCode 方法。
// 这通常在子类继承了某个基类，并且这个基类的相等性（equality）和哈希值（hashcode）对子类的相等性和哈希值有影响的情况下使用。
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    /**
     * 编程语言
     */
    private String language;

    /**
     * 提交状态
     */
    private Integer status;

    /**
     * 题目 id
     */
    private Long questionId;
    /**
     * 用户 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}