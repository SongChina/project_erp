package com.cskaoyan.service.material;

import com.cskaoyan.bean.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialService {
    int getMaterialTotal();

    //List<Material> getMaterialList();

    int deleteMaterialByIds(String[] ids);

    int insert(Material material);


    Material selectById(String materialId);
    int updateMaterial(Material material);
    List<Material> selectAll();
    List<Material> queryMaterialsByPage(int page, int pageSize);
    List<Material> queryMaterialById(String searchValue, int page, int pageSize);
    List<Material> queryAllMaterialById(String searchValue);

    List<Material> queryMaterialByType(String searchValue, int page, int pageSize);
    List<Material> queryAllMaterialByType(String searchValue);
}
