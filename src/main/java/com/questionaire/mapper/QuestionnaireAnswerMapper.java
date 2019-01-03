package com.questionaire.mapper;

import com.questionaire.pojo.dto.questionnaire.QuestionnaireAnswerDTO;
import com.questionaire.pojo.po.questionnaire.QuestionnaireAnswerPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QuestionnaireAnswerMapper {
    Integer insertQuestionnaireAnswer(QuestionnaireAnswerPO questionnaireAnswerPO);
    QuestionnaireAnswerDTO getQuestionnaireResultBysampleUid(@Param("sampleUid") String sampleUid);
}
