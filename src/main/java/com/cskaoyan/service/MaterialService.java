package com.cskaoyan.service;

import com.cskaoyan.bean.Material;

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
