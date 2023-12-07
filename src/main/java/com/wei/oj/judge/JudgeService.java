package com.wei.oj.judge;

import com.wei.oj.model.vo.QuestionSubmitVO;

/**
 * 定义单独的 judgeService 类，
 * 而不是把所有判题相关的代码写到 questionSubmitService 里，有利于后续的模块抽离、微服务改造。
 */
public interface JudgeService {
    QuestionSubmitVO doJudge(long questionSubmitId);
}
