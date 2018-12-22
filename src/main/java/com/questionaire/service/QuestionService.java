package com.questionaire.service;

import com.questionaire.pojo.dto.QuestionDTO;
import com.questionaire.pojo.po.QuestionPO;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    List<QuestionDTO> listQuestionsNotRandomByQuestionnaireUid(String questionnaireUid);

    List<QuestionDTO> listQuestionsByQuestionnaireUid(String questionnaireUid, int questionNumber);

    List<QuestionPO> listQuestionsByQuestionUids(List<String> answeredQuestionUids);

    Map<String, List<QuestionPO>> getQuestionUidToQuestionMap(List<String> answeredQuestionUids);

}
