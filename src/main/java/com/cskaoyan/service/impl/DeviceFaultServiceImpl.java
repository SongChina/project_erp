package com.cskaoyan.service.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.DeviceFaultMapper;
import com.cskaoyan.service.DeviceFaultService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper deviceFaultMapper;

    //查询所有设备故障信息
    @Override
    public BaseResultVo queryDeviceFaultList(int page, int rows) {

        PageHelper.startPage(page, rows);
        List<DeviceFault> deviceFaultList = deviceFaultMapper.queryDeviceFaultList();
        PageInfo<DeviceFault> pageInfo = new PageInfo<>(deviceFaultList);
        BaseResultVo baseResultVo = new BaseResultVo();
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }

    //插入设备故障信息
    @Override
    public QueryStatus deviceFaultInsert(DeviceFault deviceFault) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceFaultMapper.insert(deviceFault);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("插入失败，请重试");
        }
        return queryStatus;
    }

    //修改设备故障信息
    @Override
    public QueryStatus updateDeviceFault(DeviceFault deviceFault) {
        QueryStatus queryStatus = new QueryStatus();
        DeviceFaultExample deviceFaultExample = new DeviceFaultExample();
        DeviceFaultExample.Criteria criteria = deviceFaultExample.createCriteria();
        criteria.andDeviceFaultIdEqualTo(deviceFault.getDeviceFaultId());
        try {
            deviceFaultMapper.updateByExample(deviceFault,deviceFaultExample);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("修改失败，请重试");
        }
        return queryStatus;
    }

    //删除设备故障信息
    @Override
    public QueryStatus deleteDeviceFault(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();
        for (String id : ids) {
            try {
                deviceFaultMapper.deleteByPrimaryKey(id);
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }catch (Exception e){
                queryStatus.setStatus(0);
                queryStatus.setMsg("删除失败，请重试");
            }
        }
        return queryStatus;
    }

    //根据设备故障编号搜索
    @Override
    public BaseResultVo queryDeviceFaultById(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        BaseResultVo baseResultVo = new BaseResultVo();
        List<DeviceFault> deviceFaultList= deviceFaultMapper.queryDeviceFaultById(searchValue);
        PageInfo<DeviceFault> pageInfo = new PageInfo<>(deviceFaultList);
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }

    //根据设备名称搜索设备故障信息
    @Override
    public BaseResultVo queryDeviceFaultByDeviceName(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        BaseResultVo baseResultVo = new BaseResultVo();
        List<DeviceFault> deviceFaultList = deviceFaultMapper.queryDeviceFaultByDeviceName(searchValue);
        PageInfo<DeviceFault> pageInfo = new PageInfo<>(deviceFaultList);
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }

    //获取一条设备故障信息
    @Override
    public DeviceFault queryOneDeviceFaultById(String deviceFaultId) {
        DeviceFault deviceFault = deviceFaultMapper.selectByPrimaryKey(deviceFaultId);
        return deviceFault;
    }

    //修改故障描述
    @Override
    public QueryStatus updateDeviceFaultDetail(DeviceFault deviceFault) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceFaultMapper.updateDeviceFaultDetail(deviceFault);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新失败，请重试");
        }
        return queryStatus;
    }
}
