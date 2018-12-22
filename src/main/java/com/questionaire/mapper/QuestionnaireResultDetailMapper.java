package com.questionaire.mapper;

import com.questionaire.pojo.po.QuestionnaireResultDetailPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionnaireResultDetailMapper {
    int batchInsert(@Param("details") List<QuestionnaireResultDetailPO> details);
}
