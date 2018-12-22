package com.questionaire.service.impl;

import com.questionaire.common.constant.enumeration.TrueFalseEnum;
import com.questionaire.pojo.dto.SubmitQuestionnaireAnswerDTO;
import com.questionaire.pojo.po.QuestionPO;
import com.questionaire.pojo.po.QuestionnaireResultDetailPO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service("TYP_SHORT_ANSWER_SERVICE")
public class ShortAnswerQuestionAnsweredResultServiceImpl extends QuestionAnsweredResultAbstractService {
    @Override
    public QuestionnaireResultDetailPO getResultDetail(SubmitQuestionnaireAnswerDTO answer, QuestionPO question) {
        if(TrueFalseEnum.FALSE.equals(question.getIsRequired()) && StringUtils.isBlank(answer.getResult())){
            return getResult(answer.getQuestionUid(), question.getQuestionType(), 0, null);
        }
        return getResult(answer.getQuestionUid(), question.getQuestionType(), question.getTotalScore(), answer.getResult());
    }
}
