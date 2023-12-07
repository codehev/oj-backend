package com.wei.oj.model.vo;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wei.oj.model.dto.question.JudgeConfig;
import com.wei.oj.model.entity.Question;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 题目封装类
 * 定义VO类:作用是专门给前端返回对象，可以节约网络传输大小、或者过滤字段(脱敏)、保证安全性。
 */
@Data
public class QuestionVO implements Serializable {
    private final static Gson GSON = new Gson();

    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 题目提交数
     */
    private Integer submitNum;

    /**
     * 题目通过数
     */
    private Integer acceptedNum;

    /**
     * 判题配置（json 对象）
     */
    private JudgeConfig judgeConfig;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;

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
     * 创建题目的人信息
     */
    private UserVO userVO;

    private static final long serialVersionUID = 1L;

    /**
     * 包装类转对象
     * 注意是静态方法，不需要new，直接QuestionVO.voToObj(questionVO)
     * @param questionVO
     * @return
     */
    public static Question voToObj(QuestionVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        Question question = new Question();
        //拷贝同名属性questionVO=》question
        BeanUtils.copyProperties(questionVO, question);
        //tags在实体类中是String类型，而vo类中是List<String> tags，所以要特殊处理下
        List<String> tagList = questionVO.getTags();
//        if (tagList != null) {
//            //GSON工具，转json字符串
//            question.setTags(GSON.toJson(tagList));
//        }
        if (tagList != null) {
            question.setTags(JSONUtil.toJsonStr(tagList));
        }
        JudgeConfig voJudgeConfig = questionVO.getJudgeConfig();
        if (voJudgeConfig != null) {
            //hutool，转json字符串
            question.setJudgeConfig(JSONUtil.toJsonStr(voJudgeConfig));
        }
        return question;
    }

    /**
     * 对象转包装类
     *  注意是静态方法，不需要new，直接QuestionVO.objToVo(question)
     * @param question
     * @return
     */
    public static QuestionVO objToVo(Question question) {
        if (question == null) {
            return null;
        }
        QuestionVO questionVO = new QuestionVO();
        //拷贝同名属性question=》questionVO
        BeanUtils.copyProperties(question, questionVO);
        questionVO.setTags(JSONUtil.toList(question.getTags(), String.class));
        questionVO.setJudgeConfig(JSONUtil.toBean(question.getJudgeConfig(), JudgeConfig.class));

//        questionVO.setTags(GSON.fromJson(question.getTags(), new TypeToken<List<String>>() {
//        }.getType()));
        return questionVO;
    }
}