package com.questionaire.service;

import com.questionaire.pojo.dto.user.UserInfoDTO;

public interface UserService {
    Integer insertOrUpdateUser(UserInfoDTO userDTO);
    String validateUser(UserInfoDTO userDTO);
}
