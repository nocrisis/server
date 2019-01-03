package com.questionaire.service;

import com.questionaire.pojo.dto.question.QuestionDTO;
import com.questionaire.pojo.po.questionnaire.QuestionIndexRelationPO;
import com.questionaire.pojo.po.question.QuestionPO;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    List<QuestionDTO> listQuestionsByQuestionnaireUid(String questionnaireUid);

    List<QuestionDTO> listQuestionsByQuestionnaireUid(String questionnaireUid, int index);

    List<QuestionPO> listQuestionsByQuestionUids(List<String> answeredQuestionUids);

    Map<String, List<QuestionPO>> getQuestionUidToQuestionMap(List<String> answeredQuestionUids);

    Integer batchDeleteQuestionIndexByQuestionUids(List<QuestionIndexRelationPO> rel);
    Integer batchInsertQuestionIndex(List<QuestionIndexRelationPO> rel);

    void batchInsertQuestionWithOptionAndIndex(List<QuestionDTO> questionDTOList,List<QuestionIndexRelationPO> questionIndexs);

    void batchInsertQuestionWithOption(List<QuestionDTO> questionDTOList);

    Integer batchDeleteQuestionWithOption(List<String> questionUids);

}
