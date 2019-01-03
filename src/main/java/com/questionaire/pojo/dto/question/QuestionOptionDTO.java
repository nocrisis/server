package com.questionaire.pojo.dto.question;

import com.alibaba.fastjson.annotation.JSONField;
import com.questionaire.pojo.dto.BaseDTO;

public class QuestionOptionDTO extends BaseDTO {

    @JSONField(name = "option_uid")
    private String optionUid;
    @JSONField(name = "question_uid")
    private String questionUid;
    @JSONField(name = "option_desc")
    private String optionDesc;
    @JSONField(name = "option_label")
    private String optionLabel;
    @JSONField(name = "link_to")
    private String linkTo;

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuestionOptionPO{");
        sb.append("optionUid='").append(optionUid).append('\'');
        sb.append(", questionUid='").append(questionUid).append('\'');
        sb.append(", optionDesc='").append(optionDesc).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
