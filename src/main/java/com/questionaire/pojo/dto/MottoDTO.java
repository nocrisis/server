package com.questionaire.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class MottoDTO extends BaseDTO {

    @JSONField(name = "motto_uid")
    private String mottoUid;

    @JSONField(name = "motto_content")
    private String mottoContent;

    public String getMottoUid() {
        return mottoUid;
    }

    public void setMottoUid(String mottoUid) {
        this.mottoUid = mottoUid;
    }

    public String getMottoContent() {
        return mottoContent;
    }

    public void setMottoContent(String mottoContent) {
        this.mottoContent = mottoContent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MottoPO{");
        sb.append("mottoUid='").append(mottoUid).append('\'');
        sb.append(", mottoContent='").append(mottoContent).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
