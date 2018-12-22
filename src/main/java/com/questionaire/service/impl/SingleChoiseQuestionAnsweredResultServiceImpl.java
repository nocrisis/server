package com.questionaire.service.impl;

import com.questionaire.common.constant.enumeration.BaseCode;
import com.questionaire.common.constant.enumeration.TrueFalseEnum;
import com.questionaire.common.exception.BaseException;
import com.questionaire.pojo.dto.SubmitQuestionnaireAnswerDTO;
import com.questionaire.pojo.po.QuestionOptionPO;
import com.questionaire.pojo.po.QuestionPO;
import com.questionaire.pojo.po.QuestionnaireResultDetailPO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service("TYP_SINGLE_CHOISE_SERVICE")
public class SingleChoiseQuestionAnsweredResultServiceImpl extends QuestionAnsweredResultAbstractService {
    @Override
    public QuestionnaireResultDetailPO getResultDetail(SubmitQuestionnaireAnswerDTO answer, QuestionPO question) {
        if(TrueFalseEnum.FALSE.equals(question.getIsRequired()) && CollectionUtils.isEmpty(answer.getOptions())){
            return getResult(answer.getQuestionUid(), question.getQuestionType(), 0, null);
        }
        if(CollectionUtils.isEmpty(answer.getOptions()) || answer.getOptions().size() != 1){
            throw new BaseException(BaseCode.ILLEGAL_PARAMETER, "该题为单选题");
        }
        String selectedOptionUid = answer.getOptions().get(0);
        Map<String, List<QuestionOptionPO>> OptionUidToOptions = getOptionUidToOptionMap(question.getOptions());
        if(!OptionUidToOptions.keySet().contains(selectedOptionUid)){
            throw new BaseException(BaseCode.ILLEGAL_PARAMETER, "选择的答案不属于该题");
        }
        List<QuestionOptionPO> options = OptionUidToOptions.get(selectedOptionUid);

        return getResult(answer.getQuestionUid(), question.getQuestionType(), options.get(0).getScore(), selectedOptionUid);
    }
}
