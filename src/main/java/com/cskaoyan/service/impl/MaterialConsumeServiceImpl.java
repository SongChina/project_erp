package com.cskaoyan.service.impl;

import com.cskaoyan.bean.MaterialConsume;
import com.cskaoyan.bean.MaterialConsume2;
import com.cskaoyan.mapper.MaterialConsumeMapper;
import com.cskaoyan.service.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {

    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Override
    public int getConsumeTotal() {
        long total = materialConsumeMapper.countByExample();
        return (int) total;
    }


    @Override
    public int insert(MaterialConsume2 materialConsume) {
        int i = materialConsumeMapper.insertSelective(materialConsume);
        return i;
    }

    @Override
    public int deleteConsumeByIds(String[] ids) {
        int delete = materialConsumeMapper.deleteByIds(ids);
        return delete;
    }

    @Override
    public int updateConsume(MaterialConsume2 materialConsume) {
        int update = materialConsumeMapper.update(materialConsume);
        return update;
    }

    @Override
    public MaterialConsume selectById(String consumeId) {
        MaterialConsume materialConsume = materialConsumeMapper.selectByPrimaryKey(consumeId);
        return materialConsume;
    }

    @Override
    public List<MaterialConsume> selectAll() {
        List<MaterialConsume> all = materialConsumeMapper.selectAll();
        return all;
    }

    @Override
    public List<MaterialConsume> queryConsumesByPage(int page, int pageSize) {
        int offset = (int) Math.ceil(pageSize*(page-1));
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectByPage( pageSize,offset);
        return materialConsumes;
    }

    @Override
    public List<MaterialConsume> queryConsumeById(String searchValue, int page, int pageSize) {
        int offset = (int) Math.ceil(pageSize*(page-1));
        String consemeId = "%"+searchValue+"%";
        return materialConsumeMapper.queryConsumeById(consemeId,pageSize,offset);
    }

    @Override
    public List<MaterialConsume> queryAllConsumeById(String searchValue) {
        String consemeId = "%"+searchValue+"%";
        return materialConsumeMapper.queryAllConsumeById(consemeId);
    }

    @Override
    public List<MaterialConsume> queryConsumeByMaterialId(String searchValue, int page, int pageSize) {
        int offset = (int) Math.ceil(pageSize*(page-1));
        String materialId = "%"+searchValue+"%";
        return materialConsumeMapper.queryConsumeByMaterialId(materialId,pageSize,offset);
    }

    @Override
    public List<MaterialConsume> queryAllConsumeByMaterialId(String searchValue) {
        String materialId = "%"+searchValue+"%";
        return materialConsumeMapper.queryAllConsumeByMaterialId(materialId);
    }

    @Override
    public List<MaterialConsume> queryConsumeByWorkId(String searchValue, int page, int pageSize) {
        int offset = (int) Math.ceil(pageSize*(page-1));
        String workId = "%"+searchValue+"%";
        return materialConsumeMapper.queryConsumeByWorkId(workId,pageSize,offset);
    }

    @Override
    public List<MaterialConsume> queryAllConsumeByWorkId(String searchValue) {
        String workId = "%"+searchValue+"%";
        return materialConsumeMapper.queryAllConsumeByWorkId(workId);
    }


}
