package com.questionaire.pojo.po;

import java.util.Date;
import java.util.List;

public class QuestionnaireResultPO extends BasePO{
    private String resultUid;

    private String openId;

    private String appId;

    private String nickName;

    private String headUrl;

    private String questionnaireUid;

    private String mallName;

    private String brandName;

    private int totalScore;

    private int scoreLevel;

    private int defeatNumber;

    private Date startAt;

    private List<QuestionnaireResultDetailPO> detail;

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

    public int getScoreLevel() {
        return scoreLevel;
    }

    public void setScoreLevel(int scoreLevel) {
        this.scoreLevel = scoreLevel;
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

    public List<QuestionnaireResultDetailPO> getDetail() {
        return detail;
    }

    public void setDetail(List<QuestionnaireResultDetailPO> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuestionnaireResultPO{");
        sb.append("resultUid='").append(resultUid).append('\'');
        sb.append(", openId='").append(openId).append('\'');
        sb.append(", appId='").append(appId).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", headUrl='").append(headUrl).append('\'');
        sb.append(", questionnaireUid='").append(questionnaireUid).append('\'');
        sb.append(", mallName='").append(mallName).append('\'');
        sb.append(", brandName='").append(brandName).append('\'');
        sb.append(", totalScore=").append(totalScore);
        sb.append(", scoreLevel=").append(scoreLevel);
        sb.append(", defeatNumber=").append(defeatNumber);
        sb.append(", startAt=").append(startAt);
        sb.append(", detail=").append(detail);
        sb.append('}');
        return sb.toString();
    }
}
