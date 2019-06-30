package com.cskaoyan.controller;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyExample;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.bean.TechnologyRequirementExample;
import com.cskaoyan.service.TechnologyRequirementService;
import com.cskaoyan.service.TechnologyService;
import com.cskaoyan.vo.Message;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/6/29 17:32
 */

@Controller
public class TechnologyRequirementController {
    @Autowired
    TechnologyRequirementService technologyRequirementService;

    @Autowired
    TechnologyService technologyService;


    @RequestMapping("technologyRequirement/find")
    public String findTechnology() {
        return "technologyRequirement_list";
    }

    @RequestMapping("technologyRequirement/list")
    @ResponseBody
    public Vo<TechnologyRequirement> returnTechnology(int page, int rows) {
        Vo<TechnologyRequirement> technologyRequirementVo = technologyRequirementService.findTechnologyRequirement(page, rows);
        return technologyRequirementVo;
    }

    @RequestMapping("technologyRequirement/add_judge")
    @ResponseBody
    public String addJudge() {
        return "";
    }
    @RequestMapping("technologyRequirement/add")
    public String add() {
        return "technologyRequirement_add";
    }

    @RequestMapping("technologyRequirement/insert")
    @ResponseBody
    public Message insert (TechnologyRequirement technologyRequirement) {
        int insert = technologyRequirementService.insert(technologyRequirement);
        //new Message是应为要返回一个message给它
        Message message = new Message();
        message.setStatus(200);
        message.setMsg("OK");
        message.setData(null);
        return message;
    }


    @RequestMapping("technologyRequirement/delete_judge")
    @ResponseBody
    public void deleteJudge() {

    }
 /*   public Vo deleteJudge() {
        return new Vo() ;
    }
*/
    @RequestMapping("technologyRequirement/delete_batch")
    @ResponseBody
    //数组String是应为id是string类型
    public Message deletebatch(String[] ids) {
        for (String id : ids) {
            int i = technologyRequirementService.deleteByPrimaryKey(id);
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

    //这个添加时候的下拉列表。工艺名称在technology里面
    @RequestMapping("technologyRequirement/get_data")
    @ResponseBody
    public List<Technology> getdata() {
        //Example 以下语句查询全部，TechnologyExample
        List<Technology> technology = technologyService.selectByExample(new TechnologyExample());
        return  technology;
    }


    @RequestMapping("technologyRequirement/edit_judge")
    @ResponseBody
    public void edit() {

    }

    @RequestMapping("technologyRequirement/edit")
    public String technologyRequire() {
        return "technologyRequirement_edit";
    }

    @RequestMapping("technologyRequirement/update_all")
    @ResponseBody
    public Message update (TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementService.updateByPrimaryKey(technologyRequirement);
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

    //通过工艺列表搜索
    @RequestMapping("technologyRequirement/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public Vo<TechnologyRequirement> serchRequirementTechnologyId(int page, int rows, String searchValue) {
        Vo<TechnologyRequirement> technologyRequirementVo = technologyRequirementService.SerchTechnologyRequirementId(page, rows, searchValue);
        return technologyRequirementVo;
    }





    //通过工艺名称查询
    @RequestMapping("technologyRequirement/search_technologyRequirement_by_technologyName")
    @ResponseBody
    public Vo<TechnologyRequirement> selectByTechnologyName(int page, int rows, String searchValue) {
        Vo<TechnologyRequirement> technologyRequirementVo = technologyRequirementService.selectByTechnologyName(page, rows, searchValue);
        return technologyRequirementVo;
    }



}


