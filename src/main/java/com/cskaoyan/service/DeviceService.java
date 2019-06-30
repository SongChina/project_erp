package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.QueryStatus;

import java.util.List;

public interface DeviceService {
    BaseResultVo queryDeviceList(int rows, int page);

    QueryStatus insertDevice(Device device);


    List<Device> queryDeviceListData();


    QueryStatus updateDevice(Device device);

    QueryStatus deleteDevice(String[] ids);

    BaseResultVo queryDeviceById(int page, int rows, String searchValue);

    BaseResultVo queryDeviceByName(int page, int rows, String searchValue);

    BaseResultVo queryDeviceByDeviceTypeName(int page, int rows, String searchValue);

    Device queryOneDeviceById(String deviceid);

    QueryStatus updateDeviceNote(Device device);
}
