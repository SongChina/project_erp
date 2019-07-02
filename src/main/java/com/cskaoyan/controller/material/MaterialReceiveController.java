package com.cskaoyan.controller.material;

import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.bean.MaterialReceive2;
import com.cskaoyan.service.MaterialReceiveService;
import com.cskaoyan.vo.materialVo.ResponseVo;
import com.cskaoyan.vo.materialVo.StatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("materialReceive")
public class MaterialReceiveController {
    @Autowired
    MaterialReceiveService materialReceiveService;

    @RequestMapping("find")
    public String getReceivePage() {
        return "materialReceive_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<MaterialReceive> getReceiveList(int page, int rows) {
        int total = (int) materialReceiveService.getReceiveTotal();
        List<MaterialReceive> receivelist = materialReceiveService.queryReceivesByPage(page, rows);
        ResponseVo<MaterialReceive> ResponseVo = new ResponseVo<>();
        ResponseVo.setTotal(total);
        ResponseVo.setRows(receivelist);
        return ResponseVo;
    }

    //增
    @RequestMapping("add_judge")
    @ResponseBody
    public String addjudge() {
        return "{}";
    }

    @RequestMapping("add")
    public String getAddPage() {
        return "materialReceive_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public StatusVo add(MaterialReceive2 materialReceive) {
        StatusVo statusVo = new StatusVo();
        try {
            materialReceiveService.insert(materialReceive);
            statusVo.setStatus(200);
            statusVo.setMsg("OK");
            statusVo.setData(null);
            return statusVo;
        } catch (Exception e) {
            e.printStackTrace();
            statusVo.setStatus(0);
            statusVo.setMsg("该物料收入编号已经存在，请重新输入编号！");
            statusVo.setData(null);
            return statusVo;
        }

    }

    //删
    @RequestMapping("delete_judge")
    @ResponseBody
    public String deletejudge() {
        return "{}";
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public StatusVo delete(String[] ids) {
        StatusVo statusVo = new StatusVo();
        try {
            materialReceiveService.deleteReceiveByIds(ids);
            statusVo.setStatus(200);
            statusVo.setMsg("OK");
            statusVo.setData(null);
            return statusVo;
        } catch (Exception e) {
            e.printStackTrace();
            statusVo.setStatus(0);
            statusVo.setMsg("删除失败！（请刷新再查看）");
            statusVo.setData(null);
            return statusVo;
        }
    }

    //改
    @RequestMapping("edit_judge")
    @ResponseBody
    public String editjudge() {
        return "{}";
    }

    @RequestMapping("edit")
    public String getEditPage() {
        return "materialReceive_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public StatusVo update(MaterialReceive2 materialReceive) {
        StatusVo statusVo = new StatusVo();
        try {
            materialReceiveService.updateReceive(materialReceive);
            statusVo.setStatus(200);
            statusVo.setMsg("OK");
            statusVo.setData(null);
            return statusVo;
        } catch (Exception e) {
            e.printStackTrace();
            statusVo.setStatus(101);
            statusVo.setMsg("修改物料收入信息失败");
            statusVo.setData(null);
            return statusVo;
        }
    }

    //消耗编号查找
    @RequestMapping("search_materialReceive_by_receiveId")
    @ResponseBody
    public ResponseVo<MaterialReceive> queryById(String searchValue, int page, int rows) {
        List<MaterialReceive> list = materialReceiveService.queryReceiveById(searchValue, page, rows);
        int total = materialReceiveService.queryAllReceiveById(searchValue).size();
        ResponseVo<MaterialReceive> responseVo = new ResponseVo<>();
        responseVo.setTotal(total);
        responseVo.setRows(list);
        return responseVo;
    }

    //物料编号查找
    @RequestMapping("search_materialReceive_by_materialId")
    @ResponseBody
    public ResponseVo<MaterialReceive> queryByMaterialId(String searchValue, int page, int rows) {
        List<MaterialReceive> list = materialReceiveService.queryReceiveByMaterialId(searchValue, page, rows);
        int total = materialReceiveService.queryAllReceiveByMaterialId(searchValue).size();
        ResponseVo<MaterialReceive> responseVo = new ResponseVo<>();
        responseVo.setTotal(total);
        responseVo.setRows(list);
        return responseVo;
    }


    //详情备注修改update_note
    @RequestMapping("update_note")
    @ResponseBody
    public StatusVo updateNote(MaterialReceive2 materialRecvive) {
        return update(materialRecvive);
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<MaterialReceive> materialReceiveGetData() {
        List<MaterialReceive> all = materialReceiveService.selectAll();
        return all;
    }
}
