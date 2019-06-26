package com.cskaoyan.service;

import com.cskaoyan.bean.COrder;

import java.util.List;

public interface COrderService {
    List<COrder> queryCOrdersByPage(int page, int pageSize);
}
