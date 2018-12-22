package com.questionaire.pojo.po;

import com.questionaire.common.constant.enumeration.TrueFalseEnum;

import java.util.List;

public class QuestionPO extends BasePO{

    private String questionUid;

    private String questionnaireUid;

    private String questionDesc;

    private String questionType;

    private int totalScore;

    private TrueFalseEnum isRandom;

    private TrueFalseEnum isRequired;

    private TrueFalseEnum isScoringType;

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

    public TrueFalseEnum getIsRandom() {
        return isRandom;
    }

    public void setIsRandom(TrueFalseEnum isRandom) {
        this.isRandom = isRandom;
    }

    public TrueFalseEnum getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(TrueFalseEnum isRequired) {
        this.isRequired = isRequired;
    }

    public TrueFalseEnum getIsScoringType() {
        return isScoringType;
    }

    public void setIsScoringType(TrueFalseEnum isScoringType) {
        this.isScoringType = isScoringType;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuestionPO{");
        sb.append("questionUid='").append(questionUid).append('\'');
        sb.append(", questionnaireUid='").append(questionnaireUid).append('\'');
        sb.append(", questionDesc='").append(questionDesc).append('\'');
        sb.append(", questionType='").append(questionType).append('\'');
        sb.append(", totalScore=").append(totalScore);
        sb.append(", isRandom=").append(isRandom);
        sb.append(", isRequired=").append(isRequired);
        sb.append(", isScoringType=").append(isScoringType);
        sb.append(", options=").append(options);
        sb.append('}');
        return sb.toString();
    }
}
