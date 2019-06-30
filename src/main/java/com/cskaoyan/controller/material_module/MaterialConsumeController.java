package com.cskaoyan.controller.material_module;

import com.cskaoyan.bean.MaterialConsume;

import com.cskaoyan.mapper.MaterialConsumeMapper;

import com.cskaoyan.service.material.MaterialConsumeService;
import com.cskaoyan.vo.material_vo.ResponseVo;
import com.cskaoyan.vo.material_vo.StatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("materialConsume")
public class MaterialConsumeController {
    @Autowired
    MaterialConsumeService materialConsumeService;
    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @RequestMapping("find")
    public String getConsumePage() {
        return "materialConsume_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public com.cskaoyan.vo.material_vo.ResponseVo<MaterialConsume> getConsumeList(int page, int rows) {
        int total = (int) materialConsumeService.getConsumeTotal();
        List<MaterialConsume> consomelist = materialConsumeService.queryConsumesByPage(page, rows);
        com.cskaoyan.vo.material_vo.ResponseVo<MaterialConsume> ResponseVo = new com.cskaoyan.vo.material_vo.ResponseVo<>();
        ResponseVo.setTotal(total);
        ResponseVo.setRows(consomelist);
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
        return "materialConsume_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public StatusVo add(MaterialConsume materialConsume) {
        StatusVo statusVo = new StatusVo();
        try {
            materialConsumeService.insert(materialConsume);
            statusVo.setStatus(200);
            statusVo.setMsg("OK");
            statusVo.setData(null);
            return statusVo;
        } catch (Exception e) {
            e.printStackTrace();
            statusVo.setStatus(0);
            statusVo.setMsg("该物料消耗编号已经存在，请重新输入编号！");
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
            materialConsumeService.deleteConsumeByIds(ids);
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
        return "materialConsume_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public StatusVo update(MaterialConsume materialConsume) {
        StatusVo statusVo = new StatusVo();
        try {
            materialConsumeService.updateConsume(materialConsume);
            statusVo.setStatus(200);
            statusVo.setMsg("OK");
            statusVo.setData(null);
            return statusVo;
        } catch (Exception e) {
            e.printStackTrace();
            statusVo.setStatus(101);
            statusVo.setMsg("修改物料消耗备注失败");
            statusVo.setData(null);
            return statusVo;
        }
    }

    //消耗编号查找
    @RequestMapping("search_materialConsume_by_consumeId")
    @ResponseBody
    public ResponseVo<MaterialConsume> queryById(String searchValue, int page, int rows) {
        List<MaterialConsume> consumes = materialConsumeService.queryConsumeById(searchValue, page, rows);
        int total = materialConsumeService.queryAllConsumeById(searchValue).size();
        ResponseVo<MaterialConsume> responseVo = new ResponseVo<>();
        responseVo.setTotal(total);
        responseVo.setRows(consumes);
        return responseVo;
    }

    //物料编号查找
    @RequestMapping("search_materialConsume_by_materialId")
    @ResponseBody
    public ResponseVo<MaterialConsume> queryByMaterialId(String searchValue, int page, int rows) {
        List<MaterialConsume> consumes = materialConsumeService.queryConsumeByMaterialId(searchValue, page, rows);
        int total = materialConsumeService.queryAllConsumeByMaterialId(searchValue).size();
        ResponseVo<MaterialConsume> responseVo = new ResponseVo<>();
        responseVo.setTotal(total);
        responseVo.setRows(consumes);
        return responseVo;
    }

    //作业编号查找
    @RequestMapping("search_materialConsume_by_workId")
    @ResponseBody
    public ResponseVo<MaterialConsume> queryByWorkId(String searchValue, int page, int rows) {
        List<MaterialConsume> consumes = materialConsumeService.queryConsumeByWorkId(searchValue, page, rows);
        int total = materialConsumeService.queryAllConsumeByWorkId(searchValue).size();
        ResponseVo<MaterialConsume> responseVo = new ResponseVo<>();
        responseVo.setTotal(total);
        responseVo.setRows(consumes);
        return responseVo;
    }

    //详情备注修改update_note
    @RequestMapping("update_note")
    @ResponseBody
    public StatusVo updateNote(MaterialConsume material) {
        return update(material);
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<MaterialConsume> materialConsumeGetData() {
        List<MaterialConsume> all = materialConsumeService.selectAll();
        return all;
    }

}
