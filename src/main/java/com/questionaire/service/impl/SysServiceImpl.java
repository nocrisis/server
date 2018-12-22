package com.questionaire.service.impl;

import com.questionaire.mapper.SysMapper;
import com.questionaire.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysServiceImpl implements SysService {

    @Autowired
    private SysMapper sysMapper;

    @Override
    public String getUuid() {
        return sysMapper.getUuid();
    }

}
