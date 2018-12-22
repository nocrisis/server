package com.questionaire.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class QuestionnaireReusltRequestDTO {

    @JSONField(name = "result_uid")
    private String resultUid;

    @NotNull(message = "openId 不能为空") //, groups = {}
    @Size(min = 1, message = "openId 不能为空")
    @JSONField(name = "open_id")
    private String openId;

//    @NotBlank
    @NotNull(message = "问卷uid 不能为空") //, groups = {}
    @Size(min = 1, message = "问卷uid 不能为空")
    @JSONField(name = "questionnaire_uid")
    private String questionnaireUid;

    @NotNull(message = "appId 不能为空") //, groups = {}
    @Size(min = 1, message = "appId 不能为空")
    @JSONField(name = "app_id")
    private String appId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getResultUid() {
        return resultUid;
    }

    public void setResultUid(String resultUid) {
        this.resultUid = resultUid;
    }

    public String getQuestionnaireUid() {
        return questionnaireUid;
    }

    public void setQuestionnaireUid(String questionnaireUid) {
        this.questionnaireUid = questionnaireUid;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuestionnaireReusltRequestDTO{");
        sb.append("openId='").append(openId).append('\'');
        sb.append(", resultUid='").append(resultUid).append('\'');
        sb.append(", questionnaireUid='").append(questionnaireUid).append('\'');
        sb.append(", appId='").append(appId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
