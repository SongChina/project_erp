package com.cskaoyan.controller.material;

import com.cskaoyan.bean.Material;
import com.cskaoyan.service.MaterialService;
import com.cskaoyan.vo.materialVo.ResponseVo;
import com.cskaoyan.vo.materialVo.StatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("material")
public class MaterialController {
    @Autowired
    MaterialService materialService;

    //StatusVo statusVo = new StatusVo();

    @RequestMapping("find")
    public String getMaterialPage() {
        return "material_list";

    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<Material> getMaterialList(int page, int rows) {
        int total = (int) materialService.getMaterialTotal();
        List<Material> materiallist = materialService.queryMaterialsByPage(page, rows);//new ArrayList<>();
        ResponseVo<Material> materialResponseVo = new ResponseVo<>();
        materialResponseVo.setTotal(total);
        materialResponseVo.setRows(materiallist);
        return materialResponseVo;

    }

    //增
    @RequestMapping("add_judge")
    @ResponseBody
    public String addjudge() {
        return "{}";
    }

    @RequestMapping("add")
    public String getAddPage() {
        return "material_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public StatusVo addMaterial(Material material) {
        StatusVo statusVo = new StatusVo();
        try {
            materialService.insert(material);
            statusVo.setStatus(200);
            statusVo.setMsg("OK");
            statusVo.setData(null);
            return statusVo;
        } catch (Exception e) {
            e.printStackTrace();
            statusVo.setStatus(0);
            statusVo.setMsg("该物料编号已经存在，请更换物料编号！");
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
    public StatusVo deleteMaterials(String[] ids) {
        StatusVo statusVo = new StatusVo();
        try {
            materialService.deleteMaterialByIds(ids);
            statusVo.setStatus(200);
            statusVo.setMsg("OK");
            statusVo.setData(null);
            return statusVo;
        } catch (Exception e) {
            e.printStackTrace();
            statusVo.setStatus(0);
            statusVo.setMsg("删除失败！（数据库已无此材料，请刷新再查看）");
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
        return "material_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public StatusVo updateMaterial(Material material) {
        StatusVo statusVo = new StatusVo();
        try {
            materialService.updateMaterial(material);
            statusVo.setStatus(200);
            statusVo.setMsg("OK");
            statusVo.setData(null);
            return statusVo;
        } catch (Exception e) {
            e.printStackTrace();
            statusVo.setStatus(0);
            statusVo.setMsg("修改失败，请重试！");
            statusVo.setData(null);
            return statusVo;
        }
    }

    //编号查找
    @RequestMapping("search_material_by_materialId")
    @ResponseBody
    public ResponseVo<Material> queryMaterialById(String searchValue, int page, int rows) {
        List<Material> materials = materialService.queryMaterialById(searchValue, page, rows);
        //int total = materials.size()错误，是页内个数，不是查询总个数！
        int total = materialService.queryAllMaterialById(searchValue).size();
        ResponseVo<Material> responseVo = new ResponseVo<>();
        responseVo.setTotal(total);
        responseVo.setRows(materials);
        return responseVo;
    }

    //类型查找
    @RequestMapping("search_material_by_materialType")
    @ResponseBody
    public ResponseVo<Material> queryMaterialByType(String searchValue, int page, int rows) {
        List<Material> materials = materialService.queryMaterialByType(searchValue, page, rows);
        int total = materialService.queryAllMaterialByType(searchValue).size();
        ResponseVo<Material> responseVo = new ResponseVo<>();
        responseVo.setTotal(total);
        responseVo.setRows(materials);
        return responseVo;
    }

    //详情备注修改update_note
    @RequestMapping("update_note")
    @ResponseBody
    public StatusVo materialUpdateNote(Material material) {
        return updateMaterial(material);
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<Material> materialGetData(){
        List<Material> all = materialService.selectAll();
        return all;
    }

    @RequestMapping("get/{materialId}")
    @ResponseBody
    public Material getMaterialrest(@PathVariable("materialId") String materialId){
        Material material = materialService.selectById(materialId);
        return material;
    }
}
