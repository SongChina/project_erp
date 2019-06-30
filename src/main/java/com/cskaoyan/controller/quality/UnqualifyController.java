package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.service.impl.UnqualifyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("unqualify")
public class UnqualifyController {

    @Autowired
    UnqualifyServiceImpl unqualifyServiceimpl;

    @RequestMapping("/find")
    public String find(){
        return "unqualify_list";
    }

    //分页
    @RequestMapping("/list")
    @ResponseBody
    public Object getUnqualifyApplyPaging(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        List<UnqualifyApply> list = unqualifyServiceimpl.getUnqualifyApply();
        return list;
    }

    //增
    @RequestMapping("/add_judge")
    @ResponseBody
    public String add_judge(){ return ""; }
    @RequestMapping("/add")
    public String add() {
        return "unqualify_add";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public QueryStatus insert(UnqualifyApply unqualifyApply){
        return unqualifyServiceimpl.insert(unqualifyApply);
    }

    //删除
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String delete_judgee(){
        return "";
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public QueryStatus delete_batch(String[] ids){
        return unqualifyServiceimpl.delete_batch(ids);
    }

    //查id
    @RequestMapping("/search_unqualify_by_unqualifyId")
    @ResponseBody
    public Object searchUnqualifyByUnqualifyId(String searchValue, @RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        List<UnqualifyApply> list = unqualifyServiceimpl.searchUnqualifyByUnqualifyId(searchValue);
        return list;
    }
    //查name
    @RequestMapping("/search_unqualify_by_productName")
    @ResponseBody
    public Object searchUnqualifyByPAgeByProductName(String searchValue, @RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        List<UnqualifyApply> list = unqualifyServiceimpl.searchUnqualifyByPAgeByProductName(searchValue);
        return list;
    }

    //改
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String edit_judge(){ return ""; }
    @RequestMapping("/edit")
    public String edit(){
        return "unqualify_edit";
    }
    //修改全部信息
    @RequestMapping("/update_all")
    @ResponseBody
    public QueryStatus update_all(UnqualifyApply unqualifyApply){
        return unqualifyServiceimpl.update_all(unqualifyApply);
    }
    //改note
    @RequestMapping("/update_note")
    @ResponseBody
    public QueryStatus update_note(String unqualifyApplyId, String note){
        return unqualifyServiceimpl.update_note(unqualifyApplyId,note);
    }
}
