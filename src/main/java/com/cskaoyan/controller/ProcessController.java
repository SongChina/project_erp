package com.cskaoyan.controller;

import com.cskaoyan.bean.Process;
import com.cskaoyan.bean.ProcessExample;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyExample;
import com.cskaoyan.service.ProcessService;
import com.cskaoyan.vo.Message;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/6/29 21:24
 */
@Controller
public class ProcessController {

    @Autowired
    ProcessService processService;

    //工序管理
    @RequestMapping("process/find")
    public String findProcess() {
        return "process_list";
    }

    @RequestMapping("process/list")
    @ResponseBody
    public Vo<Process> returnTechnology(int page, int rows) {
        Vo<Process> processVo = processService.findProcess(page, rows);
        return processVo;
    }

    //添加
    @RequestMapping("process/add_judge")
    @ResponseBody
    public String addjudge() {
        return "" ;
    }

    @RequestMapping("process/add")
    public  String add() {
        return "process_add";
    }

    @RequestMapping("process/insert")
    @ResponseBody
    public Message insert (Process process) {
        int insert = processService.insert(process);
        Message message = new Message();
        message.setStatus(200);
        message.setMsg("OK");
        message.setData(null);
        return message;

    }
    //这个添加时候的下拉列表。额外名称在其他里面时用
    @RequestMapping("technologyPlan/get_data")
    @ResponseBody
    public List<Process> getdata() {
        //Example 以下语句查询全部，TechnologyExample
        List<Process> processes = processService.selectByExample(new ProcessExample());
        return  processes;
    }

    //删除
    @RequestMapping("process/delete_judge")
    @ResponseBody
    public String deleteJudge() {
        return "";
    }

    @RequestMapping("process/delete_batch")
    @ResponseBody
    //数组String是应为id是string类型
    public Message deletebatch(String[] ids) {
        for (String id : ids) {
            int i = processService.deleteByPrimaryKey(id);
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
    @RequestMapping("process/edit_judge")
    @ResponseBody
    public void edit() {

    }

    @RequestMapping("process/edit")
    public String processedit() {
        return "process_edit";
    }


    @RequestMapping("process/update_all")
    @ResponseBody
    public Message update (Process process) {
        int i = processService.updateByPrimaryKey(process);
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
@RequestMapping("process/search_process_by_processId")
@ResponseBody
public Vo<Process> serch(int page, int rows, String searchValue) {
    Vo<Process> processVo = processService.SerchProcessId(page, rows, searchValue);
    return processVo;
    }

}
