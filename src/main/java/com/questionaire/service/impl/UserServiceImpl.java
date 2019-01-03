package com.questionaire.service.impl;

import com.questionaire.common.constant.enumeration.BaseCode;
import com.questionaire.common.exception.BaseException;
import com.questionaire.mapper.UserMapper;
import com.questionaire.pojo.dto.user.UserInfoDTO;
import com.questionaire.pojo.po.user.UserInfoPO;
import com.questionaire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.security.util.Password;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer insertOrUpdateUser(UserInfoDTO userDTO) {
        return userMapper.insertOrUpdateUser(userDTO);
    }

    @Override
    public String validateUser(UserInfoDTO userDTO) {
        UserInfoPO user = userMapper.getUserByName(userDTO.getUserName());
        String correctPassword = user.getPassword();
        if (!StringUtils.isEmpty(correctPassword)) {
            if (userDTO.getPassword().equals(correctPassword)) {
                return user.getUserId();
            }
        } else {
            throw new BaseException(BaseCode.ILLEGAL_PARAMETER);
        }
        return null;
    }
}

