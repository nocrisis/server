package com.questionaire.service.impl;

import com.questionaire.pojo.dto.SubmitQuestionnaireAnswerDTO;
import com.questionaire.pojo.po.QuestionPO;
import com.questionaire.pojo.po.QuestionnaireResultDetailPO;
import org.springframework.stereotype.Service;

@Service("DEFAULT_SERVICE")
public class DefaultQuestionAnsweredResultServiceImpl extends QuestionAnsweredResultAbstractService {
    @Override
    public QuestionnaireResultDetailPO getResultDetail(SubmitQuestionnaireAnswerDTO answer, QuestionPO question) {
        return null;
    }
}
