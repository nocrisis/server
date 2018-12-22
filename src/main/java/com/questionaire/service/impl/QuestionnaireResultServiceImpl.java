package com.questionaire.service.impl;

import com.questionaire.common.constant.enumeration.BaseCode;
import com.questionaire.common.exception.BaseException;
import com.questionaire.common.util.EmojiUtils;
import com.questionaire.mapper.QuestionnaireResultDetailMapper;
import com.questionaire.mapper.QuestionnaireResultMapper;
import com.questionaire.pojo.dto.QuestionnaireResultDTO;
import com.questionaire.pojo.dto.SubmitQuestionnaireResultDTO;
import com.questionaire.pojo.po.QuestionnaireResultPO;
import com.questionaire.service.QuestionnaireResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionnaireResultServiceImpl implements QuestionnaireResultService {
    private static final Logger logger = LoggerFactory.getLogger(QuestionnaireResultServiceImpl.class);

    @Autowired
    private QuestionnaireResultMapper questionnaireResultMapper;
    @Autowired
    private QuestionnaireResultDetailMapper questionnaireResultDetailMapper;

    @Override
    @Transactional
    public SubmitQuestionnaireResultDTO insertQuestionnaireResult(QuestionnaireResultPO questionnaireResult) {
        try{
            logger.info("之前：{}", questionnaireResult.getNickName());
            questionnaireResult.setNickName(EmojiUtils.filterEmoji(questionnaireResult.getNickName()));
            questionnaireResult.setMallName(EmojiUtils.filterEmoji(questionnaireResult.getMallName()));
            questionnaireResult.setBrandName(EmojiUtils.filterEmoji(questionnaireResult.getBrandName()));

            logger.info("之后：{}", questionnaireResult.getNickName());
            questionnaireResultMapper.insert(questionnaireResult);
        }catch (DuplicateKeyException e){
            throw new BaseException(BaseCode.USER_QUESTIONNAIRE_UNIQUE_ERROR);
        }
        questionnaireResultDetailMapper.batchInsert(questionnaireResult.getDetail());

        SubmitQuestionnaireResultDTO result = new SubmitQuestionnaireResultDTO();
        BeanUtils.copyProperties(questionnaireResult, result);
        return result;
    }

    @Override
    public QuestionnaireResultDTO getQuestionnaireResultByOpenIdAndQuestionnaireUid(String openId, String appId, String questionnaireUid) {
        return questionnaireResultMapper.getQuestionnaireResultByOpenIdAndQuestionnaireUid(openId, appId, questionnaireUid);
    }

    @Override
    public QuestionnaireResultDTO getQuestionnaireResultByUid(String resultUid) {
        return questionnaireResultMapper.getQuestionnaireResultByUid(resultUid);
    }
}
