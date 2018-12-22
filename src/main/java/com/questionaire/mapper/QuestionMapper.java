package com.questionaire.mapper;

import com.questionaire.pojo.po.QuestionPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {

    List<QuestionPO> listQuestionsByQuestionnaireUid(@Param("questionnaireUid") String questionnaireUid, @Param("questionNumber") int questionNumber);
    List<QuestionPO> listQuestionsNotRandomByQuestionnaireUid(@Param("questionnaireUid") String questionnaireUid);

    List<QuestionPO> listQuestionsByQuestionUids(@Param("questionUids") List<String> answeredQuestionUids);
}
