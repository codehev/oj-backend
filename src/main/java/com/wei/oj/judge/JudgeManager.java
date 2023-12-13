package com.wei.oj.judge;

import com.wei.oj.judge.strategy.DefaultJudgeStrategy;
import com.wei.oj.judge.strategy.JavaLanguageJudgeStrategy;
import com.wei.oj.judge.strategy.JudgeContext;
import com.wei.oj.judge.strategy.JudgeStrategy;
import com.wei.oj.model.dto.questionSubmit.JudgeInfo;
import com.wei.oj.model.entity.QuestionSubmit;
import com.wei.oj.model.enums.QuestionSubmitLanguageEnum;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 * 定义 JudgeManager，目的是尽量简化对判题功能的调用，
 * 让调用方写最少的代码、调用最简单。对于判题策略的选取，也是在 JudgeManager 里处理的。
 *
 * 在策略之上再封装一层，选择策略并执行策略，返回JudgeInfo
 */
@Service
public class JudgeManager {
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        //注意是接口类型JudgeStrategy不是DefaultJudgeStrategy
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
/*        if (QuestionSubmitLanguageEnum.JAVA.equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }*/
        //执行判题,返回JudgeInfo
        return judgeStrategy.doJudge(judgeContext);
    }
}
