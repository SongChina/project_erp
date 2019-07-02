package com.cskaoyan.service;

import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.bean.MaterialReceive2;

import java.util.List;

public interface MaterialReceiveService {
    int getReceiveTotal();

    int insert(MaterialReceive2 materialReceive);
    int deleteReceiveByIds(String[] ids);
    int updateReceive(MaterialReceive2 materialReceive);
    MaterialReceive selectById(String receiveId);

    List<MaterialReceive> selectAll();
    List<MaterialReceive> queryReceivesByPage(int page, int pageSize);
    List<MaterialReceive> queryReceiveById(String searchValue, int page, int pageSize);
    List<MaterialReceive> queryAllReceiveById(String searchValue);

    List<MaterialReceive> queryReceiveByMaterialId(String searchValue, int page, int pageSize);
    List<MaterialReceive> queryAllReceiveByMaterialId(String searchValue);

}
