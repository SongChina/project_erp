package com.cskaoyan.service;

import com.cskaoyan.bean.MaterialConsume;
import com.cskaoyan.bean.MaterialConsume2;

import java.util.List;

public interface MaterialConsumeService {
    int getConsumeTotal();
    //List<MaterialConsume> getConsumeList();

    int insert(MaterialConsume2 materialConsume);
    int deleteConsumeByIds(String[] ids);
    int updateConsume(MaterialConsume2 materialConsume);
    MaterialConsume selectById(String consumeId);

    List<MaterialConsume> selectAll();
    List<MaterialConsume> queryConsumesByPage(int page, int pageSize);
    List<MaterialConsume> queryConsumeById(String searchValue, int page, int pageSize);
    List<MaterialConsume> queryAllConsumeById(String searchValue);

    List<MaterialConsume> queryConsumeByMaterialId(String searchValue, int page, int pageSize);
    List<MaterialConsume> queryAllConsumeByMaterialId(String searchValue);
    List<MaterialConsume>queryConsumeByWorkId(String searchValue, int page, int pageSize);
    List<MaterialConsume>queryAllConsumeByWorkId(String searchValue);


}
