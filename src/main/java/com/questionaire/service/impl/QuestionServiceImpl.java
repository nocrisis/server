package com.questionaire.service.impl;

import com.questionaire.common.constant.enumeration.BaseCode;
import com.questionaire.common.constant.enumeration.QuestionTypeEnum;
import com.questionaire.common.exception.BaseException;
import com.questionaire.mapper.QuestionMapper;
import com.questionaire.pojo.dto.question.QuestionDTO;
import com.questionaire.pojo.dto.question.QuestionOptionDTO;
import com.questionaire.pojo.po.questionnaire.QuestionIndexRelationPO;
import com.questionaire.pojo.po.question.QuestionOptionPO;
import com.questionaire.pojo.po.question.QuestionPO;
import com.questionaire.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<QuestionDTO> listQuestionsByQuestionnaireUid(String questionnaireUid, int index) {
        List<QuestionPO> questions = questionMapper.listQuestionsByQuestionnaireUid(questionnaireUid);
        if (CollectionUtils.isEmpty(questions)) {
            return Collections.emptyList();
        }
        return listConversion(questions);
    }

    @Override
    @Transactional
    public Integer batchDeleteQuestionWithOption(List<String> questionUids) {
        Integer result1 = questionMapper.batchDeleteOptionByQuestionUids(questionUids);
        Integer result2 = questionMapper.batchDeleteByQuestionUids(questionUids);
        if (result1 != null || result2 != null) {
            return result2;
        }
        return null;
    }

    @Override
    public List<QuestionDTO> listQuestionsByQuestionnaireUid(String questionnaireUid) {
        List<QuestionPO> questions = questionMapper.listQuestionsByQuestionnaireUid(questionnaireUid);
        if (CollectionUtils.isEmpty(questions)) {
            return Collections.emptyList();
        }
        return listConversion(questions);
    }

    @Override
    public List<QuestionPO> listQuestionsByQuestionUids(List<String> answeredQuestionUids) {
        return questionMapper.listQuestionsByQuestionUids(answeredQuestionUids);
    }

    @Override
    public Map<String, List<QuestionPO>> getQuestionUidToQuestionMap(List<String> answeredQuestionUids) {
        if (CollectionUtils.isEmpty(answeredQuestionUids)) {
            return new HashMap<>();
        }
        List<QuestionPO> questions = listQuestionsByQuestionUids(answeredQuestionUids);
        if (CollectionUtils.isEmpty(questions)) {
            return new HashMap<>();
        }
        return questions.stream().collect(Collectors.groupingBy(QuestionPO::getQuestionUid));
    }

    @Override
    public Integer batchInsertQuestionIndex(List<QuestionIndexRelationPO> rel) {
        return questionMapper.batchInsertQuestionIndex(rel);
    }
    @Override
    public Integer batchDeleteQuestionIndexByQuestionUids(List<QuestionIndexRelationPO> rel) {
        List<String> questionUids = rel.stream().map(QuestionIndexRelationPO::getQuestionUid).collect(Collectors.toList());
        return questionMapper.batchDeleteQuestionIndexByQuestionUids(questionUids);
    }

    @Override
    public void batchInsertQuestionWithOptionAndIndex(List<QuestionDTO> questionDTOList,List<QuestionIndexRelationPO> questionIndexs) {
        for (QuestionDTO question : questionDTOList) {
            QuestionTypeEnum questionType = question.getQuestionType();
            if (questionType == null) {
                throw new BaseException(BaseCode.ILLEGAL_PARAMETER, "题目类型参数缺失");
            }
            Integer resultColumn = insertQuestionWithOption(questionType, question);
            if (resultColumn == null) {
                continue;
            }
            QuestionIndexRelationPO questionIndex = new QuestionIndexRelationPO();
            BeanUtils.copyProperties(question,questionIndex);
            questionIndexs.add(questionIndex);
        }
    }
    @Override
    public void batchInsertQuestionWithOption(List<QuestionDTO> questionDTOList) {
        for (QuestionDTO question : questionDTOList) {
            QuestionTypeEnum questionType = question.getQuestionType();
            if (questionType == null) {
                throw new BaseException(BaseCode.ILLEGAL_PARAMETER, "题目类型参数缺失");
            }
            Integer resultColumn = insertQuestionWithOption(questionType, question);
            if (resultColumn == null) {
                continue;
            }
        }
    }

    public Integer insertQuestionWithOption(QuestionTypeEnum questionType, QuestionDTO question) {
        Integer resultColumn;
        switch (questionType) {
            case TYP_MULTIPLE_CHOICES:
            case TYP_SINGLE_CHOISE:
                resultColumn = createChoices(question);
                break;
            case TYP_SHORT_ANSWER:
                resultColumn = createShortAnswer(question);
                break;
            default:
                throw new BaseException(BaseCode.ILLEGAL_PARAMETER, "题目类型参数不合法");
        }
        return resultColumn;
    }

    @Transactional
    public Integer createChoices(QuestionDTO question) {
        String questionUid = questionMapper.insertOrUpdateQuestion(question);
        List<QuestionOptionDTO> options = question.getOptions();
        options.forEach((option) -> option.setQuestionUid(questionUid));
        Integer result = questionMapper.insertQuestionOption(options);
        return result;
    }

    private Integer createShortAnswer(QuestionDTO question) {
        String questionUid = questionMapper.insertOrUpdateQuestion(question);
        if (!StringUtils.isEmpty(questionUid)) {
            return 1;
        }
        return null;
    }

    private List<QuestionDTO> listConversion(List<QuestionPO> questions) {
        List<QuestionDTO> questionsDTO = new ArrayList<>(questions.size());
        for (QuestionPO question : questions) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            List<QuestionOptionDTO> questionOptionDTO = new ArrayList<>();
            List<QuestionOptionPO> questionOptionPO = question.getOptions();
            for (QuestionOptionPO questionOption : questionOptionPO) {
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
