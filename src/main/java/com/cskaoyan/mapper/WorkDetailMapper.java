package com.cskaoyan.mapper;

import com.cskaoyan.bean.COrderDetail;
import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.WorkDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkDetailMapper {
    List<WorkDetail> queryWorkDetailByPage(@Param("limit") int limit, @Param("offset") int offset);

    List<WorkDetail> queryWorkByWorkIdInPage(@Param("searchValue") String searchValue, @Param("limit") int limit, @Param("offset") int offset);

    List<WorkDetail> queryWorkByProcessIdInPage(@Param("searchValue") String searchValue, @Param("limit") int limit, @Param("offset") int offset);
}
