package com.questionaire.pojo.po.question;

import com.questionaire.pojo.po.BasePO;

import java.util.List;

public class QuestionPO extends BasePO {

    private String questionUid;

    private String questionnaireUid;

    private String questionDesc;

    private String questionType;

    private int totalScore;

    private int isLogical;

    private int isRandom;

    private int isRequired;

    private List<QuestionOptionPO> options;

    public String getQuestionUid() {
        return questionUid;
    }

    public void setQuestionUid(String questionUid) {
        this.questionUid = questionUid;
    }

    public String getQuestionnaireUid() {
        return questionnaireUid;
    }

    public void setQuestionnaireUid(String questionnaireUid) {
        this.questionnaireUid = questionnaireUid;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public int getIsRandom() {
        return isRandom;
    }

    public void setIsRandom(int isRandom) {
        this.isRandom = isRandom;
    }

    public int getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(int isRequired) {
        this.isRequired = isRequired;
    }

    public List<QuestionOptionPO> getOptions() {
        return options;
    }

    public void setOptions(List<QuestionOptionPO> options) {
        this.options = options;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getIsLogical() {
        return isLogical;
    }

    public void setIsLogical(int isLogical) {
        this.isLogical = isLogical;
    }

    @Override
    public String toString() {
        return "QuestionPO{" +
                "questionUid='" + questionUid + '\'' +
                ", questionnaireUid='" + questionnaireUid + '\'' +
                ", questionDesc='" + questionDesc + '\'' +
                ", questionType='" + questionType + '\'' +
                ", totalScore=" + totalScore +
                ", isLogical=" + isLogical +
                ", isRandom=" + isRandom +
                ", isRequired=" + isRequired +
                ", options=" + options +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", archive=" + archive +
                '}';
    }
}
