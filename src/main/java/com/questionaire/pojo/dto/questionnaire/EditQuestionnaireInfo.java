package com.questionaire.pojo.dto.questionnaire;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class EditQuestionnaireInfo {
    @NotNull(message = "问卷questionnaire_uid不能为空")
    @JSONField(name = "questionnaire_uid")
    private String questionnaireUid;

    @NotNull(message = "用户填写的问卷标题不能为空")
    @Size(min = 1, message = "用户填写的问卷标题不能为空")
    @JSONField(name = "questionnaire_name")
    private String questionnaireName;

    @JSONField(name = "introduction")
    private String introduction;

    @JSONField(name = "user_id")
    private String userId;

    @JSONField(name = "started_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date startedAt;

    @NotNull(message = "结束时间不能为空")
    @JSONField(name = "ended_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date endedAt;

    @JSONField(name = "timekeeping")
    private Date timekeeping;

    @JSONField(name = "update_by")
    private String updateBy;

    @NotNull
    public String getQuestionnaireUid() { return questionnaireUid; }

    public void setQuestionnaireUid(@NotNull String questionnaireUid) { this.questionnaireUid = questionnaireUid; }

    @NotNull
    public String getQuestionnaireName() { return questionnaireName; }

    public void setQuestionnaireName(@NotNull String questionnaireName) { this.questionnaireName = questionnaireName; }

    public String getIntroduction() { return introduction; }

    public void setIntroduction(String introduction) { this.introduction = introduction; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public Date getStartedAt() { return startedAt; }

    public void setStartedAt(Date startedAt) { this.startedAt = startedAt; }

    @NotNull
    public Date getEndedAt() { return endedAt; }

    public void setEndedAt(@NotNull Date endedAt) { this.endedAt = endedAt; }

    public Date getTimekeeping() { return timekeeping; }

    public void setTimekeeping(Date timekeeping) { this.timekeeping = timekeeping; }

    public String getUpdateBy() { return updateBy; }

    public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }

    @Override
    public String toString() {
        return "EditQuestionnaireInfo{" +
                "questionnaireUid='" + questionnaireUid + '\'' +
                ", questionnaireName='" + questionnaireName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", userId='" + userId + '\'' +
                ", startedAt=" + startedAt +
                ", endedAt=" + endedAt +
                ", timekeeping=" + timekeeping +
                ", updateBy='" + updateBy + '\'' +
                '}';
    }
}
