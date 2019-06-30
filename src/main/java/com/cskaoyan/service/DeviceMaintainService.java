package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.bean.QueryStatus;

public interface DeviceMaintainService {
    BaseResultVo getDeivceMaintainList(int page, int rows);

    QueryStatus deviceMaintainInsert(DeviceMaintain deviceMaintain);

    QueryStatus updateDeviceMaintain(DeviceMaintain deviceMaintain);

    QueryStatus deleteDeviceMaintain(String[] ids);

    BaseResultVo queryDeviceMaintainById(int page, int rows, String searchValue);

    BaseResultVo queryDeviceMaintainByDeviceFaultId(int page, int rows, String searchValue);

    QueryStatus updateDeviceMaintainNote(DeviceMaintain deviceMaintain);
}
