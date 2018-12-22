package com.questionaire.service.impl;

import com.questionaire.mapper.QuestionMapper;
import com.questionaire.pojo.dto.QuestionDTO;
import com.questionaire.pojo.dto.QuestionOptionDTO;
import com.questionaire.pojo.po.QuestionOptionPO;
import com.questionaire.pojo.po.QuestionPO;
import com.questionaire.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<QuestionDTO> listQuestionsByQuestionnaireUid(String questionnaireUid,int questionNumber){
        List<QuestionPO> questions = questionMapper.listQuestionsByQuestionnaireUid(questionnaireUid,questionNumber);
        if(CollectionUtils.isEmpty(questions)){
            return Collections.emptyList();
        }
        return listConversion(questions);
    }

    @Override
    public List<QuestionDTO> listQuestionsNotRandomByQuestionnaireUid(String questionnaireUid){
        List<QuestionPO> questions = questionMapper.listQuestionsNotRandomByQuestionnaireUid(questionnaireUid);
        if(CollectionUtils.isEmpty(questions)){
            return Collections.emptyList();
        }
        return listConversion(questions);
    }

    @Override
    public List<QuestionPO> listQuestionsByQuestionUids(List<String> answeredQuestionUids) {
        return questionMapper.listQuestionsByQuestionUids(answeredQuestionUids);
    }

    @Override
    public Map<String, List<QuestionPO>> getQuestionUidToQuestionMap(List<String> answeredQuestionUids){
        if(CollectionUtils.isEmpty(answeredQuestionUids)){
            return new HashMap<>();
        }
        List<QuestionPO> questions = listQuestionsByQuestionUids(answeredQuestionUids);
        if(CollectionUtils.isEmpty(questions)){
            return new HashMap<>();
        }
        return questions.stream().collect(Collectors.groupingBy(QuestionPO::getQuestionUid));
    }

    private List<QuestionDTO> listConversion(List<QuestionPO> questions) {
        List<QuestionDTO> questionsDTO = new ArrayList<>(questions.size());
        for(QuestionPO question : questions){
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            List<QuestionOptionDTO> questionOptionDTO = new ArrayList<>();
            List<QuestionOptionPO> questionOptionPO = question.getOptions();
            for(QuestionOptionPO questionOption : questionOptionPO)
            {
                QuestionOptionDTO OptionDTO = new QuestionOptionDTO();
                BeanUtils.copyProperties(questionOption, OptionDTO);
                questionOptionDTO.add(OptionDTO);
            }
            questionDTO.setOptions(questionOptionDTO);
            questionsDTO.add(questionDTO);
        }
        return questionsDTO;
    }
}
