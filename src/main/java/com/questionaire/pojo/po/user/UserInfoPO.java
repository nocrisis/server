package com.questionaire.pojo.po.user;

import com.questionaire.pojo.po.BasePO;

public class UserInfoPO extends BasePO {
    private String userName;
    private String userId;
    private String phone;
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
        return "UserInfoPO{" +
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
