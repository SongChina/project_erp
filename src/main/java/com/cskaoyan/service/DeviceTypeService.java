package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.bean.QueryStatus;

public interface DeviceTypeService {
    BaseResultVo getDeivceTypeList(int page, int rows);

    QueryStatus insertDeviceType(DeviceType deviceType);

    QueryStatus updateDeviceType(DeviceType deviceType);

    QueryStatus deleteDeviceType(String[] ids);

    BaseResultVo queryDeviceTypeById(int page, int rows, String searchValue);

    BaseResultVo queryDeviceTypeByName(int page, int rows, String searchValue);

    DeviceType[] queryDeviceTypeIdAndName();

    DeviceType queryOneDeviceTypeById(String devicetyepid);
}
