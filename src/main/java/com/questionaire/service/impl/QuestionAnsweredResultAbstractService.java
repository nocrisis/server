package com.questionaire.service.impl;

import com.questionaire.pojo.po.QuestionOptionPO;
import com.questionaire.pojo.po.QuestionnaireResultDetailPO;
import com.questionaire.service.QuestionAnsweredResultService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class QuestionAnsweredResultAbstractService implements QuestionAnsweredResultService {

    protected Map<String, List<QuestionOptionPO>> getOptionUidToOptionMap(List<QuestionOptionPO> options){
        return options.stream().collect(Collectors.groupingBy(QuestionOptionPO::getOptionUid));
    }

    protected QuestionnaireResultDetailPO getResult(String questionUid, String questionType, int score, String answer){
        QuestionnaireResultDetailPO result = new QuestionnaireResultDetailPO();
        result.setQuestionUid(questionUid);
        result.setQuestionType(questionType);
        result.setScore(score);
        result.setUserAnswer(answer);
        return result;
    }
}
