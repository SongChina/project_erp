package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.ProcessCountCheck;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.impl.PCountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PCountController {

    @Autowired
    PCountServiceImpl pCountServiceIml;
    @RequestMapping("p_count_check/find")
    public String find(){
        return "p_count_check_list";
    }

    //分页
    @RequestMapping("p_count_check/list")
    @ResponseBody
    public Object getUnqualifyApplyPaging(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        List<ProcessCountCheck> list = pCountServiceIml.getProcessCountCheck();
        return list;
    }

    //增
    @RequestMapping("pCountCheck/add_judge")
    @ResponseBody
    public String add_judge(){ return ""; }
    @RequestMapping("p_count_check/add")
    public String add() { return "p_count_check_add"; }
    @RequestMapping("/p_count_check/insert")
    @ResponseBody
    public QueryStatus insert(ProcessCountCheck processCountCheck) {
        return pCountServiceIml.insert(processCountCheck);
    }

    //删除
    @RequestMapping("/pCountCheck/delete_judge")
    @ResponseBody
    public String deleteJudgee() {
        return "";
    }
    @RequestMapping("/p_count_check/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids) {
        return pCountServiceIml.delete_batch(ids);
    }

    //查id
    @RequestMapping("/p_count_check/search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public Object searchById(String searchValue, @RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        List<ProcessCountCheck> list = pCountServiceIml.searchById(searchValue);
        return list;
    }

    //改
    @RequestMapping("/pCountCheck/edit_judge")
    @ResponseBody
    public String edit_judge() {
        return "";
    }
    @RequestMapping("/p_count_check/edit")
    public String edit() {
        return "p_count_check_edit";
    }
    //修改全部信息
    @RequestMapping("/p_count_check/update_all")
    @ResponseBody
    public QueryStatus updateAll(ProcessCountCheck pCountCheck) {
        return pCountServiceIml.updateAll(pCountCheck);
    }
    //改note
    @RequestMapping("/p_count_check/update_note")
    @ResponseBody
    public QueryStatus update_note(String pCountCheckId, String note) {
        return pCountServiceIml.updateNote(pCountCheckId, note);
    }
}
