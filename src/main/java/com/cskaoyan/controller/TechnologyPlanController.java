package com.cskaoyan.controller;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyExample;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.service.TechnologyPlanService;
import com.cskaoyan.service.TechnologyService;
import com.cskaoyan.vo.Message;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/6/29 17:11
 */
@Controller
public class TechnologyPlanController {
    @Autowired
    TechnologyPlanService technologyPlanService;

    @Autowired
    TechnologyService technologyService;

    //
    @RequestMapping("technologyPlan/find")
    public String findTechnology() {
        return "technologyPlan_list";
    }

    @RequestMapping("technologyPlan/list")
    @ResponseBody
    public Vo<TechnologyPlan> returnTechnology(int page, int rows) {
        Vo<TechnologyPlan> technologyPlanVo = technologyPlanService.findTechnologyPlan(page, rows);
        return technologyPlanVo;
    }

    @RequestMapping("technologyPlan/add_judge")
    @ResponseBody
    public String addJudge() {
        return "";
    }

    @RequestMapping("technologyPlan/add")
    public String add() {
        return "technologyPlan_add";
    }

    @RequestMapping("technologyPlan/insert")
    @ResponseBody
    public Message insert (TechnologyPlan technologyPlan) {
        int insert = technologyPlanService.insert(technologyPlan);
        //new Message是应为要返回一个message给它
        Message message = new Message();
        message.setStatus(200);
        message.setMsg("OK");
        message.setData("success");
        return message;

    }

    //添加时候的下拉列表
    @RequestMapping("technology/get_data")
    @ResponseBody
    public List<Technology> getdata() {
        //Example 以下语句查询全部，TechnologyExample
        List<Technology> technology = technologyService.selectByExample(new TechnologyExample());
        return  technology;
    }




    //删除

    @RequestMapping("technologyPlan/delete_judge")
    @ResponseBody
    public void deleteJudge() {

    }


    @RequestMapping("technologyPlan/delete_batch")
    @ResponseBody
    //数组String是应为id是string类型
    public Message deletebatch(String[] ids) {
        for (String id : ids) {
            int i = technologyPlanService.deleteByPrimaryKey(id);
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

    //修改
    @RequestMapping("technologyPlan/edit_judge")
    @ResponseBody
    public void edit() {

    }

    @RequestMapping("technologyPlan/edit")
    public String technologyRequire() {
        return "technologyPlan_edit";
    }

    @RequestMapping("technologyPlan/update_all")
    @ResponseBody
    public Message update (TechnologyPlan technologyPlan) {
        int i = technologyPlanService.updateByPrimaryKey(technologyPlan);
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

    //搜索
    @RequestMapping("technologyPlan/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public Vo<TechnologyPlan> findTechnologyPlanId(int page, int rows, String searchValue) {
        Vo<TechnologyPlan> technologyPlanVo = technologyPlanService.findTechnologyPlanId(page, rows, searchValue);
        return technologyPlanVo;
    }


    //通过工艺名称查询
    @RequestMapping("technologyPlan/search_technologyPlan_by_technologyName")
    @ResponseBody
    public Vo<TechnologyPlan> selectByTechnologyName(int page, int rows, String searchValue) {
        Vo<TechnologyPlan> technologyPlanVo = technologyPlanService.selectByTechnologyName(page, rows, searchValue);
        return technologyPlanVo;
    }




    //寻找单个工艺计划,回显
    @RequestMapping("technologyPlan/get/{technologyPlanId}")
    @ResponseBody
    public  TechnologyPlan serchTechnologyPlanById(@PathVariable("technologyPlanId") String technologyPlanId) {
       TechnologyPlan technologyPlan = technologyPlanService.serchTechnologyPlanById(technologyPlanId) ;
        return technologyPlan;
    }
}
