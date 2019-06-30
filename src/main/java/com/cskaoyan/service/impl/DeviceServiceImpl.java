package com.cskaoyan.service.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.service.DeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cskaoyan.mapper.DeviceMapper;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    //查询所有设备信息
    @Override
    public BaseResultVo queryDeviceList(int rows, int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        PageHelper.startPage(page, rows);
        List<Device> devicesList = deviceMapper.queryDeviceList();
        PageInfo<Device> pageInfo = new PageInfo<>(devicesList);
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }

    //新增设备信息
    @Override
    public QueryStatus insertDevice(Device device) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceMapper.insert(device);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("插入失败，请重试");
        }
        return queryStatus;
    }


    //其他设备模块需要设备信息
    @Override
    public List<Device> queryDeviceListData() {
        DeviceExample deviceExample = new DeviceExample();
        List<Device> deviceList = deviceMapper.selectByExample(deviceExample);
        return deviceList;
    }

    //修改设备信息
    @Override
    public QueryStatus updateDevice(Device device) {
        QueryStatus queryStatus = new QueryStatus();
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceIdEqualTo(device.getDeviceId());
        try {
            deviceMapper.updateByExample(device, deviceExample);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("修改失败，请重试");
        }
        return queryStatus;
    }

    //删除设备
    @Override
    public QueryStatus deleteDevice(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();
        for (String id : ids) {
            try {
                deviceMapper.deleteByPrimaryKey(id);
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }catch (Exception e){
                queryStatus.setStatus(0);
                queryStatus.setMsg("删除失败，请重试");
            }
        }
        return queryStatus;
    }

    //按照设备Id查询
    @Override
    public BaseResultVo queryDeviceById(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        BaseResultVo baseResultVo = new BaseResultVo();
        List<Device> deviceList = deviceMapper.queryDeviceById(searchValue);
        PageInfo<Device> pageInfo = new PageInfo<>(deviceList);
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }

    //按照设备名称查询
    @Override
    public BaseResultVo queryDeviceByName(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        BaseResultVo baseResultVo = new BaseResultVo();
        List<Device> deviceList = deviceMapper.queryDeviceByName(searchValue);
        PageInfo<Device> pageInfo = new PageInfo<>(deviceList);
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }

    //按照设备种类名称查询
    @Override
    public BaseResultVo queryDeviceByDeviceTypeName(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        BaseResultVo baseResultVo = new BaseResultVo();
        List<Device> deviceList = deviceMapper.queryDeviceByDeviceTypeName(searchValue);
        PageInfo<Device> pageInfo = new PageInfo<>(deviceList);
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }

    //获取一个设备信息
    @Override
    public Device queryOneDeviceById(String deviceid) {
        Device device = deviceMapper.selectByPrimaryKey(deviceid);
        return device;
    }

    //修改设备备注
    @Override
    public QueryStatus updateDeviceNote(Device device) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceMapper.updateDeviceNote(device);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新失败，请重试");
        }
        return queryStatus;
    }


}
