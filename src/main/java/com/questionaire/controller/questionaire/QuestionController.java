package com.questionaire.controller.questionaire;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.questionaire.common.constant.enumeration.BaseCode;
import com.questionaire.common.util.ResultBuilder;
import com.questionaire.pojo.dto.PageContentDTO;
import com.questionaire.pojo.dto.question.QuestionDTO;
import com.questionaire.pojo.po.questionnaire.QuestionnairePO;
import com.questionaire.service.QuestionService;
import com.questionaire.service.QuestionnaireService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("questionnaire")
public class QuestionController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    QuestionnaireService questionnaireService;

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = {"/listQuestion"}, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String listQuestionsByQuestionnaireUid(@RequestBody String payload) {
        logger.info("开始获取问卷题目与选项，入参为{}", payload);
        JSONObject jsonObejct = JSON.parseObject(payload);
        String questionnaireUid = jsonObejct.getString("questionnaire_uid");
        if (StringUtils.isBlank(questionnaireUid)) {
            return ResultBuilder.buildError(BaseCode.QUESTIONNAIRE_UID_IS_EMPTY);
        }
        QuestionnairePO questionnaireInfo = questionnaireService.getQuestionnaireInfoByUid(questionnaireUid);
        if (null == questionnaireInfo) {
            return ResultBuilder.buildError(BaseCode.QUESTIONNAIRE_IS_EXIST);
        }
        List<QuestionDTO> listQuestionDTO = questionService.listQuestionsByQuestionnaireUid(questionnaireUid);
        return ResultBuilder.buildSuccessData(new PageContentDTO(listQuestionDTO.size(), listQuestionDTO));
    }

}
