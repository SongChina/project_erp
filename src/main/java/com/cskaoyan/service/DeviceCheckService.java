package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.bean.QueryStatus;

public interface DeviceCheckService {
    BaseResultVo getDeivceCheckList(int page, int rows);

    QueryStatus insertDeviceCheck(DeviceCheck deviceCheck);

    QueryStatus updateDeviceCheck(DeviceCheck deviceCheck);

    QueryStatus deleteDeviceCheck(String[] ids);

    BaseResultVo queryDeviceCheckById(int page, int rows, String searchValue);

    BaseResultVo queryDeviceCheckByDeviceName(int page, int rows, String searchValue);

    QueryStatus updateDeviceCheckResult(DeviceCheck deviceCheck);
}
