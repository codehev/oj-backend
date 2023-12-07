package com.wei.oj.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 判题信息消息枚举
 */
public enum JudgeInfoMessageEnum {
    ACCEPTED("judge_success", "评测成功"),
    WRONG_ANSWER("judge_wrong_answer", "答案错误"),
    COMPILE_ERROR("judge_compile_error", "编译错误"),
    MEMORY_LIMIT_EXCEEDED("judge_memory_limit_exceeded", "评测内存超限"),
    TIME_LIMIT_EXCEEDED("judge_time_limit_exceeded", "评测超时"),
    PRESENTATION_ERROR("judge_presentation_error", "展示错误"),
    OUTPUT_LIMIT_EXCEEDED("judge_output_limit_exceeded", "评测输出超限"),
    WAITING("judge_waiting", "等待中"),
    DANGEROUS_OPERATION("judge_dangerous_operation", "危险操作"),
    RUNTIME_ERROR("judge_runtime_error", "运行错误"),
    SYSTEM_ERROR("judge_system_error", "系统错误");


    private final String text;

    private final String value;

    JudgeInfoMessageEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }
    /**
     * 一下是定义枚举类的方法，默认是没有的，得自己写
     * 例如：JudgeInfoMessageEnum.ACCEPTED.getText()
     */

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static JudgeInfoMessageEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (JudgeInfoMessageEnum anEnum : JudgeInfoMessageEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
