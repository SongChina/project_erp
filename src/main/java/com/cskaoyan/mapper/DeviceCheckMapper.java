package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.bean.DeviceCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceCheckMapper {
    //新增方法
    //查询
    List<DeviceCheck> queryDeviceCheckList();


    //通过设备例检ID查询设备例检数据
    List<DeviceCheck> queryDeviceCheckById(@Param("searchValue") String searchValue);

    //通过设备名称查询设备例检数据
    List<DeviceCheck> queryDeviceCheckByDeviceName(@Param("searchValue") String searchValue);


    long countByExample(DeviceCheckExample example);

    int deleteByExample(DeviceCheckExample example);

    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    List<DeviceCheck> selectByExample(DeviceCheckExample example);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByExampleSelective(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByExample(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);


    void updateDeviceCheckResult(@Param("deviceCheck") DeviceCheck deviceCheck);
}