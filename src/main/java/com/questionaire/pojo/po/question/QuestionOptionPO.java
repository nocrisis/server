package com.questionaire.pojo.po.question;

import com.questionaire.pojo.po.BasePO;

public class QuestionOptionPO extends BasePO {

    private String optionUid;

    private String questionUid;

    private String optionLabel;

    private String optionDesc;

    private String linkTo;

    public String getLinkTo() { return linkTo; }

    public void setLinkTo(String linkTo) { this.linkTo = linkTo; }

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

    public String getQuestionUid() {
        return questionUid;
    }

    public void setQuestionUid(String questionUid) {
        this.questionUid = questionUid;
    }

    public String getOptionLabel() {
        return optionLabel;
    }

    public void setOptionLabel(String optionLabel) {
        this.optionLabel = optionLabel;
    }

    @Override
    public String toString() {
        return "QuestionOptionPO{" +
                "optionUid='" + optionUid + '\'' +
                ", questionUid='" + questionUid + '\'' +
                ", optionLabel='" + optionLabel + '\'' +
                ", optionDesc='" + optionDesc + '\'' +
                ", linkTo='" + linkTo + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", archive=" + archive +
                '}';
    }
}
