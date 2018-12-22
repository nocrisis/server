package com.questionaire.pojo.po;

import com.questionaire.common.constant.enumeration.QuestionnairePlatformEnum;

import java.util.Date;

public class QuestionnairePO extends BasePO{

    private String questionnaireUid;

    private String questionnaireName;

    private Date started_at;

    private Date ended_at;

    private QuestionnairePlatformEnum platform;

    private int questionNumber;

    private String note;

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

    public Date getStarted_at() {
        return started_at;
    }

    public void setStarted_at(Date started_at) {
        this.started_at = started_at;
    }

    public Date getEnded_at() {
        return ended_at;
    }

    public void setEnded_at(Date ended_at) {
        this.ended_at = ended_at;
    }

    public QuestionnairePlatformEnum getPlatform() {
        return platform;
    }

    public void setPlatform(QuestionnairePlatformEnum platform) {
        this.platform = platform;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuestionnairePO{");
        sb.append("questionnaireUid='").append(questionnaireUid).append('\'');
        sb.append(", questionnaireName='").append(questionnaireName).append('\'');
        sb.append(", started_at=").append(started_at);
        sb.append(", ended_at=").append(ended_at);
        sb.append(", platform=").append(platform);
        sb.append(", questionNumber='").append(questionNumber).append('\'');
        sb.append(", note='").append(note).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
