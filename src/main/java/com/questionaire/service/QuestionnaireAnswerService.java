package com.questionaire.service;

import com.questionaire.pojo.dto.questionnaire.QuestionnaireAnswerDTO;
import com.questionaire.pojo.dto.questionnaire.SubmitQuestionnaireDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionnaireAnswerService {

    Integer insertQuestionAnswer(SubmitQuestionnaireDTO submitQuestionnaireDTO);

    List<QuestionnaireAnswerDTO> listSamples(@Param("questionnaireUid") String questionnaireUid);

    QuestionnaireAnswerDTO getSamples(@Param("sampleUid") String sampleUid);

}
