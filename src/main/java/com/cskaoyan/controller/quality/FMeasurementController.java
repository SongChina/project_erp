package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.FinalMeasuretCheck;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.impl.FMeasurementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FMeasurementController {

    @Autowired
    FMeasurementServiceImpl fMeasurementServiceImpl;

    @RequestMapping("measure/find")
    public String find(){
        return "measurement_list";
    }

    //分页
    @RequestMapping("measure/list")
    @ResponseBody
    public Object getUnqualifyApplyPaging(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        List<FinalMeasuretCheck> list = fMeasurementServiceImpl.getFinalMeasuretCheck();
        return list;
    }

    //增（未完）
    @RequestMapping("fMeasureCheck/add_judge")
    @ResponseBody
    public String add_judge(){ return ""; }
    @RequestMapping("measure/add")
    public String add() { return "measurement_add"; }
    @RequestMapping("measure/insert")
    @ResponseBody
    public QueryStatus insert(FinalMeasuretCheck finalMeasuretCheck){
        return fMeasurementServiceImpl.insert(finalMeasuretCheck);
    }

    //删除
    @RequestMapping("/fMeasureCheck/delete_judge")
    @ResponseBody
    public String delete_judgee(){
        return "";
    }
    @RequestMapping("/measure/delete_batch")
    @ResponseBody
    public QueryStatus delete_batch(String[] ids){
        return fMeasurementServiceImpl.delete_batch(ids);
    }

    //查id
    @RequestMapping("measure/search_fMeasureCheck_by_fMeasureCheckId")
    @ResponseBody
    public Object searchfCountCheckByfCountCheckId(String searchValue, @RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        List<FinalMeasuretCheck> list = fMeasurementServiceImpl.searchfMeasureCheckByfMeasureCheckId(searchValue);
        return list;
    }
    //查orderID
    @RequestMapping("measure/search_fMeasureCheck_by_orderId")
    @ResponseBody
    public Object searchfMeasureCheckByOrderId(String searchValue, @RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        List<FinalMeasuretCheck> list = fMeasurementServiceImpl.searchfMeasureCheckByOrderId(searchValue);
        return list;
    }

    //改
    @RequestMapping("fMeasureCheck/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }
    @RequestMapping("/measure/edit")
    public String edit(){
        return "measurement_edit";
    }
    //修改全部信息
    @RequestMapping("measure/update_all")
    @ResponseBody
    public QueryStatus update_all(FinalMeasuretCheck finalMeasuretCheck) {
        return fMeasurementServiceImpl.update_all(finalMeasuretCheck);
    }
    //改note
    @RequestMapping("/measure/update_note")
    @ResponseBody
    public QueryStatus update_note(String fMeasureCheckId, String note){
        return fMeasurementServiceImpl.update_note(fMeasureCheckId,note);
    }
}
