package com.cskaoyan.controller.device;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeviceMaintainController {

    @Autowired
    DeviceMaintainService deviceMaintainService;

    //显示所有设备维修信息
    @RequestMapping("deviceMaintain/list")
    @ResponseBody
    public BaseResultVo getDeivceMaintainList(int page, int rows){
        BaseResultVo baseResultVo = deviceMaintainService.getDeivceMaintainList(page, rows);
        return baseResultVo;
    }

    //新增设备维修信息
    @RequestMapping("deviceMaintain/add_judge")
    @ResponseBody
    public BaseResultVo deviceMaintainAdd(){
        return new BaseResultVo();
    }

    @RequestMapping("deviceMaintain/add")
    public String tpDeviceMaintainAdd(){
        return "deviceMaintain_add";
    }

    @RequestMapping("deviceMaintain/insert")
    @ResponseBody
    public QueryStatus deviceMaintainInsert(DeviceMaintain deviceMaintain){
        QueryStatus queryStatus = deviceMaintainService.deviceMaintainInsert(deviceMaintain);
        return queryStatus;
    }

    //编辑设备维修信息
    @RequestMapping("deviceMaintain/edit_judge")
    @ResponseBody
    public BaseResultVo deviceMaintainEdit(){
        return new BaseResultVo();
    }

    @RequestMapping("deviceMaintain/edit")
    public String toDeviceMaintainEdit(){
        return "deviceMaintain_edit";
    }

    @RequestMapping("deviceMaintain/update")
    @ResponseBody
    public QueryStatus updateDeviceMaintain(DeviceMaintain deviceMaintain){
        QueryStatus queryStatus = deviceMaintainService.updateDeviceMaintain(deviceMaintain);
        return queryStatus;
    }

    //修改维修备注
    @RequestMapping("deviceMaintain/update_note")
    @ResponseBody
    public QueryStatus updateDeviceMaintainNote(DeviceMaintain deviceMaintain){
        QueryStatus queryStatus = deviceMaintainService.updateDeviceMaintainNote(deviceMaintain);
        return queryStatus;
    }

    //删除设备维修信息
    @RequestMapping("deviceMaintain/delete_judge")
    @ResponseBody
    public BaseResultVo deviceMaintainDelete(){
        return new BaseResultVo();
    }


    @RequestMapping("deviceMaintain/delete_batch")
    @ResponseBody
    public QueryStatus deleteDeviceMaintain(String[] ids){
        QueryStatus queryStatus = deviceMaintainService.deleteDeviceMaintain(ids);
        return queryStatus;
    }

    //根据设备维修编号搜索
    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public BaseResultVo search_deviceMaintain_by_deviceMaintainId(int page, int rows, String searchValue){
        BaseResultVo baseResultVo = deviceMaintainService.queryDeviceMaintainById(page, rows, searchValue);
        return baseResultVo;
    }

    //根据故障编号搜索设备维修信息
    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public BaseResultVo search_deviceMaintain_by_deviceFaultId(int page, int rows, String searchValue){
        BaseResultVo baseResultVo = deviceMaintainService.queryDeviceMaintainByDeviceFaultId(page, rows, searchValue);
        return baseResultVo;
    }
}
