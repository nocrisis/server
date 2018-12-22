package com.questionaire.pojo.po;

public class QuestionnaireResultDetailPO extends BasePO{

    private String detailUid;

    private String resultUid;

    private String questionUid;

    private String questionType;

    private String userAnswer;

    private int score;

    public String getDetailUid() {
        return detailUid;
    }

    public void setDetailUid(String detailUid) {
        this.detailUid = detailUid;
    }

    public String getResultUid() {
        return resultUid;
    }

    public void setResultUid(String resultUid) {
        this.resultUid = resultUid;
    }

    public String getQuestionUid() {
        return questionUid;
    }

    public void setQuestionUid(String questionUid) {
        this.questionUid = questionUid;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuestionnaireResultDetailPO{");
        sb.append("detailUid='").append(detailUid).append('\'');
        sb.append(", resultUid='").append(resultUid).append('\'');
        sb.append(", questionUid='").append(questionUid).append('\'');
        sb.append(", questionType='").append(questionType).append('\'');
        sb.append(", userAnswer='").append(userAnswer).append('\'');
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
