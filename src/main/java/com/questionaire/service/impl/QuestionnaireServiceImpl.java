package com.questionaire.service.impl;

import com.questionaire.mapper.QuestionnaireMapper;
import com.questionaire.pojo.po.QuestionnairePO;
import com.questionaire.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Override
    public QuestionnairePO getQuestionnaireInfoByUid(String questionnaireUid) {
        return questionnaireMapper.getQuestionnaireInfoByUid(questionnaireUid);
    }
}
