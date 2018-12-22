package com.questionaire.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.questionaire.common.constant.enumeration.TrueFalseEnum;

import java.util.List;

public class QuestionDTO extends BaseDTO{

    @JSONField(name = "question_uid")
    private String questionUid;
    @JSONField(name = "questionnaire_uid")
    private String questionnaireUid;
    @JSONField(name = "question_desc")
    private String questionDesc;
    @JSONField(name = "question_type")
    private String questionType;
    @JSONField(name = "total_score")
    private String totalScore;
    @JSONField(name = "is_random")
    private TrueFalseEnum isRandom;
    @JSONField(name = "is_required")
    private TrueFalseEnum isRequired;
    @JSONField(name = "is_scoring_type")
    private TrueFalseEnum isScoringType;
    @JSONField(name = "options")
    private List<QuestionOptionDTO> options;

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

    public List<QuestionOptionDTO> getOptions() {
        return options;
    }

    public void setOptions(List<QuestionOptionDTO> options) {
        this.options = options;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuestionDTO{");
        sb.append("questionUid='").append(questionUid).append('\'');
        sb.append(", questionnaireUid='").append(questionnaireUid).append('\'');
        sb.append(", questionDesc='").append(questionDesc).append('\'');
        sb.append(", questionType='").append(questionType).append('\'');
        sb.append(", totalScore='").append(totalScore).append('\'');
        sb.append(", isRandom=").append(isRandom);
        sb.append(", isRequired=").append(isRequired);
        sb.append(", isScoringType=").append(isScoringType);
        sb.append(", options=").append(options);
        sb.append('}');
        return sb.toString();
    }
}
