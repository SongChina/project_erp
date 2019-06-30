package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.bean.DeviceFaultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceFaultMapper {

    //新增方法
    //查询所有设备故障信息

    List<DeviceFault> queryDeviceFaultList();

    //根据设备故障编号搜索
    List<DeviceFault> queryDeviceFaultById(@Param("searchValue") String searchValue);

    //根据设备名称编号搜索
    List<DeviceFault> queryDeviceFaultByDeviceName(@Param("searchValue") String searchValue);

    long countByExample(DeviceFaultExample example);

    int deleteByExample(DeviceFaultExample example);

    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    List<DeviceFault> selectByExample(DeviceFaultExample example);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByExampleSelective(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByExample(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);


    void updateDeviceFaultDetail(@Param("deviceFault") DeviceFault deviceFault);
}