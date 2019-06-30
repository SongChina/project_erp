package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.bean.DeviceMaintainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceMaintainMapper {
    long countByExample(DeviceMaintainExample example);

    int deleteByExample(DeviceMaintainExample example);

    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    List<DeviceMaintain> selectByExample(DeviceMaintainExample example);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByExampleSelective(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByExample(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);

    //新增方法
    List<DeviceMaintain> queryDevicMaintainList();

    List<DeviceMaintain> queryDeviceMaintainById(@Param("searchValue") String searchValue);

    List<DeviceMaintain> queryDeviceMaintainByDeviceFaultId(String searchValue);

    void updateDeviceMaintainNote(@Param("deviceMaintain") DeviceMaintain deviceMaintain);
}