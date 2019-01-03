package com.questionaire.pojo.dto.question;

import com.alibaba.fastjson.annotation.JSONField;

import javax.naming.Name;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class  SubmitAnswerDTO {

    @NotNull(message = "答题详情缺少题目uid")
    @Size(min = 1, message = "答题详情缺少题目uid")
    @JSONField(name = "question_uid")
    private String questionUid;

    @JSONField(name = "answerContent")
    private List<String> answerContent;

    @NotNull
    public String getQuestionUid() { return questionUid; }

    public void setQuestionUid(@NotNull String questionUid) { this.questionUid = questionUid; }

    public List<String> getAnswerContent() { return answerContent; }

    public void setAnswerContent(List<String> answerContent) { this.answerContent = answerContent; }

    @Override
    public String toString() {
        return "SubmitAnswerDTO{" +
                "questionUid='" + questionUid + '\'' +
                ", answerContent=" + answerContent +
                '}';
    }
}
