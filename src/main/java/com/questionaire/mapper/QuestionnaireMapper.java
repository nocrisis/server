package com.questionaire.mapper;

import com.questionaire.pojo.po.QuestionnairePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QuestionnaireMapper {

    QuestionnairePO getQuestionnaireInfoByUid(@Param("questionnaireUid") String questionnaireUid);
}
