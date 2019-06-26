package com.cskaoyan.service.impl;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.bean.COrderExample;
import com.cskaoyan.mapper.COrderMapper;
import com.cskaoyan.service.COrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("corderServiceImpl")
public class COrderServiceImpl implements COrderService {
    @Autowired
    COrderMapper cOrderMapper;
    @Override
    public List<COrder> queryCOrdersByPage(int page, int pageSize) {
        cOrderMapper.selectByPage(page,pageSize);
        return null;
    }
}
