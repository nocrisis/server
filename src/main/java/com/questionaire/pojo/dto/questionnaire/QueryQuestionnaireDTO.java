package com.questionaire.pojo.dto.questionnaire;

import com.alibaba.fastjson.annotation.JSONField;
import com.questionaire.pojo.BasePageRequest;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

public class QueryQuestionnaireDTO extends BasePageRequest {
    @JSONField(name = "questionnaire_name")
    private String questionnaireName;
    @JSONField(name = "started_at")
    private Date started_at;
    @JSONField(name = "ended_at")
    private Date ended_at;
    @NotBlank(message = "用户账号不能为空")
    @JSONField(name = "user_id")
    private String userId;

    public String getQuestionnaireName() { return questionnaireName; }

    public void setQuestionnaireName(String questionnaireName) { this.questionnaireName = questionnaireName; }

    public Date getStarted_at() { return started_at; }

    public void setStarted_at(Date started_at) { this.started_at = started_at; }

    public Date getEnded_at() { return ended_at; }

    public void setEnded_at(Date ended_at) { this.ended_at = ended_at; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    @Override
    public String toString() {
        return "QueryQuestionnaireDTO{" +
                "questionnaireName='" + questionnaireName + '\'' +
                ", started_at=" + started_at +
                ", ended_at=" + ended_at +
                ", userId='" + userId + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
