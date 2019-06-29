package com.cskaoyan.mapper;

import com.cskaoyan.bean.COrderDetail;
import com.cskaoyan.bean.WorkDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkDetailMapper {
    List<WorkDetail> queryWorkDetailByPage(@Param("limit") int limit, @Param("offset") int offset);
}
