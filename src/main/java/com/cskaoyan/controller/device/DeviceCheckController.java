package com.cskaoyan.controller.device;

import com.cskaoyan.bean.*;
import com.cskaoyan.service.DeviceCheckService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeviceCheckController {

    @Autowired
    DeviceCheckService deviceCheckService;

    //显示所有设备例检数据
    @RequestMapping("deviceCheck/list")
    @ResponseBody
    public BaseResultVo getDeivceCheckList(int page, int rows){
        BaseResultVo baseResultVo = deviceCheckService.getDeivceCheckList(page, rows);
        return baseResultVo;
    }

    //新增例检数据
    @RequestMapping("deviceCheck/add_judge")
    @ResponseBody
    public BaseResultVo deviceCheckAdd(){
        return new BaseResultVo();
    }

    @RequestMapping("deviceCheck/add")
    public String toDeviceCheckAdd(){
        return "deviceCheck_add";
    }

    @RequestMapping("deviceCheck/insert")
    @ResponseBody
    public QueryStatus insertDeviceCheck(DeviceCheck deviceCheck){
        QueryStatus queryStatus = deviceCheckService.insertDeviceCheck(deviceCheck);
        return queryStatus;
    }

    //编辑设备例检数据
    @RequestMapping("deviceCheck/edit_judge")
    @ResponseBody
    public BaseResultVo deviceCheckEdit(){
        return new BaseResultVo();
    }

    @RequestMapping("deviceCheck/edit")
    public String toDeviceCheckEdit(){
        return "deviceCheck_edit";
    }

    @RequestMapping("deviceCheck/update")
    @ResponseBody
    public QueryStatus updateDeviceCheck(DeviceCheck deviceCheck){
        QueryStatus queryStatus = deviceCheckService.updateDeviceCheck(deviceCheck);
        return queryStatus;
    }


    //修改例检结果
    @RequestMapping("deviceCheck/update_note")
    @ResponseBody
    public QueryStatus updateDeviceCheckResult(DeviceCheck deviceCheck){
        QueryStatus queryStatus = deviceCheckService.updateDeviceCheckResult(deviceCheck);
        return queryStatus;
    }


    //删除设备例检数据
    @RequestMapping("deviceCheck/delete_judge")
    @ResponseBody
    public BaseResultVo deviceCheckDelete(){
        return new BaseResultVo();
    }


    @RequestMapping("deviceCheck/delete_batch")
    @ResponseBody
    public QueryStatus deleteDeviceCheck(String[] ids){
        QueryStatus queryStatus = deviceCheckService.deleteDeviceCheck(ids);
        return queryStatus;
    }

    //根据设备例检ID搜索
    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public BaseResultVo search_deviceCheck_by_deviceCheckId(int page, int rows, String searchValue){
        BaseResultVo baseResultVo = deviceCheckService.queryDeviceCheckById(page, rows, searchValue);
        return baseResultVo;
    }

    //根据设备名称搜索
    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceName")
    @ResponseBody
    public BaseResultVo search_deviceCheck_by_deviceName(int page, int rows, String searchValue){
        BaseResultVo baseResultVo = deviceCheckService.queryDeviceCheckByDeviceName(page, rows, searchValue);
        return baseResultVo;
    }
}
