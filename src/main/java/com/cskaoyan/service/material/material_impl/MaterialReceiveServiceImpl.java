package com.cskaoyan.service.material.material_impl;

import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.mapper.MaterialReceiveMapper;
import com.cskaoyan.service.material.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;

    @Override
    public int getReceiveTotal() {
        long total = materialReceiveMapper.countByExample();
        return (int) total;
    }

    @Override
    public int insert(MaterialReceive materialReceive) {
        int i = materialReceiveMapper.insertSelective(materialReceive);
        return i;
    }

    @Override
    public int deleteReceiveByIds(String[] ids) {
        int delete = materialReceiveMapper.deleteByIds(ids);
        return delete;
    }

    @Override
    public int updateReceive(MaterialReceive materialReceive) {
        int update = materialReceiveMapper.update(materialReceive);
        return update;
    }

    @Override
    public MaterialReceive selectById(String receiveId) {
        MaterialReceive materialReceive = materialReceiveMapper.selectByPrimaryKey(receiveId);
        return materialReceive;
    }

    @Override
    public List<MaterialReceive> selectAll() {
        List<MaterialReceive> all = materialReceiveMapper.selectAll();
        return all;
    }

    @Override
    public List<MaterialReceive> queryReceivesByPage(int page, int pageSize) {
        int offset = (int) Math.ceil(pageSize*(page-1));
        List<MaterialReceive> list = materialReceiveMapper.selectByPage(pageSize, offset);
        return list;
    }

    @Override
    public List<MaterialReceive> queryReceiveById(String searchValue, int page, int pageSize) {
        int offset = (int) Math.ceil(pageSize*(page-1));
        String receiveId = "%"+searchValue+"%";
        return materialReceiveMapper.queryReceiveById(receiveId,pageSize,offset);
    }

    @Override
    public List<MaterialReceive> queryAllReceiveById(String searchValue) {
        String receiveId = "%"+searchValue+"%";
        return materialReceiveMapper.queryAllReceiveById(receiveId);
    }

    @Override
    public List<MaterialReceive> queryReceiveByMaterialId(String searchValue, int page, int pageSize) {
        String materialId = "%"+searchValue+"%";
        int offset = (int) Math.ceil(pageSize*(page-1));
        return materialReceiveMapper.queryReceiveByMaterialId(materialId,pageSize,offset);
    }

    @Override
    public List<MaterialReceive> queryAllReceiveByMaterialId(String searchValue) {
        String materialId = "%"+searchValue+"%";
        return materialReceiveMapper.queryAllReceiveByMaterialId(materialId);
    }
}
