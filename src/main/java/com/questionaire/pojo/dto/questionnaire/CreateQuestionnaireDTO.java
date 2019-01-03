package com.questionaire.pojo.dto.questionnaire;

import com.alibaba.fastjson.annotation.JSONField;
import com.questionaire.pojo.dto.question.QuestionDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class CreateQuestionnaireDTO {
    @JSONField(name = "questionnaire_uid")
    private String questionnaireUid;

    @NotNull(message = "用户填写的问卷标题不能为空")
    @Size(min = 1, message = "用户填写的问卷标题不能为空")
    @JSONField(name = "questionnaire_name")
    private String questionnaireName;

    @JSONField(name = "introduction")
    private String introduction;

    @NotNull(message = "用户不能为空")
    @Size(min = 1, message = "用户不能为空")
    @JSONField(name = "user_id")
    private String userId;

    @JSONField(name = "started_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date startedAt;

    @NotNull(message = "结束时间不能为空")
    @JSONField(name = "ended_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date endedAt;

    @JSONField(name = "timekeeping")
    private int timekeeping;

    @NotNull(message = "问题不能为空")
    @Size(min = 1, message = "问题不能为空")
    @JSONField(name = "question_list")
    private List<QuestionDTO> questionList;

    public String getQuestionnaireUid() { return questionnaireUid; }

    public void setQuestionnaireUid(String questionnaireUid) { this.questionnaireUid = questionnaireUid; }

    public String getQuestionnaireName() { return questionnaireName; }

    public void setQuestionnaireName(String questionnaireName) { this.questionnaireName = questionnaireName; }

    public String getIntroduction() { return introduction; }

    public void setIntroduction(String introduction) { this.introduction = introduction; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public Date getStartedAt() { return startedAt; }

    public void setStartedAt(Date startedAt) { this.startedAt = startedAt; }

    public Date getEndedAt() { return endedAt; }

    public void setEndedAt(Date endedAt) { this.endedAt = endedAt; }

    public int getTimekeeping() { return timekeeping; }

    public void setTimekeeping(int timekeeping) { this.timekeeping = timekeeping; }

    public List<QuestionDTO> getQuestionList() { return questionList; }

    public void setQuestionList(List<QuestionDTO> questionList) { this.questionList = questionList; }

    @Override
    public String toString() {
        return "CreateQuestionnaireDTO{" +
                "questionnaireUid='" + questionnaireUid + '\'' +
                ", questionnaireName='" + questionnaireName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", userId='" + userId + '\'' +
                ", startedAt=" + startedAt +
                ", endedAt=" + endedAt +
                ", timekeeping=" + timekeeping +
                ", questionList=" + questionList +
                '}';
    }
}
