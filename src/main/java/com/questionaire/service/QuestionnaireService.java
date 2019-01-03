package com.questionaire.service;

import com.questionaire.pojo.dto.questionnaire.CreateQuestionnaireDTO;
import com.questionaire.pojo.dto.questionnaire.EditQuestionnaireInfo;
import com.questionaire.pojo.dto.questionnaire.QueryQuestionnaireDTO;
import com.questionaire.pojo.dto.questionnaire.UpdateQuestionnaireDTO;
import com.questionaire.pojo.po.questionnaire.QuestionnairePO;

import java.util.List;

public interface QuestionnaireService {
    Integer createQuestionnaireInfo(CreateQuestionnaireDTO createQuestionnaireDTO);

    Integer updateQuestionnaireInfo(EditQuestionnaireInfo editQuestionnaireInfo);

    Integer updateIssueStatus(Integer isIssue, String questionnaireUid);

    Integer deleteQuestionnaireInfo(String questionnaireUid);

    QuestionnairePO getQuestionnaireInfoByUid(String questionnaireUid);

    List<QuestionnairePO> listQuestionnaireInfo(QueryQuestionnaireDTO queryQuestionnaireDTO);

    Integer countQuestionnaireInfo(QueryQuestionnaireDTO queryQuestionnaireDTO);
}
