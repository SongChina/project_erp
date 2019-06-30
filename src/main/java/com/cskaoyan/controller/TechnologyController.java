package com.cskaoyan.controller;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.service.TechnologyService;
import com.cskaoyan.vo.Message;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author AsidentVoice
 * @date 2019/6/29 16:12
 */
@Controller
public class TechnologyController {

    @Autowired
    TechnologyService technologyService;

    //工艺管理
    @RequestMapping("technology/find")
    public String findTechnology() {
        return "technology_list";
    }

    @RequestMapping("technology/list")
    @ResponseBody
    public Vo<Technology> returnTechnology(int page, int rows) {
        Vo<Technology> technologyVo = technologyService.findTechnology(page, rows);
        return technologyVo;
    }


	//添加方法
    @RequestMapping("technology/add_judge")
    @ResponseBody
    public String addJudge() {
        return "";
    }

    @RequestMapping("technology/add")
    public String add() {
        return "technology_add";
    }

    @RequestMapping("technology/insert")
    @ResponseBody
    public Message insert (Technology technology) {
        int insert = technologyService.insert(technology);
        //new Message是应为要返回一个message给它
        Message message = new Message();
        message.setStatus(200);
        message.setMsg("OK");
        message.setData(null);
        return message;
    }

	//删除方法
    @RequestMapping("technology/delete_judge")
    @ResponseBody
    public String deleteJudge() {
        return "";
    }


    @RequestMapping("technology/delete_batch")
    @ResponseBody
    //数组String是应为id是string类型
    public Message deletebatch(String[] ids) {
        for (String id : ids) {
            int i = technologyService.deleteByPrimaryKey(id);
            if( i != 1) {
                Message message = new Message();
                message.setData(null);
                message.setMsg("错误");
                message.setStatus(0);
                return  message;
            }
        }
        //如果删除成功
        Message message = new Message();
        message.setData(null);
        message.setMsg("OK");
        message.setStatus(200);
        return  message;
    }


	//修改方法
    @RequestMapping("technology/edit_judge")
    @ResponseBody
    public void edit() {

    }

    @RequestMapping("technology/edit")
    public String technologyedit() {
        return "technology_edit";
    }

    @RequestMapping("technology/update_all")
    @ResponseBody
    public Message update (Technology technology) {
        int i = technologyService.updateByPrimaryKey(technology);
        //new Message是应为要返回一个message给它
        if (i == 1) {
            Message message = new Message();
            message.setStatus(200);
            message.setMsg("OK");
            message.setData(null);
            return message;
        } else {
            Message message = new Message();
            message.setData(null);
            message.setMsg("错误");
            message.setStatus(0);
            return  message;
        }
    }
	
	//搜索方法

    @RequestMapping("technology/search_technology_by_technologyId")
    @ResponseBody
    public Vo<Technology> serchTechnologyId(int page, int rows, String searchValue) {
        Vo<Technology> technologyVo = technologyService.SerchTechnologyId(page, rows, searchValue);
        return technologyVo;
    }

    @RequestMapping("technology/search_technology_by_technologyName")
    @ResponseBody
    public Vo<Technology> serchTechnologyName(int page, int rows, String searchValue) {
        Vo<Technology> technologyVo = technologyService.SerchTechnologyName(page, rows, searchValue);
        return technologyVo;
    }

    //寻找单个工艺
    @RequestMapping("technology/get/{technologyId}")
    @ResponseBody
    public Technology serchTechnologyById(@PathVariable("technologyId") String technologyId) {
        Technology technology = technologyService.serchTechnologyById(technologyId);
        return technology;
    }
}
