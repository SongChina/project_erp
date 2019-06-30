package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.bean.DeviceTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceTypeMapper {

    //新增方法

    //查询设备种类总数
    int queryTotalDeviceType();

    //查询所有设备种类
    List<DeviceType> queryDeviceTypeList();

    //按设备种类Id查询
    List<DeviceType> queryDeviceTypeById(@Param("searchValue") String searchValue);

    //按设备种类Name查询
    List<DeviceType> queryDeviceTypeByName(@Param("searchValue") String searchValue);

    //查询设备种类id和name
    DeviceType[] queryDeviceTypeIdAndName();

    long countByExample(DeviceTypeExample example);

    int deleteByExample(DeviceTypeExample example);

    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    List<DeviceType> selectByExample(DeviceTypeExample example);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByExampleSelective(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByExample(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);



}