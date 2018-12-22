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

@Service("TYP_MULTIPLE_CHOICES_SERVICE")
public class MultipleChoicesQuestionAnsweredResultServiceImpl extends QuestionAnsweredResultAbstractService{
    @Override
    public QuestionnaireResultDetailPO getResultDetail(SubmitQuestionnaireAnswerDTO answer, QuestionPO question) {
        if (TrueFalseEnum.FALSE.equals(question.getIsRequired()) && CollectionUtils.isEmpty(answer.getOptions())) {
            return getResult(answer.getQuestionUid(), question.getQuestionType(), 0, null);
        }

        if (TrueFalseEnum.FALSE.equals(question.getIsScoringType())){
            return getNotScoringResult(answer, question);
        }else{
            return getScoringResult(answer, question);
        }
    }

    private QuestionnaireResultDetailPO getScoringResult(SubmitQuestionnaireAnswerDTO answer, QuestionPO question){
        Map<String, List<QuestionOptionPO>> OptionUidToOptions = getOptionUidToOptionMap(question.getOptions());

        int totalScore = 0;
        for(String selectedOption: answer.getOptions()){
            if (!OptionUidToOptions.keySet().contains(selectedOption)) {
                throw new BaseException(BaseCode.ILLEGAL_PARAMETER, "选择的答案不属于该题");
            }
            List<QuestionOptionPO> options = OptionUidToOptions.get(selectedOption);
            totalScore += options.get(0).getScore();
        }
        return getResult(answer.getQuestionUid(), question.getQuestionType(), totalScore, String.join(",", answer.getOptions()));
    }

    private QuestionnaireResultDetailPO getNotScoringResult(SubmitQuestionnaireAnswerDTO answer, QuestionPO question){
        Map<String, List<QuestionOptionPO>> OptionUidToOptions = getOptionUidToOptionMap(question.getOptions());

        int totalScore = 0;
        for(String selectedOption: answer.getOptions()){
            if (!OptionUidToOptions.keySet().contains(selectedOption)) {
                throw new BaseException(BaseCode.ILLEGAL_PARAMETER, "选择的答案不属于该题");
            }
            List<QuestionOptionPO> options = OptionUidToOptions.get(selectedOption);
            if(options.get(0).getScore() == 0){
                break;
            }
            totalScore += options.get(0).getScore();
        }
        if(totalScore > 0){
            totalScore = question.getTotalScore();
        }
        return getResult(answer.getQuestionUid(), question.getQuestionType(), totalScore, String.join(",", answer.getOptions()));
    }
}
