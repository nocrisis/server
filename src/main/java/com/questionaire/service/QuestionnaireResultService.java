package com.questionaire.service;

import com.questionaire.pojo.dto.QuestionnaireResultDTO;
import com.questionaire.pojo.dto.SubmitQuestionnaireResultDTO;
import com.questionaire.pojo.po.QuestionnaireResultPO;

public interface QuestionnaireResultService {

    SubmitQuestionnaireResultDTO insertQuestionnaireResult(QuestionnaireResultPO questionnaireResult);

    QuestionnaireResultDTO getQuestionnaireResultByOpenIdAndQuestionnaireUid(String openId, String appId, String questionnaireUid);

    QuestionnaireResultDTO getQuestionnaireResultByUid(String resultUid);

}
