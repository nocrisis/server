package com.questionaire.controller.questionaire;

import com.alibaba.fastjson.JSON;
import com.questionaire.common.constant.enumeration.BaseCode;
import com.questionaire.common.util.FastJsonUtils;
import com.questionaire.common.util.ResultBuilder;
import com.questionaire.common.validation.EntityValidator;
import com.questionaire.common.validation.ValidateResult;
import com.questionaire.pojo.dto.question.QuestionDTO;
import com.questionaire.pojo.dto.questionnaire.CreateQuestionnaireDTO;
import com.questionaire.pojo.dto.questionnaire.EditQuestionnaireInfo;
import com.questionaire.pojo.dto.questionnaire.QueryQuestionnaireDTO;
import com.questionaire.pojo.dto.questionnaire.UpdateQuestionnaireDTO;
import com.questionaire.pojo.po.questionnaire.QuestionIndexRelationPO;
import com.questionaire.pojo.po.questionnaire.QuestionnairePO;
import com.questionaire.service.QuestionService;
import com.questionaire.service.QuestionnaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("questionnaire")
public class QuestionaireController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionaireController.class);

    @Autowired
    QuestionnaireService questionnaireService;

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = {"/createQuestionnaire"}, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String createQuestionnaire(@RequestBody String payload) {
        logger.info("创建问卷题目与选项，入参为{}", payload);
        CreateQuestionnaireDTO createQuestionnaireDTO = FastJsonUtils.toBean(payload, CreateQuestionnaireDTO.class);
        ValidateResult validateResult = EntityValidator.validateEntity(createQuestionnaireDTO);
        if (validateResult.hasError()) {
            return ResultBuilder.buildError(validateResult.getErrorMessages());
        }
        List<QuestionDTO> questionDTOList = createQuestionnaireDTO.getQuestionList();
        if (CollectionUtils.isEmpty(questionDTOList)) {
            return ResultBuilder.buildError("没有传入问题的信息");
        }
        Integer result;
        List<QuestionIndexRelationPO> questionIndexRelationPOS = new ArrayList<>(questionDTOList.size());
        try {
            questionService.batchInsertQuestionWithOptionAndIndex(questionDTOList, questionIndexRelationPOS);
            if (!CollectionUtils.isEmpty(questionIndexRelationPOS)) {
                questionService.batchInsertQuestionIndex(questionIndexRelationPOS);
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        result = questionnaireService.createQuestionnaireInfo(createQuestionnaireDTO);
        if (result == null) {
            return ResultBuilder.buildError(BaseCode.QUESTIONNAIRE_INSERT_ERROR);
        }
        return ResultBuilder.buildSuccess("创建问卷成功");
    }

    @RequestMapping(value = {"/listQuestionnaire"}, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String listQuestionnaire(@RequestBody String payload) {
        logger.info("获取问卷列表，入参为{} ",payload);
        QueryQuestionnaireDTO queryQuestionnaireDTO = FastJsonUtils.toBean(payload, QueryQuestionnaireDTO.class);
        ValidateResult validateResult = EntityValidator.validateEntity(queryQuestionnaireDTO);
        if (validateResult.hasError()) {
            return ResultBuilder.buildError(validateResult.getErrorMessages());
        }
        Integer size = questionnaireService.countQuestionnaireInfo(queryQuestionnaireDTO);
        if (size == null) {
            return ResultBuilder.buildSuccessData(Collections.emptyList());
        }
        List<QuestionnairePO> questionnaireList = questionnaireService.listQuestionnaireInfo(queryQuestionnaireDTO);
        return ResultBuilder.buildSuccessData(questionnaireList);
    }


    @RequestMapping(value = {"/deleteQuestionnaire"}, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteQuestionnaire(@RequestBody String payload) {
        logger.info("删除问卷，请求参数：{}", payload);
        String questionnaireUid = JSON.parseObject(payload).getString("questionnaire_uid");
        Integer resultColumn = questionnaireService.deleteQuestionnaireInfo(questionnaireUid);
        if (resultColumn != null) {
            return ResultBuilder.buildSuccess("删除问卷成功");
        } else {
            return ResultBuilder.buildError("删除问卷失败");
        }
    }

    @RequestMapping(value = "/getQuestionnaire/{questionnaire_uid}.html", method = RequestMethod.GET)
    public String getQuestionnaire(@PathVariable("questionnaire_uid") String questionnaireUid, Model model) {
        logger.info("获取questionnaireUid={}的详情", questionnaireUid);
        QuestionnairePO questionnairePO = questionnaireService.getQuestionnaireInfoByUid(questionnaireUid);
        List<QuestionDTO> listQuestionDTO = questionService.listQuestionsByQuestionnaireUid(questionnaireUid);
        model.addAttribute("questionList", listQuestionDTO);
        model.addAttribute("questionnaire", questionnairePO);
        return "page/questionnaire/edit";
    }

    @RequestMapping(value = "/updateissuestatus", method = RequestMethod.POST)
    @ResponseBody
    public String updateissuestatus(@RequestBody String payload) {
        logger.info("更新问卷发布状态{}", payload);
        String questionnaireUid = JSON.parseObject(payload).getString("questionnaire_uid");
        String isIssue = JSON.parseObject(payload).getString("is_issue");
        Integer resultColumn = questionnaireService.updateIssueStatus(Integer.valueOf(isIssue), questionnaireUid);
        if (resultColumn != null) {
            return ResultBuilder.buildSuccess("更新发布成功");
        } else {
            return ResultBuilder.buildError("更新发布失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updatequestionnaire", method = RequestMethod.POST)
    public String updateQuestionnaire(@RequestBody String payload) {
        logger.info("编辑更新问卷入参；{}", payload);
        UpdateQuestionnaireDTO updateQuestionnaireDTO = FastJsonUtils.toBean(payload, UpdateQuestionnaireDTO.class);
        List<QuestionDTO> newQuestions = updateQuestionnaireDTO.getNewQuestions();
        List<String> deleteQuestionUids = updateQuestionnaireDTO.getDeleteQuestionUids();
        List<QuestionDTO> updateQuestions = updateQuestionnaireDTO.getUpdateQuestions();
        EditQuestionnaireInfo editQuestionnaireInfo = updateQuestionnaireDTO.getEditQuestionnaireInfo();
        List<QuestionIndexRelationPO> questionIndexRelationPOS = updateQuestionnaireDTO.getQuestionIndexRelationPOS();
        if (!CollectionUtils.isEmpty(deleteQuestionUids)) {
            Integer result1 = questionService.batchDeleteQuestionWithOption(deleteQuestionUids);
            if (result1 == null) {
                throw new RuntimeException();
            }
        }
        if (!CollectionUtils.isEmpty(updateQuestions)) {
            try {
                questionService.batchInsertQuestionWithOption(updateQuestions);
            } catch (Exception e) {
                logger.error("更新问题和选项失败" + e.toString());
            }
        }
        if (!CollectionUtils.isEmpty(newQuestions)) {
            questionService.batchInsertQuestionWithOption(newQuestions);
        }
        if(!CollectionUtils.isEmpty(questionIndexRelationPOS)){
            questionService.batchDeleteQuestionIndexByQuestionUids(questionIndexRelationPOS);
            questionService.batchInsertQuestionIndex(questionIndexRelationPOS);
        }
        if (editQuestionnaireInfo != null) {
            Integer resultColumn = questionnaireService.updateQuestionnaireInfo(editQuestionnaireInfo);
        }
        return ResultBuilder.buildSuccess("更新问卷成功");
    }

}
