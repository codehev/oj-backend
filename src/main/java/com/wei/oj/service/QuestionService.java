package com.wei.oj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wei.oj.model.dto.question.QuestionQueryRequest;
import com.wei.oj.model.entity.Question;
import com.wei.oj.model.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.oj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author whw12
 * @description 针对表【question(题目)】的数据库操作Service
 * @createDate 2023-11-04 21:38:03
 */
public interface QuestionService extends IService<Question> {
    /**
     * 校验
     *
     * @param question
     * @param add
     */
    void validQuestion(Question question, boolean add);

    /**
     * 获取查询条件
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);

    /**
     * 获取题目封装
     *
     * @param question
     * @return
     */
    QuestionVO getQuestionVO(Question question);

    /**
     * 分页获取题目封装
     *
     * @param questionPage
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request);
}
