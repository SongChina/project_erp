package com.cskaoyan.controller.device;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DeviceTypeController {

    @Autowired
    DeviceTypeService deviceTypeService;

    //显示设备种类
    @RequestMapping("deviceType/list")
    @ResponseBody
    public BaseResultVo getDeivceTypeListPaging(int page, int rows){
        BaseResultVo baseResultVo = deviceTypeService.getDeivceTypeList(page, rows);
        return baseResultVo;
    }
    //新增种类

    @RequestMapping("deviceType/add_judge")
    @ResponseBody
    public BaseResultVo deviceTypeAdd(){
        return new BaseResultVo();
    }

    @RequestMapping("deviceType/add")
    public String toDeviceTypeAdd(){
        return "deviceType_add";
    }

    @RequestMapping("deviceType/insert")
    @ResponseBody
    public QueryStatus insertDeviceType(DeviceType deviceType){
        QueryStatus queryStatus = deviceTypeService.insertDeviceType(deviceType);
        return queryStatus;
    }

    //编辑设备种类
    @RequestMapping("deviceType/edit_judge")
    @ResponseBody
    public BaseResultVo deviceTypeDelete(){
        return new BaseResultVo();
    }

    @RequestMapping("deviceType/edit")
    public String toDeviceTypeEdit(){
        return "deviceType_edit";
    }

    @RequestMapping(value = {"deviceType/update", "deviceType/update_all"})
    @ResponseBody
    public QueryStatus updateDeviceType(DeviceType deviceType){
        QueryStatus queryStatus = deviceTypeService.updateDeviceType(deviceType);
        return queryStatus;
    }

    //删除设备种类
    @RequestMapping("deviceType/delete_judge")
    @ResponseBody
    public BaseResultVo deviceTypeEdit(){
        return new BaseResultVo();
    }


    @RequestMapping("deviceType/delete_batch")
    @ResponseBody
    public QueryStatus deleteDeviceType(String[] ids){
        QueryStatus queryStatus = deviceTypeService.deleteDeviceType(ids);
        return queryStatus;
    }

    //根据设备种类ID搜索
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public BaseResultVo search_deviceType_by_deviceTypeId(int page, int rows, String searchValue){
        BaseResultVo baseResultVo = deviceTypeService.queryDeviceTypeById(page, rows, searchValue);
        return baseResultVo;
    }
    //根据设备种类名称搜索
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public BaseResultVo search_deviceType_by_deviceTypeName(int page, int rows, String searchValue){
        BaseResultVo baseResultVo = deviceTypeService.queryDeviceTypeByName(page, rows, searchValue);
        return baseResultVo;
    }

    //其他设备模块需要用到的设备种类
    @RequestMapping("deviceType/get_data")
    @ResponseBody
    public DeviceType[] getDeviceTypeList(){
        DeviceType[] deviceTypes = deviceTypeService.queryDeviceTypeIdAndName();
        return deviceTypes;
    }
    //Rest风格获取设备种类
    @RequestMapping("deviceType/get/{devicetyepid}")
    @ResponseBody
    public DeviceType getDeviceTypeList(@PathVariable("devicetyepid") String devicetyepid){
        DeviceType deviceType = deviceTypeService.queryOneDeviceTypeById(devicetyepid);
        return deviceType;
    }
}
