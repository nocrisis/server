package com.questionaire.controller.questionaire;

import com.questionaire.common.constant.enumeration.BaseCode;
import com.questionaire.common.util.FastJsonUtils;
import com.questionaire.common.util.ResultBuilder;
import com.questionaire.common.validation.EntityValidator;
import com.questionaire.common.validation.ValidateResult;
import com.questionaire.pojo.dto.questionnaire.SubmitQuestionnaireDTO;
import com.questionaire.service.QuestionService;
import com.questionaire.service.QuestionnaireAnswerService;
import com.questionaire.service.QuestionnaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sample")
public class QuestionnaireAnswerController {

    private static final Logger logger = LoggerFactory.getLogger(QuestionnaireAnswerController.class);
    @Autowired
    private QuestionnaireService questionnaireService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionnaireAnswerService questionnaireAnswerService;

    @RequestMapping(value = {"/submit"}, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String submitQuestionnaireAnswer(@RequestBody String payload) {
        SubmitQuestionnaireDTO submitQuestionnaireDTO = FastJsonUtils.toBean(payload, SubmitQuestionnaireDTO.class);
        ValidateResult validateResult = EntityValidator.validateEntity(submitQuestionnaireDTO);
        if (validateResult.hasError()) {
            return ResultBuilder.buildError( validateResult.getErrorMessages());
        }
        Integer result = questionnaireAnswerService.insertQuestionAnswer(submitQuestionnaireDTO);
        return ResultBuilder.buildSuccessData(result);
    }
//    @RequestMapping(value = {"/list"}, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String getQuestionnaireAnswer(String payload) {
//        logger.info("开始获取问卷题目与选项，入参为{}", payload);
//        JSONObject jsonObejct = JSON.parseObject(payload);
//        String questionnaireUid = jsonObejct.getString("questionnaire_uid");
//        if (StringUtils.isBlank(questionnaireUid)) {
//            return ResultBuilder.buildError(BaseCode.QUESTIONNAIRE_UID_IS_EMPTY, "问卷Uid不能为空");
//        }
//        Integer result = questionnaireAnswerService.(submitQuestionnaireDTO);
//        return ResultBuilder.buildSuccess(result);
//    }
//    @RequestMapping(value = {"/get"}, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String getQuestionnaireAnswer(String payload) {
//        logger.info("开始获取问卷题目与选项，入参为{}", payload);
//        JSONObject jsonObejct = JSON.parseObject(payload);
//        String sampleUid = jsonObejct.getString("sample_uid");
//        if (StringUtils.isBlank(sampleUid)) {
//            return ResultBuilder.buildError(BaseCode.QUESTIONNAIRE_UID_IS_EMPTY, "样本Uid不能为空");
//        }
//        Integer result = questionnaireAnswerService.insertQuestionAnswer(submitQuestionnaireDTO);
//        return ResultBuilder.buildSuccess(result);
//    }



}
