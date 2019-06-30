package com.cskaoyan.controller.plan_module;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.vo.COrderResponseVo;
import com.cskaoyan.vo.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomController1 {
    @Autowired
    CustomMapper customMapper;

    @RequestMapping("custom/find")
    public ModelAndView findCustomByPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("custom_list");
        return modelAndView;
    }

    @RequestMapping("custom/list")
    @ResponseBody
    public COrderResponseVo<Custom> fillOrderDataPaging(@RequestParam("page") Integer page,
                                                              @RequestParam("rows") Integer rows) {
        int limit = rows;
        int offset = (page - 1) * rows;
        List<Custom> customs = customMapper.queryCustomByPage(limit, offset);
        COrderResponseVo<Custom> result = new COrderResponseVo<>();
        result.setTotal(11);
        result.setRows(customs);
        return result;
    }

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
    @RequestMapping("custom/add")
    public ModelAndView getCustomAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("custom_add");
        return modelAndView;
    }

    @RequestMapping("custom/edit")
    public ModelAndView getCustomEditPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("custom_edit");
        return modelAndView;
    }




    @RequestMapping("custom/insert")
    @ResponseBody
    public Object insertCustom(Custom custom) {
        Message message = new Message();
        Custom temp = customMapper.selectByPrimaryKey(custom.getCustomId());
        if (temp != null) {
            message.setStatus(400);
            return message;
        }

        int insert = customMapper.insert(custom);
        if (insert > 0) {
            message.setStatus(200);
            message.setMsg("OK");
        }
        return message;
    }


    @RequestMapping("custom/*_judge")
    @ResponseBody
    public String getNothing2() {
        return "{}";
    }


    @RequestMapping("custom/delete_batch")
    public Message deletecustom(String[] ids) {

        Message message = new Message();
        ArrayList<String> idsList = new ArrayList<>();
        for (String id : ids) {
            idsList.add(id);
        }

        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomIdIn(idsList);

        int i = customMapper.deleteByExample(customExample);
        message.setStatus(200);
        message.setMsg("OK");
        return message;
    }

/*    @ResponseBody
    @RequestMapping("custom/update_all")
    public Message update(Custom custom){
        Message message = new Message();
        int i = customMapper.updateByPrimaryKey(custom);
        if(i > 0){
            message.setStatus(200);
            message.setMsg("OK");
        }
        return message;
    }*/
    @RequestMapping("custom/update_note")
    @ResponseBody
    public Message updateCOrderNote(String note, String orderId){
        Message message = new Message();
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        List<String> customIds = new ArrayList<>();
        customIds.add(orderId);
        criteria.andCustomIdIn(customIds);

        Custom custom = new Custom();
        custom.setNote(note);

        int i = customMapper.updateByExampleSelective(custom, customExample);
        if(i > 0){
            message.setStatus(200);
            message.setMsg("OK");
        }
        return message;
    }

    @RequestMapping("custom/search_custom_by_customId")
    @ResponseBody
    public COrderResponseVo<Custom> getCustomByCustomId(@Param("searchValue") String searchValue,
                                                           @Param("page") int page, @Param("rows") int rows){
        int limit = rows;
        int offset = (page - 1) * rows;
        List<Custom> customs = customMapper.queryCustomByCustomIdInPage("%" + searchValue + "%", limit, offset);

        COrderResponseVo<Custom> result = new COrderResponseVo<>();
        result.setTotal(11);
        result.setRows(customs);
        return result;
    }

    @RequestMapping("custom/search_custom_by_customName")
    @ResponseBody
    public COrderResponseVo<Custom> getCustomByCustomName(@Param("searchValue") String searchValue,
                                                        @Param("page") int page, @Param("rows") int rows){
        int limit = rows;
        int offset = (page - 1) * rows;
        List<Custom> customs = customMapper.queryCustomByCustomNameInPage("%" + searchValue + "%", limit, offset);

        COrderResponseVo<Custom> result = new COrderResponseVo<>();
        result.setTotal(11);
        result.setRows(customs);
        return result;
    }


}
