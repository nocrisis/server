package com.questionaire.mapper;

import com.questionaire.pojo.dto.QuestionnaireResultDTO;
import com.questionaire.pojo.po.QuestionnaireResultPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QuestionnaireResultMapper {
    int insert(QuestionnaireResultPO questionnaireResult);

    QuestionnaireResultDTO getQuestionnaireResultByOpenIdAndQuestionnaireUid(
            @Param("openId") String openId,
            @Param("appId") String appId,
            @Param("questionnaireUid") String questionnaireUid);

    QuestionnaireResultDTO getQuestionnaireResultByUid(@Param("resultUid") String resultUid);
}
