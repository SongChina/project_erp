package com.cskaoyan.service.impl;


import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.MaterialExample;
import com.cskaoyan.mapper.MaterialMapper;
import com.cskaoyan.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    @Override
    public int getMaterialTotal() {
        int total = (int)materialMapper.countByExample(new MaterialExample());
        return total;
    }


    @Override
    public List<Material> selectAll() {
        return materialMapper.selectAll();
    }

    @Override
    public List<Material> queryMaterialsByPage(int page, int pageSize) {
        int offset = (int) Math.ceil(pageSize*(page-1));
        List<Material> materials = materialMapper.selectByPage( pageSize,offset);
        return materials;
    }
    @Override
    public List<Material> queryMaterialById(String searchValue, int page, int pageSize) {
        int offset = (int) Math.ceil(pageSize*(page-1));
        String materialId = "%"+searchValue+"%";
        return materialMapper.queryMaterialById(materialId,pageSize,offset);
    }

    @Override
    public List<Material> queryMaterialByType(String searchValue, int page, int pageSize) {
        int offset = (int) Math.ceil(pageSize*(page-1));
        String materialType = "%"+searchValue+"%";
        return materialMapper.queryMaterialByType(materialType,pageSize,offset);
    }

    @Override
    public List<Material> queryAllMaterialById(String searchValue) {
        String materialId = "%"+searchValue+"%";
        return materialMapper.queryAllMaterialById(materialId);
    }

    @Override
    public List<Material> queryAllMaterialByType(String searchValue) {
        String materialType = "%"+searchValue+"%";
        return materialMapper.queryAllMaterialByType(materialType);
    }

    @Override
    public int insert(Material material) {
        int insert = materialMapper.insert(material);
        return insert;
    }

    @Override
    public int deleteMaterialByIds(String[] ids) {
        int delete = materialMapper.deleteByIds(ids);
        return delete;
    }

    @Override
    public Material selectById(String materialId) {
        Material material = materialMapper.selectByPrimaryKey(materialId);
        return material;
    }

    @Override
    public int updateMaterial(Material material) {
        int i = materialMapper.updateByMaterial(material);
        return i;
    }


}