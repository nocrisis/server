package com.questionaire.mapper;

import com.questionaire.pojo.dto.question.QuestionDTO;
import com.questionaire.pojo.dto.question.QuestionOptionDTO;
import com.questionaire.pojo.po.questionnaire.QuestionIndexRelationPO;
import com.questionaire.pojo.po.question.QuestionPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {
    List<QuestionPO> listQuestionsByQuestionUids(@Param("questionUids") List<String> answeredQuestionUids);
    List<QuestionPO> listQuestionsByQuestionnaireUid(@Param("questionnaireUid") String questionnaireUid);
    Integer deleteQuestionByQuestionnaireUid(@Param("questionnaireUid") String questionnaireUid);
    Integer deleteQuestionByQuestionUid(@Param("questionUid") String questionUid);
    Integer batchDeleteByQuestionUids(List<String> questionUids);

    String insertOrUpdateQuestion(QuestionDTO question);
    Integer insertQuestionOption(List<QuestionOptionDTO> options);
    Integer deleteQuestionOption(@Param("questionUid") String questionUid);
    Integer batchDeleteOptionByQuestionUids(List<String> questionUids);

    Integer updateQuestionIndex(QuestionDTO question);
    Integer batchInsertQuestionIndex(List<QuestionIndexRelationPO> rel);
    Integer deleteQuestionIndexByQuestionnaireUid(@Param("questionnaireUid") String questionnaireUid);
    Integer batchDeleteQuestionIndexByQuestionUids(List<String>  questionUid);


}
