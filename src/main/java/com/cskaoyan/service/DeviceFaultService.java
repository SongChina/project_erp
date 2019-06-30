package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.bean.QueryStatus;
import org.apache.ibatis.annotations.Param;

public interface DeviceFaultService {
    BaseResultVo queryDeviceFaultList(int page, int rows);

    QueryStatus deviceFaultInsert(DeviceFault deviceFault);

    QueryStatus updateDeviceFault(DeviceFault deviceFault);

    QueryStatus deleteDeviceFault(String[] ids);

    BaseResultVo queryDeviceFaultById(int page, int rows, String searchValue);

    BaseResultVo queryDeviceFaultByDeviceName(int page, int rows, String searchValue);

    DeviceFault queryOneDeviceFaultById(String deviceFaultId);

    QueryStatus updateDeviceFaultDetail(DeviceFault deviceFault);
}
