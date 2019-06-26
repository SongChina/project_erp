package com.cskaoyan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class DeviceListController {

    @RequestMapping("device/deviceList")
    public String deviceList(){
        return "deviceList";
    }
}
