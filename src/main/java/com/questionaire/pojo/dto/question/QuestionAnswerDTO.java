package com.questionaire.pojo.dto.question;

import com.questionaire.pojo.po.BasePO;

public class QuestionAnswerDTO extends BasePO {

    private String answerUid;

    private String sampleUid;

    private String questionUid;

    private String questionType;

    private String answerContent;

    public String getSampleUid() { return sampleUid; }

    public void setSampleUid(String sampleUid) { this.sampleUid = sampleUid; }

    public String getAnswerUid() { return answerUid; }

    public void setAnswerUid(String answerUid) { this.answerUid = answerUid; }

    public String getResultUid() {
        return answerUid;
    }

    public void setResultUid(String answerUid) {
        this.answerUid = answerUid;
    }

    public String getQuestionUid() {
        return questionUid;
    }

    public void setQuestionUid(String questionUid) {
        this.questionUid = questionUid;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    @Override
    public String toString() {
        return "QuestionAnswerDTO{" +
                "answerUid='" + answerUid + '\'' +
                ", sampleUid='" + sampleUid + '\'' +
                ", questionUid='" + questionUid + '\'' +
                ", questionType='" + questionType + '\'' +
                ", answerContent='" + answerContent + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", archive=" + archive +
                '}';
    }
}
