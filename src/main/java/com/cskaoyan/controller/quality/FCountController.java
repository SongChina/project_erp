package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.FinalCountCheck;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.impl.FCountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FCountController {

    @Autowired
    FCountServiceImpl fCountServiceImpl;

    @RequestMapping("f_count_check/find")
    public String find(){
        return "f_count_check_list";
    }

    //分页
    @RequestMapping("f_count_check/list")
    @ResponseBody
    public Object getUnqualifyApplyPaging(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        List<FinalCountCheck> list = fCountServiceImpl.getFinalCountCheck();
        return list;
    }

    //增
    @RequestMapping("fCountCheck/add_judge")
    @ResponseBody
    public String add_judge(){ return ""; }
    @RequestMapping("f_count_check/add")
    public String add() { return "f_count_check_add"; }
    @RequestMapping("/f_count_check/insert")
    @ResponseBody
    public QueryStatus insert(FinalCountCheck finalCountCheck){
        return fCountServiceImpl.insert(finalCountCheck);
    }

    //删
    @RequestMapping("fCountCheck/delete_judge")
    @ResponseBody
    public String delete_judge(){return "";}
    @RequestMapping("f_count_check/delete_batch")
    @ResponseBody
    public QueryStatus delete_batch(String[] ids){return fCountServiceImpl.delete_batch(ids);}

    //查id
    @RequestMapping("f_count_check/search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public Object searchfCountCheckByfCountCheckId(String searchValue, @RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        List<FinalCountCheck> list = fCountServiceImpl.searchfCountCheckByfCountCheckId(searchValue);
        return list;
    }
    //查Orderid
    @RequestMapping("f_count_check/search_fCountCheck_by_orderId")
    @ResponseBody
    public Object searchfCountCheckByOrderId(String searchValue, @RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        List<FinalCountCheck> list = fCountServiceImpl.searchfCountCheckByOrderId(searchValue);
        return list;
    }

    //改
    @RequestMapping("/fCountCheck/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }
    @RequestMapping("/f_count_check/edit")
    public String edit(){
        return "f_count_check_edit";
    }
    @RequestMapping("/f_count_check/update_all")
    @ResponseBody
    public QueryStatus update_all(FinalCountCheck finalCountCheck) {
        return fCountServiceImpl.update_all(finalCountCheck);
    }
    //改note
    @RequestMapping("/f_count_check/update_note")
    @ResponseBody
    public QueryStatus update_note(String fCountCheckId, String note){
        return fCountServiceImpl.update_note(fCountCheckId,note);
    }
}
