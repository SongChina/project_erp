package com.cskaoyan.controller.device;

import com.cskaoyan.bean.*;
import com.cskaoyan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller
public class DeviceListController {

    @Autowired
    DeviceService deviceService;

    //显示设备
    @RequestMapping("deviceList/list")
    @ResponseBody
    public BaseResultVo getDeviceList(int rows, int page){
        BaseResultVo baseResultVo = deviceService.queryDeviceList(rows, page);
        return baseResultVo;
    }

    //新增（未完成,缺少employee信息）
    @RequestMapping("deviceList/add_judge")
    @ResponseBody
    public BaseResultVo add_judge(){
        return new BaseResultVo();
    }

    @RequestMapping("deviceList/add")
    public String add(){
        return "deviceList_add";
    }


    @RequestMapping("deviceList/insert")
    @ResponseBody
    public QueryStatus insertDevice(Device device){
        QueryStatus queryStatus = deviceService.insertDevice(device);
        return queryStatus;
    }

    //修改设备信息
    @RequestMapping("deviceList/edit_judge")
    @ResponseBody
    public BaseResultVo edit_judge(){
        return new BaseResultVo();
    }

    @RequestMapping("deviceList/edit")
    public String deivceEdit(){
        return "deviceList_edit";
    }

    @RequestMapping(value = {"deviceList/update", "deviceList/update_all"})
    @ResponseBody
    public QueryStatus updateDevice(Device device){
        QueryStatus queryStatus = deviceService.updateDevice(device);
        return queryStatus;
    }

    //修改设备备注
    @RequestMapping("deviceList/update_note")
    @ResponseBody
    public QueryStatus updateDeviceNote(Device device){
        QueryStatus queryStatus = deviceService.updateDeviceNote(device);
        return queryStatus;
    }

    //删除
     @RequestMapping("deviceList/delete_judge")
     @ResponseBody
    public BaseResultVo delete_judge(){
        return new BaseResultVo();
    }

    @RequestMapping("deviceList/delete_batch")
    @ResponseBody
    public QueryStatus deleteDevice(String[] ids){
        QueryStatus queryStatus = deviceService.deleteDevice(ids);
        return queryStatus;
    }

    //获取设备信息
    @RequestMapping("deviceList/get_data")
    @ResponseBody
    public List<Device> getDeviceList(){
        List<Device> deviceList = deviceService.queryDeviceListData();
        return deviceList;
    }
    //根据设备编号搜索
    @RequestMapping("deviceList/search_device_by_deviceId")
    @ResponseBody
    public BaseResultVo search_device_by_deviceId(int page, int rows, String searchValue){
        BaseResultVo baseResultVo = deviceService.queryDeviceById(page, rows, searchValue);
        return baseResultVo;
    }
    //根据设备名称搜索
    @RequestMapping("deviceList/search_device_by_deviceName")
    @ResponseBody
    public BaseResultVo search_device_by_deviceName(int page, int rows, String searchValue){
        BaseResultVo baseResultVo = deviceService.queryDeviceByName(page, rows, searchValue);
        return baseResultVo;
    }

    //根据设备种类名称搜索
    @RequestMapping("deviceList/search_device_by_deviceTypeName")
    @ResponseBody
    public BaseResultVo search_device_by_deviceTypeName(int page, int rows, String searchValue){
        BaseResultVo baseResultVo = deviceService.queryDeviceByDeviceTypeName(page, rows, searchValue);
        return baseResultVo;
    }

    //Rest风格获取设备信息
    @RequestMapping("deviceList/get/{deviceid}")
    @ResponseBody
    public Device getDevice(@PathVariable("deviceid") String deviceid){
        Device device = deviceService.queryOneDeviceById(deviceid);
        return device;
    }

}
