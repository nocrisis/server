package com.questionaire.pojo.dto.questionnaire;

import com.alibaba.fastjson.annotation.JSONField;
import com.questionaire.common.constant.enumeration.QuestionnairePlatformEnum;
import com.questionaire.pojo.dto.BaseDTO;
import com.questionaire.pojo.dto.question.QuestionAnswerDTO;
import com.questionaire.pojo.dto.question.QuestionDTO;

import java.util.Date;
import java.util.List;

public class QuestionnaireAnswerDTO extends BaseDTO {

    @JSONField(name = "sample_uid")
    private String sampleUid;
    @JSONField(name = "questionnaire_uid")
    private String questionnaireUid;
    @JSONField(name = "start_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date startAt;
    @JSONField(name = "end_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date endAt;
    @JSONField(name = "platform")
    private QuestionnairePlatformEnum platform;
    @JSONField(name = "answers")
    private List<QuestionAnswerDTO> answers;
    @JSONField(name = "questions")
    private List<QuestionDTO> questions;

    public List<QuestionDTO> getQuestions() { return questions; }

    public void setQuestions(List<QuestionDTO> questions) { this.questions = questions; }

    public String getSampleUid() { return sampleUid; }

    public void setSampleUid(String sampleUid) { this.sampleUid = sampleUid; }

    public List<QuestionAnswerDTO> getAnswers() { return answers; }

    public void setAnswers(List<QuestionAnswerDTO> answers) { this.answers = answers; }

    public String getQuestionnaireUid() { return questionnaireUid; }

    public void setQuestionnaireUid(String questionnaireUid) { this.questionnaireUid = questionnaireUid; }

    public Date getStartAt() { return startAt; }

    public void setStartAt(Date startAt) { this.startAt = startAt; }

    public Date getEndAt() { return endAt; }

    public void setEndAt(Date endAt) { this.endAt = endAt; }

    public QuestionnairePlatformEnum getPlatform() { return platform; }

    public void setPlatform(QuestionnairePlatformEnum platform) { this.platform = platform; }

    @Override
    public String toString() {
        return "QuestionnaireAnswerDTO{" +
                "sampleUid='" + sampleUid + '\'' +
                ", questionnaireUid='" + questionnaireUid + '\'' +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", platform=" + platform +
                ", answers=" + answers +
                ", questions=" + questions +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}