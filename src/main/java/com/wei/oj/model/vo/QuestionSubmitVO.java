package com.wei.oj.model.vo;

import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.wei.oj.model.dto.questionSubmit.JudgeInfo;
import com.wei.oj.model.entity.QuestionSubmit;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目提交记录的封装类
 * 定义VO类:作用是专门给前端返回对象，可以节约网络传输大小、或者过滤字段(脱敏)、保证安全性。
 */
@Data
public class QuestionSubmitVO implements Serializable {
    private final static Gson GSON = new Gson();

    /**
     * id
     */
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
    private JudgeInfo judgeInfo;

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

    private UserVO userVO;

    private QuestionVO questionVO;

    private static final long serialVersionUID = 1L;

    /**
     * 包装类转对象
     * 注意是静态方法，不需要new，直接QuestionSubmitVO.voToObj(questionSubmitVO)
     *
     * @param questionSubmitVO
     * @return
     */
    public static QuestionSubmit voToObj(QuestionSubmitVO questionSubmitVO) {
        if (questionSubmitVO == null) {
            return null;
        }
        QuestionSubmit questionSubmit = new QuestionSubmit();
        //拷贝同名属性questionSubmitVO=》questionSubmit
        BeanUtils.copyProperties(questionSubmitVO, questionSubmit);
        //tags在实体类中是String类型，而vo类中是List<String> tags，所以要特殊处理下
        JudgeInfo judgeInfo = questionSubmitVO.getJudgeInfo();
        if (judgeInfo != null) {
            //hutool，转json字符串
            questionSubmit.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        }
        return questionSubmit;
    }

    /**
     * 对象转包装类
     * 注意是静态方法，不需要new，直接QuestionSubmitVO.objToVo(questionSubmit)
     *
     * @param questionSubmit
     * @return
     */
    public static QuestionSubmitVO objToVo(QuestionSubmit questionSubmit) {
        if (questionSubmit == null) {
            return null;
        }
        QuestionSubmitVO questionSubmitVO = new QuestionSubmitVO();
        //拷贝同名属性questionSubmit=》questionSubmitVO
        BeanUtils.copyProperties(questionSubmit, questionSubmitVO);
        questionSubmitVO.setJudgeInfo(JSONUtil.toBean(questionSubmit.getJudgeInfo(), JudgeInfo.class));
        return questionSubmitVO;
    }
}