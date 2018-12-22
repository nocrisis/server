package com.questionaire.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class SubmitQuestionnaireResultDTO {

    @JSONField(name = "result_uid")
    private String resultUid;

    @JSONField(name = "total_score")
    private int totalScore;

    @JSONField(name = "score_level")
    private int scoreLevel;

    @JSONField(name = "defeat_number")
    private int defeatNumber;

    public String getResultUid() {
        return resultUid;
    }

    public void setResultUid(String resultUid) {
        this.resultUid = resultUid;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SubmitQuestionnaireResultDTO{");
        sb.append("resultUid='").append(resultUid).append('\'');
        sb.append(", totalScore=").append(totalScore);
        sb.append(", scoreLevel=").append(scoreLevel);
        sb.append(", defeatNumber=").append(defeatNumber);
        sb.append('}');
        return sb.toString();
    }
}
