package com.questionaire.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class SubmitQuestionnaireDTO {

    @NotNull(message = "填写问卷用户openId不能为空")
    @Size(min = 1, message = "填写问卷用户openId不能为空")
    @JSONField(name = "open_id")
    private String openId;

    @NotNull(message = "appId不能为空")
    @Size(min = 1, message = "appId不能为空")
    @JSONField(name = "app_id")
    private String appId;

    @JSONField(name = "nick_name")
    private String nickName;

    @JSONField(name = "head_url")
    private String headUrl;

    @NotNull(message = "用户填写的问卷uid不能为空")
    @Size(min = 1, message = "用户填写的问卷uid不能为空")
    @JSONField(name = "questionnaire_uid")
    private String questionnaireUid;

    @NotNull(message = "用户填写的商场不能为空")
    @Size(min = 1, message = "用户填写的商场不能为空")
    @JSONField(name = "mall_name")
    private String mallName;

    @NotNull(message = "用户填写的品牌不能为空")
    @Size(min = 1, message = "用户填写的品牌不能为空")
    @JSONField(name = "brand_name")
    private String brandName;

    @JSONField(name = "start_at")
    private Date startAt;

    @NotNull(message = "用户回答的问题不能为空")
    @Size(min = 1, message = "用户回答的问题不能为空")
    @JSONField(name = "answer")
    private List<SubmitQuestionnaireAnswerDTO> answer;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getQuestionnaireUid() {
        return questionnaireUid;
    }

    public void setQuestionnaireUid(String questionnaireUid) {
        this.questionnaireUid = questionnaireUid;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public List<SubmitQuestionnaireAnswerDTO> getAnswer() {
        return answer;
    }

    public void setAnswer(List<SubmitQuestionnaireAnswerDTO> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SubmitQuestionnaireDTO{");
        sb.append("openId='").append(openId).append('\'');
        sb.append(", appId='").append(appId).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", headUrl='").append(headUrl).append('\'');
        sb.append(", questionnaireUid='").append(questionnaireUid).append('\'');
        sb.append(", mallName='").append(mallName).append('\'');
        sb.append(", brandName='").append(brandName).append('\'');
        sb.append(", startAt=").append(startAt);
        sb.append(", answer=").append(answer);
        sb.append('}');
        return sb.toString();
    }
}
