package com.questionaire.pojo.dto.questionnaire;

import com.alibaba.fastjson.annotation.JSONField;
import com.questionaire.pojo.dto.question.QuestionDTO;
import com.questionaire.pojo.po.questionnaire.QuestionIndexRelationPO;

import java.util.List;

public class UpdateQuestionnaireDTO {
    @JSONField(name = "new_questions")
    private List<QuestionDTO> newQuestions;
    @JSONField(name = "update_questions")
    private List<QuestionDTO> updateQuestions;
    @JSONField(name = "delete_question_uids")
    private List<String> deleteQuestionUids;
    @JSONField(name = "edit_questionnaire_info")
    private EditQuestionnaireInfo editQuestionnaireInfo;

    @JSONField(name = "update_index_rel")
    private  List<QuestionIndexRelationPO> questionIndexRelationPOS ;

    public List<QuestionIndexRelationPO> getQuestionIndexRelationPOS() { return questionIndexRelationPOS; }

    public void setQuestionIndexRelationPOS(List<QuestionIndexRelationPO> questionIndexRelationPOS) { this.questionIndexRelationPOS = questionIndexRelationPOS; }

    public List<QuestionDTO> getNewQuestions() { return newQuestions; }

    public void setNewQuestions(List<QuestionDTO> newQuestions) { this.newQuestions = newQuestions; }

    public List<QuestionDTO> getUpdateQuestions() { return updateQuestions; }

    public void setUpdateQuestions(List<QuestionDTO> updateQuestions) { this.updateQuestions = updateQuestions; }

    public List<String> getDeleteQuestionUids() { return deleteQuestionUids; }

    public void setDeleteQuestionUids(List<String> deleteQuestionUids) { this.deleteQuestionUids = deleteQuestionUids; }

    public EditQuestionnaireInfo getEditQuestionnaireInfo() { return editQuestionnaireInfo; }

    public void setEditQuestionnaireInfo(EditQuestionnaireInfo editQuestionnaireInfo) { this.editQuestionnaireInfo = editQuestionnaireInfo; }

    @Override
    public String toString() {
        return "UpdateQuestionnaireDTO{" +
                "newQuestions=" + newQuestions +
                ", updateQuestions=" + updateQuestions +
                ", deleteQuestionUids=" + deleteQuestionUids +
                ", editQuestionnaireInfo=" + editQuestionnaireInfo +
                ", questionIndexRelationPOS=" + questionIndexRelationPOS +
                '}';
    }
}
