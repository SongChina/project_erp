package com.cskaoyan.service.Impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.DeviceCheckMapper;
import com.cskaoyan.service.DeviceCheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

    @Autowired
    DeviceCheckMapper deviceCheckMapper;


    //查询所有设备例检信息
    @Override
    public BaseResultVo getDeivceCheckList(int page, int rows) {
       /* BaseResultVo baseResultVo = new BaseResultVo();
        DeviceCheckExample deviceCheckExample = new DeviceCheckExample();
        int total = (int) deviceCheckMapper.countByExample(deviceCheckExample);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Device> devicesList = deviceCheckMapper.queryDeviceCheckList(rows, offset);
        baseResultVo.setRows(devicesList);
        baseResultVo.setTotal(total);
        return baseResultVo;*/

        PageHelper.startPage(page, rows);
        BaseResultVo baseResultVo = new BaseResultVo();
        List<DeviceCheck> deviceCheckList = deviceCheckMapper.queryDeviceCheckList();
        PageInfo<DeviceCheck> pageInfo = new PageInfo<>(deviceCheckList);
        baseResultVo.setTotal((int) pageInfo.getTotal());
        baseResultVo.setRows(pageInfo.getList());
        return baseResultVo;
    }

    //插入设备例检信息
    @Override
    public QueryStatus insertDeviceCheck(DeviceCheck deviceCheck) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceCheckMapper.insert(deviceCheck);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("插入失败，请重试");
        }
        return queryStatus;
    }

    //修改设备例检信息
    @Override
    public QueryStatus updateDeviceCheck(DeviceCheck deviceCheck) {
        QueryStatus queryStatus = new QueryStatus();
        DeviceCheckExample deviceCheckExample = new DeviceCheckExample();
        DeviceCheckExample.Criteria criteria = deviceCheckExample.createCriteria();
        criteria.andDeviceCheckIdEqualTo(deviceCheck.getDeviceCheckId());
        try {
            deviceCheckMapper.updateByExample(deviceCheck, deviceCheckExample);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("修改失败，请重试");
        }
        return queryStatus;
    }
    //删除设备例检数据
    @Override
    public QueryStatus deleteDeviceCheck(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();
        for (String id : ids) {
            try {
                deviceCheckMapper.deleteByPrimaryKey(id);
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }catch (Exception e){
                queryStatus.setStatus(0);
                queryStatus.setMsg("删除失败，请重试");
            }
        }
        return queryStatus;
    }
    //按照设备例检数据Id查询
    @Override
    public BaseResultVo queryDeviceCheckById(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        BaseResultVo baseResultVo = new BaseResultVo();
        List<DeviceCheck> deviceCheckList = deviceCheckMapper.queryDeviceCheckById(searchValue);
        PageInfo<DeviceCheck> pageInfo = new PageInfo<>(deviceCheckList);
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }
    //按照设备名称查询
    @Override
    public BaseResultVo queryDeviceCheckByDeviceName(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        BaseResultVo baseResultVo = new BaseResultVo();
        List<DeviceCheck> deviceCheckList = deviceCheckMapper.queryDeviceCheckByDeviceName(searchValue);
        PageInfo<DeviceCheck> pageInfo = new PageInfo<>(deviceCheckList);
        baseResultVo.setRows(pageInfo.getList());
        baseResultVo.setTotal((int) pageInfo.getTotal());
        return baseResultVo;
    }

    //修改例检结果
    @Override
    public QueryStatus updateDeviceCheckResult(DeviceCheck deviceCheck) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceCheckMapper.updateDeviceCheckResult(deviceCheck);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新失败，请重试");
        }
        return queryStatus;

    }


}

