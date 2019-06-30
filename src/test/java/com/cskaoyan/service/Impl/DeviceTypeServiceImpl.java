package com.cskaoyan.service.Impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.DeviceTypeMapper;
import com.cskaoyan.service.DeviceTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    //获取所有设备种类
    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    @Override
    public BaseResultVo getDeivceTypeList(int page, int rows) {
        PageHelper.startPage(page, rows);
        BaseResultVo baseResultVo = new BaseResultVo();
        List<DeviceType> deviceTypeList = deviceTypeMapper.queryDeviceTypeList();
        PageInfo<DeviceType> pageInfo = new PageInfo<>(deviceTypeList);
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }

    //插入设备种类
    @Override
    public QueryStatus insertDeviceType(DeviceType deviceType) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceTypeMapper.insert(deviceType);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("插入失败，请重试");
        }
        return queryStatus;
    }

    //修改设备种类信息
    @Override
    public QueryStatus updateDeviceType(DeviceType deviceType) {
        QueryStatus queryStatus = new QueryStatus();
        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceTypeExample.createCriteria();
        criteria.andDeviceTypeIdEqualTo(deviceType.getDeviceTypeId());
        try {
            deviceTypeMapper.updateByExample(deviceType, deviceTypeExample);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("修改失败，请重试");
        }
        return queryStatus;
    }

    //删除设备种类
    @Override
    public QueryStatus deleteDeviceType(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();
        for (String id : ids) {
            try {
                deviceTypeMapper.deleteByPrimaryKey(id);
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }catch (Exception e){
                queryStatus.setStatus(0);
                queryStatus.setMsg("删除失败，请重试");
            }
        }
        return queryStatus;
    }

    //按设备种类Id查询
    @Override
    public BaseResultVo queryDeviceTypeById(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        BaseResultVo baseResultVo = new BaseResultVo();
        List<DeviceType> deviceTypeList = deviceTypeMapper.queryDeviceTypeById(searchValue);
        PageInfo<DeviceType> pageInfo = new PageInfo<>(deviceTypeList);
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }

    //按设备种类名称查询
    @Override
    public BaseResultVo queryDeviceTypeByName(int page, int rows, String searchValue) {
        /*PageHelper.startPage(page, rows);
        BaseResultVo baseResultVo = new BaseResultVo();
        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceTypeExample.createCriteria();
        criteria.andDeviceTypeNameLike("%" + searchValue + "%");
        List<DeviceType> deviceTypeList = deviceTypeMapper.selectByExample(deviceTypeExample);
        int total = (int) deviceTypeMapper.countByExample(deviceTypeExample);
        baseResultVo.setRows(deviceTypeList);
        baseResultVo.setTotal(total);
        return baseResultVo;*/
        PageHelper.startPage(page, rows);
        BaseResultVo baseResultVo = new BaseResultVo();
        List<DeviceType> deviceTypeList = deviceTypeMapper.queryDeviceTypeByName(searchValue);
        PageInfo<DeviceType> pageInfo = new PageInfo<>(deviceTypeList);
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }

    //查询设备种类id和name
    @Override
    public DeviceType[] queryDeviceTypeIdAndName() {
        DeviceType[] deviceTypes = deviceTypeMapper.queryDeviceTypeIdAndName();
        return deviceTypes;
    }

    //查询一个设备种类
    @Override
    public DeviceType queryOneDeviceTypeById(String devicetyepid) {
        DeviceType deviceType = deviceTypeMapper.selectByPrimaryKey(devicetyepid);
        return deviceType;
    }
}
