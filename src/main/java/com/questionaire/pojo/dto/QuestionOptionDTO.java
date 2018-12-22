package com.questionaire.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class QuestionOptionDTO extends BaseDTO{

    @JSONField(name = "option_uid")
    private String optionUid;
    @JSONField(name = "question_uid")
    private String questionUid;
    @JSONField(name = "option_desc")
    private String optionDesc;
    @JSONField(name = "score")
    private int score;

    public String getOptionUid() {
        return optionUid;
    }

    public void setOptionUid(String optionUid) {
        this.optionUid = optionUid;
    }

    public String getOptionDesc() {
        return optionDesc;
    }

    public void setOptionDesc(String optionDesc) {
        this.optionDesc = optionDesc;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getQuestionUid() {
        return questionUid;
    }

    public void setQuestionUid(String questionUid) {
        this.questionUid = questionUid;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuestionOptionPO{");
        sb.append("optionUid='").append(optionUid).append('\'');
        sb.append(", questionUid='").append(questionUid).append('\'');
        sb.append(", optionDesc='").append(optionDesc).append('\'');
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
