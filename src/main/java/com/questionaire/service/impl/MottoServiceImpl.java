package com.questionaire.service.impl;

import com.questionaire.mapper.MottoMapper;
import com.questionaire.pojo.po.MottoPO;
import com.questionaire.service.MottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Created by xianfuWang
 * @version 2018/7/5.
 */
@Service
public class MottoServiceImpl implements MottoService {

    @Autowired
    private MottoMapper mottoMapper;

    @Override
    public MottoPO getRandomMotto() {
        return mottoMapper.getRandomMotto();
    }
}
