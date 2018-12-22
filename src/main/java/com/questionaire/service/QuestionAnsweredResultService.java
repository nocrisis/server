package com.questionaire.service;

import com.questionaire.pojo.dto.SubmitQuestionnaireAnswerDTO;
import com.questionaire.pojo.po.QuestionPO;
import com.questionaire.pojo.po.QuestionnaireResultDetailPO;

public interface QuestionAnsweredResultService {

    QuestionnaireResultDetailPO getResultDetail(SubmitQuestionnaireAnswerDTO answer, QuestionPO question);

}
