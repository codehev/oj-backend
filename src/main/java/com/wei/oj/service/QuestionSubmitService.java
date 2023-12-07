package com.wei.oj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wei.oj.model.dto.question.QuestionQueryRequest;
import com.wei.oj.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.wei.oj.model.dto.questionSubmit.QuestionSubmitQueryRequest;
import com.wei.oj.model.entity.Question;
import com.wei.oj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.oj.model.entity.User;
import com.wei.oj.model.vo.QuestionSubmitVO;
import com.wei.oj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author whw12
 * @description 针对表【question_submit(题目提交)】的数据库操作Service
 * @createDate 2023-11-04 21:39:08
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

}
