package com.questionaire.mapper;


import com.questionaire.pojo.dto.user.UserInfoDTO;
import com.questionaire.pojo.po.user.UserInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper {
    Integer insertOrUpdateUser(UserInfoDTO userDTO);
    UserInfoPO getUserByName(@Param("userName") String userName);
    UserInfoPO getUserById(@Param("userId") String userName);
}
