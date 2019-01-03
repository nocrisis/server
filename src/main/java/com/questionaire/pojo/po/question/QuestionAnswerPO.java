package com.questionaire.pojo.po.question;

import com.questionaire.pojo.po.BasePO;

public class QuestionAnswerPO extends BasePO {

    private String detailUid;

    private String answerUid;

    private String questionUid;

    private String questionType;

    private String answerContent;

    public String getDetailUid() {
        return detailUid;
    }

    public void setDetailUid(String detailUid) {
        this.detailUid = detailUid;
    }

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
        return "QuestionAnswerPO{" +
                "detailUid='" + detailUid + '\'' +
                ", answerUid='" + answerUid + '\'' +
                ", questionUid='" + questionUid + '\'' +
                ", questionType='" + questionType + '\'' +
                ", answerContent='" + answerContent + '\'' +
                '}';
    }
}
