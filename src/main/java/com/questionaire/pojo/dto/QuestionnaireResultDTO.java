package com.questionaire.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class QuestionnaireResultDTO extends BaseDTO {

    @JSONField(name = "result_uid")
    private String resultUid;
    @JSONField(name = "open_id")
    private String openId;
    @JSONField(name = "app_id")
    private String appId;
    @JSONField(name = "nick_name")
    private String nickName;
    @JSONField(name = "head_url")
    private String headUrl;
    @JSONField(name = "questionnaire_uid")
    private String questionnaireUid;
    @JSONField(name = "mall_name")
    private String mallName;
    @JSONField(name = "brand_name")
    private String brandName;
    @JSONField(name = "total_score")
    private int totalScore;
    @JSONField(name = "defeat_number")
    private int defeatNumber;
    @JSONField(name = "start_at", format = "yyyy-MM-dd HH:mm:ss")
    public Date startAt;

    public String getResultUid() {
        return resultUid;
    }

    public void setResultUid(String resultUid) {
        this.resultUid = resultUid;
    }

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

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getDefeatNumber() {
        return defeatNumber;
    }

    public void setDefeatNumber(int defeatNumber) {
        this.defeatNumber = defeatNumber;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuestionnaireResultDTO{");
        sb.append("resultUid='").append(resultUid).append('\'');
        sb.append(", openId='").append(openId).append('\'');
        sb.append(", appId='").append(appId).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", headUrl='").append(headUrl).append('\'');
        sb.append(", questionnaireUid='").append(questionnaireUid).append('\'');
        sb.append(", mallName='").append(mallName).append('\'');
        sb.append(", brandName='").append(brandName).append('\'');
        sb.append(", totalScore=").append(totalScore);
        sb.append(", defeatNumber=").append(defeatNumber);
        sb.append(", startAt=").append(startAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", updatedBy='").append(updatedBy).append('\'');
        sb.append(", pageNo=").append(pageNo);
        sb.append(", pageSize=").append(pageSize);
        sb.append('}');
        return sb.toString();
    }
}
