package com.questionaire.service.impl;

import com.questionaire.mapper.QuestionMapper;
import com.questionaire.mapper.QuestionnaireMapper;
import com.questionaire.pojo.dto.questionnaire.CreateQuestionnaireDTO;
import com.questionaire.pojo.dto.questionnaire.EditQuestionnaireInfo;
import com.questionaire.pojo.dto.questionnaire.QueryQuestionnaireDTO;
import com.questionaire.pojo.dto.questionnaire.UpdateQuestionnaireDTO;
import com.questionaire.pojo.po.questionnaire.QuestionnairePO;
import com.questionaire.service.QuestionnaireService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireMapper questionnaireMapper;
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public QuestionnairePO getQuestionnaireInfoByUid(String questionnaireUid) {
        return questionnaireMapper.getQuestionnaireInfoByUid(questionnaireUid);
    }

    @Override
    public Integer createQuestionnaireInfo(CreateQuestionnaireDTO createQuestionnaireDTO) {
        QuestionnairePO questionnairePO = new QuestionnairePO();
        BeanUtils.copyProperties(createQuestionnaireDTO, questionnairePO);
        return questionnaireMapper.insertQuestionnaireInfo(questionnairePO);
    }

    @Override
    public Integer updateQuestionnaireInfo(EditQuestionnaireInfo editQuestionnaireInfo) {
        return questionnaireMapper.updateQuestionnaireInfo(editQuestionnaireInfo);
    }

    @Override
    public Integer updateIssueStatus(Integer isIssue, String questionnaireUid) {
        return questionnaireMapper.updateIssueStatus(isIssue, questionnaireUid);
    }

    @Override
    @Transactional
    public Integer deleteQuestionnaireInfo(String questionnaireUid) {
        Integer result1 = questionMapper.deleteQuestionByQuestionnaireUid(questionnaireUid);
        Integer result2 = questionnaireMapper.deleteQuestionnaireInfo(questionnaireUid);
        if(result1.equals(null)||result2.equals(null)){
            return null;
        }
        return Integer.valueOf(1);
    }


    @Override
    public List<QuestionnairePO> listQuestionnaireInfo(QueryQuestionnaireDTO queryQuestionnaireDTO) {
        if (queryQuestionnaireDTO.getPageNo() == 0) {
            queryQuestionnaireDTO.setPageNo(0);
        } if (queryQuestionnaireDTO.getPageSize() == 0) {
            queryQuestionnaireDTO.setPageSize(50);
        }
        return questionnaireMapper.listQuestionnaireInfo(queryQuestionnaireDTO);
    }

    @Override
    public Integer countQuestionnaireInfo(QueryQuestionnaireDTO queryQuestionnaireDTO) {
        if (queryQuestionnaireDTO.getPageNo() == 0) {
            queryQuestionnaireDTO.setPageNo(0);
        } if (queryQuestionnaireDTO.getPageSize() == 0) {
            queryQuestionnaireDTO.setPageSize(50);
        }
        return questionnaireMapper.countQuestionnaireInfo(queryQuestionnaireDTO);
    }
}
