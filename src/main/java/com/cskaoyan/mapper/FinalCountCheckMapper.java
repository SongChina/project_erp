package com.cskaoyan.mapper;

import com.cskaoyan.bean.FinalCountCheck;
import com.cskaoyan.bean.FinalCountCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalCountCheckMapper {
    long countByExample(FinalCountCheckExample example);

    int deleteByExample(FinalCountCheckExample example);

    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    List<FinalCountCheck> selectByExample(FinalCountCheckExample example);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByExampleSelective(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByExample(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);

    List<FinalCountCheck> selectFinalCountCheck();

    List<FinalCountCheck> searchfCountCheckByfCountCheckId(@Param("searchValue") String searchValue);
    List<FinalCountCheck> searchfCountCheckByOrderId(@Param("searchValue") String searchValue);
    int update_note(@Param("fCountCheckId") String fCountCheckId, @Param("note") String note);
    int update_all(@Param("fCountCheck") FinalCountCheck finalCountCheck);
}