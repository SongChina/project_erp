package com.cskaoyan.mapper;

import com.cskaoyan.bean.FinalMeasuretCheck;
import com.cskaoyan.bean.FinalMeasuretCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalMeasuretCheckMapper {
    long countByExample(FinalMeasuretCheckExample example);

    int deleteByExample(FinalMeasuretCheckExample example);

    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    List<FinalMeasuretCheck> selectByExample(FinalMeasuretCheckExample example);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByExampleSelective(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByExample(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);

    List<FinalMeasuretCheck> selectFinalMeasuretCheck();
    List<FinalMeasuretCheck> searchfMeasureCheckByfMeasureCheckId(@Param("searchValue") String searchValue);
    List<FinalMeasuretCheck> searchfMeasureCheckByOrderId(@Param("searchValue") String searchValue);
    int update_note(@Param("fMeasureCheckId") String fMeasureCheckId, @Param("note") String note);
    int update_all(@Param("measure") FinalMeasuretCheck finalMeasuretCheck);
}