package com.wei.oj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.oj.model.entity.Question;
import com.wei.oj.service.QuestionService;
import com.wei.oj.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

/**
* @author whw12
* @description 针对表【question(题目)】的数据库操作Service实现
* @createDate 2023-11-04 21:38:03
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService{

}




