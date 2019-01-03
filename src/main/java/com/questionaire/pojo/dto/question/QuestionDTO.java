package com.questionaire.pojo.dto.question;

import com.alibaba.fastjson.annotation.JSONField;
import com.questionaire.common.constant.enumeration.QuestionTypeEnum;
import com.questionaire.pojo.dto.BaseDTO;

import java.util.List;

public class QuestionDTO extends BaseDTO {
    @JSONField(name = "question_uid")
    private String questionUid;
    @JSONField(name = "questionnaire_uid")
    private String questionnaireUid;
    @JSONField(name = "question_desc")
    private String questionDesc;
    @JSONField(name = "question_type")
    private QuestionTypeEnum questionType;
    @JSONField(name = "is_logical")
    private int isLogical;
    @JSONField(name = "is_required")
    private int isRequired;
    @JSONField(name = "index")
    private int index;
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

    public QuestionTypeEnum getQuestionType() { return questionType; }

    public void setQuestionType(QuestionTypeEnum questionType) { this.questionType = questionType; }

    public int getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(int isRequired) {
        this.isRequired = isRequired;
    }

    public int getIndex() { return index; }

    public void setIndex(int index) { this.index = index; }

    public List<QuestionOptionDTO> getOptions() {
        return options;
    }

    public void setOptions(List<QuestionOptionDTO> options) {
        this.options = options;
    }

    public int getIsLogical() {
        return isLogical;
    }

    public void setIsLogical(int isLogical) {
        this.isLogical = isLogical;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "questionUid='" + questionUid + '\'' +
                ", questionnaireUid='" + questionnaireUid + '\'' +
                ", questionDesc='" + questionDesc + '\'' +
                ", questionType=" + questionType +
                ", isLogical=" + isLogical +
                ", isRequired=" + isRequired +
                ", index=" + index +
                ", options=" + options +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
