package com.questionaire.service.impl;

import com.questionaire.mapper.QuestionAnswerMapper;
import com.questionaire.mapper.QuestionnaireAnswerMapper;
import com.questionaire.pojo.dto.questionnaire.QuestionnaireAnswerDTO;
import com.questionaire.pojo.dto.questionnaire.SubmitQuestionnaireDTO;
import com.questionaire.pojo.po.questionnaire.QuestionnaireAnswerPO;
import com.questionaire.service.QuestionnaireAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class QuestionnaireAnswerServiceimpl implements QuestionnaireAnswerService {
    @Autowired
    private QuestionnaireAnswerMapper questionnaireAnswerMapper;
    @Autowired
    private QuestionAnswerMapper questionAnswerMapper;

    @Override
    @Transactional
    public Integer insertQuestionAnswer(SubmitQuestionnaireDTO submitQuestionnaireDTO) {
        Integer result1 = questionAnswerMapper.batchInsert(submitQuestionnaireDTO.getAnswer());
        Date startAt = submitQuestionnaireDTO.getStartAt();
        Date endAt = submitQuestionnaireDTO.getEndedAt();
        QuestionnaireAnswerPO questionnaireAnswerPO = new QuestionnaireAnswerPO();
        questionnaireAnswerPO.setUseTime(calculateminute(startAt,endAt));
        questionnaireAnswerPO.setStartAt(startAt);
        questionnaireAnswerPO.setEndAt(endAt);
        questionnaireAnswerPO.setQuestionnaireUid(submitQuestionnaireDTO.getQuestionnaireUid());
        Integer result2 = questionnaireAnswerMapper.insertQuestionnaireAnswer(questionnaireAnswerPO);
        return result2;
    }
    private int  calculateminute(Date startAt ,Date endAt){
        long from = startAt.getTime();
        long to = endAt.getTime();
        int minutes = (int) ((to - from) / (1000 * 60));
        return minutes;
    }

    @Override
    public List<QuestionnaireAnswerDTO> listSamples(String questionnaireUid) {
        return null;
    }

    @Override
    public QuestionnaireAnswerDTO getSamples(String sampleUid) {
        QuestionnaireAnswerDTO sample = questionnaireAnswerMapper.getQuestionnaireResultBysampleUid(sampleUid);
        return null;
    }
}
