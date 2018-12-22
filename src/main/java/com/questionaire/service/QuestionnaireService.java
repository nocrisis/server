package com.questionaire.service;

import com.questionaire.pojo.po.QuestionnairePO;

public interface QuestionnaireService {

    QuestionnairePO getQuestionnaireInfoByUid(String questionnaireUid);
}
