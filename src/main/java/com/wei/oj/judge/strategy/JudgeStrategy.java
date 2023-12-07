package com.wei.oj.judge.strategy;

import com.wei.oj.model.dto.questionSubmit.JudgeInfo;

/**
 * 策略模式接口，判题策略
 * 可能不同的编程语言，判题策略不同,定义不同的实现类
 */
public interface JudgeStrategy {
    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
