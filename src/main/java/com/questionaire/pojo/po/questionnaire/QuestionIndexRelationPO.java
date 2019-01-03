package com.questionaire.pojo.po.questionnaire;

import com.questionaire.pojo.po.BasePO;

public class QuestionIndexRelationPO extends BasePO {
    private int index;
    private String questionUid;
    private String questionnaireUid;

    public int getIndex() { return index; }

    public void setIndex(int index) { this.index = index; }

    public String getQuestionUid() { return questionUid; }

    public void setQuestionUid(String questionUid) { this.questionUid = questionUid; }

    public String getQuestionnaireUid() { return questionnaireUid; }

    public void setQuestionnaireUid(String questionnaireUid) { this.questionnaireUid = questionnaireUid; }

    @Override
    public String toString() {
        return "QuestionIndexRelationPO{" +
                "index=" + index +
                ", questionUid='" + questionUid + '\'' +
                ", questionnaireUid='" + questionnaireUid + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", archive=" + archive +
                '}';
    }
}
