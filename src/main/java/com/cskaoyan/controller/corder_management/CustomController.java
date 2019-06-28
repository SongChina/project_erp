package com.cskaoyan.controller.corder_management;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomController {
    @Autowired
    CustomMapper customMapper;

    @RequestMapping("custom/get_data")
    @ResponseBody
    public List<Custom> getAllCustom() {
        List<Custom> customs = customMapper.queryAllCustom();
        return customs;

    }

    @ResponseBody
    @RequestMapping("custom/update_all")
    public Message updateCustom(Custom custom){
        Message message = new Message();
        int i = customMapper.updateByPrimaryKey(custom);
        if(i > 0){
            message.setStatus(200);
            message.setMsg("OK");
        }
        return message;
    }

    /*    @RequestMapping("queryUser/id/{myid}/{name}")*/
    @RequestMapping("custom/get/{customId}")
    @ResponseBody
    public Custom getSingleCustom(@PathVariable("customId") String customId){
        Custom custom = customMapper.selectByPrimaryKey(customId);
        return custom;
    }

}
