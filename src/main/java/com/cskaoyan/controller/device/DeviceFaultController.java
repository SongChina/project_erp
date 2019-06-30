package com.cskaoyan.controller.device;


import com.cskaoyan.bean.*;
import com.cskaoyan.service.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeviceFaultController {

    @Autowired
    DeviceFaultService deviceFaultService;

    //显示所有设备故障信息
    @RequestMapping("deviceFault/list")
    @ResponseBody
    public BaseResultVo getDeviceFaultList(int page, int rows){
        BaseResultVo baseResultVo = deviceFaultService.queryDeviceFaultList(page, rows);
        return baseResultVo;
    }

    //新增设备故障信息
    @RequestMapping("deviceFault/add_judge")
    @ResponseBody
    public BaseResultVo deviceFaultAdd(){
        return new BaseResultVo();
    }

    @RequestMapping("deviceFault/add")
    public String tpDeviceFaultAdd(){
        return "deviceFault_add";
    }

    @RequestMapping("deviceFault/insert")
    @ResponseBody
    public QueryStatus deviceFaultInsert(DeviceFault deviceFault){
        QueryStatus queryStatus = deviceFaultService.deviceFaultInsert(deviceFault);
        return queryStatus;
    }

    //编辑设备故障信息
    @RequestMapping("deviceFault/edit_judge")
    @ResponseBody
    public BaseResultVo deviceFaultEdit(){
        return new BaseResultVo();
    }

    @RequestMapping("deviceFault/edit")
    public String toDeviceFaultEdit(){
        return "deviceFault_edit";
    }

    @RequestMapping(value = {"deviceFault/update", "deviceFault/update_all"})
    @ResponseBody
    public QueryStatus updateDeviceFault(DeviceFault deviceFault){
        QueryStatus queryStatus = deviceFaultService.updateDeviceFault(deviceFault);
        return queryStatus;
    }

    //修改故障描述
    @RequestMapping("deviceFault/update_note")
    @ResponseBody
    public QueryStatus updateDeviceFaultDetail(DeviceFault deviceFault){
        QueryStatus queryStatus = deviceFaultService.updateDeviceFaultDetail(deviceFault);
        return queryStatus;
    }


    //删除设备故障信息
    @RequestMapping("deviceFault/delete_judge")
    @ResponseBody
    public BaseResultVo deviceFaultDelete(){
        return new BaseResultVo();
    }


    @RequestMapping("deviceFault/delete_batch")
    @ResponseBody
    public QueryStatus deleteDeviceFault(String[] ids){
        QueryStatus queryStatus = deviceFaultService.deleteDeviceFault(ids);
        return queryStatus;
    }

    //根据设备故障编号搜索
    @RequestMapping("deviceFault/search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public BaseResultVo search_deviceFault_by_deviceFaultId(int page, int rows, String searchValue){
        BaseResultVo baseResultVo = deviceFaultService.queryDeviceFaultById(page, rows, searchValue);
        return baseResultVo;
    }

    //根据设备名称搜索设备故障信息
    @RequestMapping("deviceFault/search_deviceFault_by_deviceName")
    @ResponseBody
    public BaseResultVo search_deviceFault_by_deviceName(int page, int rows, String searchValue){
        BaseResultVo baseResultVo = deviceFaultService.queryDeviceFaultByDeviceName(page, rows, searchValue);
        return baseResultVo;
    }

    //Rest风格获取设备故障信息
    @RequestMapping("deviceFault/get/{deviceFaultId}")
    @ResponseBody
    public DeviceFault getDeviceFault(@PathVariable("deviceFaultId") String deviceFaultId){
        DeviceFault deviceFault = deviceFaultService.queryOneDeviceFaultById(deviceFaultId);
        return deviceFault;
    }
}
