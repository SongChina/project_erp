package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.DeviceExample;
import java.util.List;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.QueryStatus;
import org.apache.ibatis.annotations.Param;

public interface DeviceMapper {
    //自己写的查询方法
    List<Device> queryDeviceList();
    int queryTotalDevice();


    //逆向工程提供的查询方法
    long countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(String deviceId);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);


    List<Device> queryDeviceById(@Param("searchValue") String searchValue);

    List<Device> queryDeviceByName(@Param("searchValue") String searchValue);

    List<Device> queryDeviceByDeviceTypeName(@Param("searchValue") String searchValue);

    void updateDeviceNote(@Param("device") Device device);
}