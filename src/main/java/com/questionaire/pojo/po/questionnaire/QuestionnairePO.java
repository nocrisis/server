package com.questionaire.pojo.po.questionnaire;

import com.questionaire.pojo.po.BasePO;

import java.util.Date;

public class QuestionnairePO extends BasePO {

    private String questionnaireUid;

    private String questionnaireName;

    private String introduction;

    private String questionnaireUrl;

    private String userId;

    private int isIssue;

    private Date startedAt;

    private Date endedAt;

    private int timekeeping;

    public String getQuestionnaireUid() {
        return questionnaireUid;
    }

    public void setQuestionnaireUid(String questionnaireUid) {
        this.questionnaireUid = questionnaireUid;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName;
    }

    public void setEndedAt(Date endedAt) { this.endedAt = endedAt; }

    public String getQuestionnaireUrl() { return questionnaireUrl; }

    public void setQuestionnaireUrl(String questionnaireUrl) { this.questionnaireUrl = questionnaireUrl; }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getTimekeeping() {
        return timekeeping;
    }

    public void setTimekeeping(int timekeeping) {
        this.timekeeping = timekeeping;
    }

    public int getIsIssue() {
        return isIssue;
    }

    public void setIsIssue(int isIssue) {
        this.isIssue = isIssue;
    }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public Date getStartedAt() { return startedAt; }

    public void setStartedAt(Date startedAt) { this.startedAt = startedAt; }

    @Override
    public String toString() {
        return "QuestionnairePO{" +
                "questionnaireUid='" + questionnaireUid + '\'' +
                ", questionnaireName='" + questionnaireName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", questionnaireUrl='" + questionnaireUrl + '\'' +
                ", userId='" + userId + '\'' +
                ", isIssue=" + isIssue +
                ", startedAt=" + startedAt +
                ", endedAt=" + endedAt +
                ", timekeeping=" + timekeeping +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", archive=" + archive +
                '}';
    }
}


