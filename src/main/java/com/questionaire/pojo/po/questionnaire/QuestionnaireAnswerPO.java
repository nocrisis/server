package com.questionaire.pojo.po.questionnaire;

import com.questionaire.common.constant.enumeration.QuestionnairePlatformEnum;
import com.questionaire.pojo.po.BasePO;
import com.questionaire.pojo.po.question.QuestionAnswerPO;

import java.util.Date;
import java.util.List;

public class QuestionnaireAnswerPO extends BasePO {
    private String answerUid;

    private String questionnaireUid;

    private Date startAt;

    private Date endAt;

    private int useTime;

    private QuestionnairePlatformEnum platform;

    private List<QuestionAnswerPO> detail;

    public String getAnswerUid() { return answerUid; }

    public void setAnswerUid(String answerUid) { this.answerUid = answerUid; }

    public int getUseTime() { return useTime; }

    public void setUseTime(int useTime) { this.useTime = useTime; }

    public String getResultUid() {
        return answerUid;
    }

    public void setResultUid(String answerUid) {
        this.answerUid = answerUid;
    }

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

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public QuestionnairePlatformEnum getPlatform() {
        return platform;
    }

    public void setPlatform(QuestionnairePlatformEnum platform) {
        this.platform = platform;
    }

    public List<QuestionAnswerPO> getDetail() {
        return detail;
    }

    public void setDetail(List<QuestionAnswerPO> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "QuestionnaireAnswerPO{" +
                "answerUid='" + answerUid + '\'' +
                ", questionnaireUid='" + questionnaireUid + '\'' +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", platform=" + platform +
                ", detail=" + detail +
                '}';
    }
}
