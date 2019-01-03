package com.questionaire.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.questionaire.common.constant.enumeration.BaseCode;
import com.questionaire.common.util.FastJsonUtils;
import com.questionaire.common.util.ResultBuilder;
import com.questionaire.common.validation.EntityValidator;
import com.questionaire.common.validation.ValidateResult;
import com.questionaire.common.validation.group.Insert;
import com.questionaire.common.validation.group.Update;
import com.questionaire.pojo.dto.user.UserInfoDTO;
import com.questionaire.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/createUser"}, method = RequestMethod.POST)
    @ResponseBody
    public String createUser(@RequestBody String payload) {
        logger.info("创建用户题目与选项，入参为{}", payload);
        UserInfoDTO userInfo = FastJsonUtils.toBean(payload, UserInfoDTO.class);
        ValidateResult validateResult = EntityValidator.validateEntity(userInfo);
        if (validateResult.hasError()) {
            return ResultBuilder.buildError(validateResult.getErrorMessages());
        }
        Integer result = userService.insertOrUpdateUser(userInfo);
        if (result == null) {
            return ResultBuilder.buildError(BaseCode.QUESTIONNAIRE_INSERT_ERROR);
        }
        return ResultBuilder.buildSuccess("创建用户成功");
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getUser(@RequestBody String payload) {
        logger.info("获取详情", payload);
        UserInfoDTO userInfo = FastJsonUtils.toBean(payload, UserInfoDTO.class);
        ValidateResult validateResult = EntityValidator.validateEntity(userInfo);
        if (validateResult.hasError()) {
            return ResultBuilder.buildError( validateResult.getErrorMessages());
        }
        String userId = userService.validateUser(userInfo);
        if (StringUtils.isEmpty(userId)) {
            return ResultBuilder.buildError("账号或密码不正确");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", userId);
        return ResultBuilder.buildSuccessData(jsonObject);
    }

    @RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
    @ResponseBody
    public String updatePassword(@RequestBody String payload) {
        logger.info("更新用户密码{}", payload);
        UserInfoDTO userDTO = FastJsonUtils.toBean(payload, UserInfoDTO.class);
        Integer resultColumn = userService.insertOrUpdateUser(userDTO);
        if (resultColumn != null) {
            return ResultBuilder.buildSuccess("更新密码成功");
        } else {
            return ResultBuilder.buildError("更新密码失败");
        }
    }


}
