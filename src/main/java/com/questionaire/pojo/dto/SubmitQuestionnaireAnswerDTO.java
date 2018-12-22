package com.questionaire.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class SubmitQuestionnaireAnswerDTO {

    @NotNull(message = "答题详情缺少题目uid")
    @Size(min = 1, message = "答题详情缺少题目uid")
    @JSONField(name = "question_uid")
    private String questionUid;

    @JSONField(name = "result")
    private String result;

    @JSONField(name = "options")
    private List<String> options;

    public String getQuestionUid() {
        return questionUid;
    }

    public void setQuestionUid(String questionUid) {
        this.questionUid = questionUid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SubmitQuestionnaireAnswerDTO{");
        sb.append("questionUid='").append(questionUid).append('\'');
        sb.append(", result='").append(result).append('\'');
        sb.append(", options=").append(options);
        sb.append('}');
        return sb.toString();
    }
}
