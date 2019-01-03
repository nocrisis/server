package com.questionaire.mapper;

import com.questionaire.pojo.dto.question.QuestionAnswerDTO;
import com.questionaire.pojo.dto.question.SubmitAnswerDTO;
import com.questionaire.pojo.po.question.QuestionAnswerPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionAnswerMapper {
    Integer batchInsert(List<SubmitAnswerDTO> answers);
    List<QuestionAnswerDTO> getQuestionAnswerByQuestionnaireUid(@Param("questionnaireUid") String questionnaireUid);
    List<QuestionAnswerDTO> getQuestionAnswerByQuestionUid(@Param("questionUid") String questionUid);
}
