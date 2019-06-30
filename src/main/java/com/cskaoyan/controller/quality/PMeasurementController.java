package com.cskaoyan.controller.quality;


import com.cskaoyan.bean.ProcessMeasureCheck;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.impl.PMeasurementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PMeasurementController {

    @Autowired
    PMeasurementServiceImpl pMeasurementServiceImpl;


    @RequestMapping("p_measure_check/find")
    public String find(){
        return "p_measure_check_list";
    }

    //分页
    @RequestMapping("p_measure_check/list")
    @ResponseBody
    public Object getUnqualifyApplyPaging(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        List<ProcessMeasureCheck> list = pMeasurementServiceImpl.getProcessMeasureCheck();
        return list;
    }

    //增
    @RequestMapping("pMeasureCheck/add_judge")
    @ResponseBody
    public String add_judge(){ return ""; }
    @RequestMapping("p_measure_check/add")
    public String add() {
        return "p_measure_check_add";
    }
    @RequestMapping("/p_measure_check/insert")
    @ResponseBody
    public QueryStatus insert(ProcessMeasureCheck processMeasureCheck){
        return pMeasurementServiceImpl.insert(processMeasureCheck);
    }

    //删除
    @RequestMapping("/pMeasureCheck/delete_judge")
    @ResponseBody
    public String deleteJudgee(){
        return "";
    }
    @RequestMapping("/p_measure_check/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids){
        return pMeasurementServiceImpl.delete_batch(ids);
    }

    //查id
    @RequestMapping("/p_measure_check/search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public Object searchById(String searchValue, @RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        List<ProcessMeasureCheck> list = pMeasurementServiceImpl.searchById(searchValue);
        return list;
    }

    //改
    @RequestMapping("/pMeasureCheck/edit_judge")
    @ResponseBody
    public String  edit_judge(){return "";}
    @RequestMapping("/p_measure_check/edit")
    public String edit(){
        return "p_measure_check_edit";
    }
    //修改全部信息
    @RequestMapping("/p_measure_check/update_all")
    @ResponseBody
    public QueryStatus updateAll(ProcessMeasureCheck pMeasureCheck) {
        return pMeasurementServiceImpl.updateAll(pMeasureCheck);
    }

    //改note
    @RequestMapping("/p_measure_check/update_note")
    @ResponseBody
    public QueryStatus update_note(String pMeasureCheckId, String note){
        return pMeasurementServiceImpl.updateNote(pMeasureCheckId,note);
    }
}
