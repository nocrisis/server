package com.questionaire.mapper;

import com.questionaire.pojo.dto.questionnaire.EditQuestionnaireInfo;
import com.questionaire.pojo.dto.questionnaire.QueryQuestionnaireDTO;
import com.questionaire.pojo.dto.questionnaire.UpdateQuestionnaireDTO;
import com.questionaire.pojo.po.questionnaire.QuestionnairePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionnaireMapper {

    QuestionnairePO getQuestionnaireInfoByUid(@Param("questionnaireUid") String questionnaireUid);

    Integer insertQuestionnaireInfo(QuestionnairePO questionnairePO);

    Integer updateQuestionnaireInfo(EditQuestionnaireInfo editQuestionnaireInfo);

    Integer updateIssueStatus(@Param("questionnaireUid")Integer isIssue,@Param("questionnaireUid") String questionnaireUid);

    Integer countQuestionnaireInfo(QueryQuestionnaireDTO queryQuestionnaireDTO);

    Integer deleteQuestionnaireInfo(String questionnaireUid);

    List<QuestionnairePO> listQuestionnaireInfo(QueryQuestionnaireDTO queryQuestionnaireDTO);
}
