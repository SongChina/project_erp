package com.cskaoyan.service.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.DeviceMaintainMapper;
import com.cskaoyan.service.DeviceMaintainService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

    //显示所有设备维修信息
    @Override
    public BaseResultVo getDeivceMaintainList(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<DeviceMaintain> deviceMaintainList = deviceMaintainMapper.queryDevicMaintainList();
        PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(deviceMaintainList);
        BaseResultVo baseResultVo = new BaseResultVo();
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }

    //新增设备维修信息
    @Override
    public QueryStatus deviceMaintainInsert(DeviceMaintain deviceMaintain) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceMaintainMapper.insert(deviceMaintain);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("插入失败，请重试");
        }
        return queryStatus;
    }

    //修改设备维修信息
    @Override
    public QueryStatus updateDeviceMaintain(DeviceMaintain deviceMaintain) {
        QueryStatus queryStatus = new QueryStatus();
        DeviceMaintainExample deviceMaintainExample = new DeviceMaintainExample();
        DeviceMaintainExample.Criteria criteria = deviceMaintainExample.createCriteria();
        criteria.andDeviceMaintainIdEqualTo(deviceMaintain.getDeviceMaintainId());
        try {
            deviceMaintainMapper.updateByExample(deviceMaintain, deviceMaintainExample);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("修改失败，请重试");
        }
        return queryStatus;
    }


    //删除设备维修信息
    @Override
    public QueryStatus deleteDeviceMaintain(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();
        for (String id : ids) {
            try {
                deviceMaintainMapper.deleteByPrimaryKey(id);
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }catch (Exception e){
                queryStatus.setStatus(0);
                queryStatus.setMsg("删除失败，请重试");
            }
        }
        return queryStatus;
    }

    //根据设备维修编号搜索
    @Override
    public BaseResultVo queryDeviceMaintainById(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        BaseResultVo baseResultVo = new BaseResultVo();
        List<DeviceMaintain> deviceMaintainList= deviceMaintainMapper.queryDeviceMaintainById(searchValue);
        PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(deviceMaintainList);
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }

    @Override
    public BaseResultVo queryDeviceMaintainByDeviceFaultId(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        BaseResultVo baseResultVo = new BaseResultVo();
        List<DeviceMaintain> deviceMaintainList= deviceMaintainMapper.queryDeviceMaintainByDeviceFaultId(searchValue);
        PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(deviceMaintainList);
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }

    @Override
    public QueryStatus updateDeviceMaintainNote(DeviceMaintain deviceMaintain) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceMaintainMapper.updateDeviceMaintainNote(deviceMaintain);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新失败，请重试");
        }
        return queryStatus;
    }
}
