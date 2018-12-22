package com.questionaire.mapper;

import com.questionaire.pojo.po.MottoPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MottoMapper {

    MottoPO getRandomMotto();
}
