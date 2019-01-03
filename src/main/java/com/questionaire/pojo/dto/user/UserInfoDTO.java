package com.questionaire.pojo.dto.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.questionaire.pojo.po.BasePO;
import org.hibernate.validator.constraints.NotBlank;

public class UserInfoDTO extends BasePO {
    @NotBlank(message = "用户名不能为空")
    @JSONField(name = "user_name")
    private String userName;

    @JSONField(name = "user_id")
    private String userId;
    @JSONField(name = "phone")
    private String phone;
    @NotBlank(message = "密码不能为空")
    @JSONField(name = "password")
    private String password;

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", archive=" + archive +
                '}';
    }
}
