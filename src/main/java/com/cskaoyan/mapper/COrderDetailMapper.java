package com.cskaoyan.mapper;

import com.cskaoyan.bean.COrderDetail;
import com.cskaoyan.bean.Custom;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface COrderDetailMapper{
    List<COrderDetail> queryCOrderDetailByPage(@Param("limit") int limit, @Param("offset") int offset);
    Custom selectCustomByPrimaryKey(String customId);

}
