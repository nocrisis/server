package com.questionaire.pojo.dto.questionnaire;

import com.alibaba.fastjson.annotation.JSONField;
import com.questionaire.pojo.dto.question.SubmitAnswerDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class SubmitQuestionnaireDTO {
    @NotNull(message = "用户填写的问卷uid不能为空")
    @Size(min = 1, message = "用户填写的问卷uid不能为空")
    @JSONField(name = "questionnaire_uid")
    private String questionnaireUid;

    @JSONField(name = "start_at")
    private Date startAt;

    @JSONField(name = "end_at")
    private Date endAt;

    @NotNull(message = "用户回答的问题不能为空")
    @Size(min = 1, message = "用户回答的问题不能为空")
    @JSONField(name = "answer")
    private List<SubmitAnswerDTO> answer;

    public String getQuestionnaireUid() {
        return questionnaireUid;
    }

    public void setQuestionnaireUid(String questionnaireUid) {
        this.questionnaireUid = questionnaireUid;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndedAt() { return endAt; }

    public void setEndedAt(Date endedAt) { this.endAt = endedAt; }

    public List<SubmitAnswerDTO> getAnswer() {
        return answer;
    }

    public void setAnswer(List<SubmitAnswerDTO> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "SubmitQuestionnaireDTO{" +
                "questionnaireUid='" + questionnaireUid + '\'' +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", answer=" + answer +
                '}';
    }
}
