package com.cskaoyan.mapper;

import com.cskaoyan.bean.MaterialConsumeExample;
import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.bean.MaterialReceive2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialReceiveMapper {
    long countByExample();

    int deleteByExample(MaterialConsumeExample example);

    int deleteByPrimaryKey(String consumeId);

    //int insert(MaterialReceive record);


   // List<MaterialReceive> selectByExample(MaterialConsumeExample example);

    MaterialReceive selectByPrimaryKey(String consumeId);//要用

   // int updateByExampleSelective(@Param("record") MaterialReceive record, @Param("example") MaterialConsumeExample example);

    //int updateByExample(@Param("record") MaterialReceive record, @Param("example") MaterialConsumeExample example);

    //int updateByPrimaryKey(MaterialReceive record);

    int insertSelective(MaterialReceive2 record);//增
    int deleteByIds(@Param("ids") String[] ids);//删
    int update(MaterialReceive2 record);//改

    //查
    List<MaterialReceive> selectAll();
    List<MaterialReceive> selectByPage(@Param("pageSize") int pageSize, @Param("offset") int offset);
    List<MaterialReceive> queryReceiveById(@Param("receiveId") String searchValue, @Param("pageSize") int pageSize, @Param("offset") int offset);
    List<MaterialReceive> queryAllReceiveById(@Param("receiveId") String searchValue);

    List<MaterialReceive> queryReceiveByMaterialId(@Param("materialId") String searchValue, @Param("pageSize") int pageSize, @Param("offset") int offset);
    List<MaterialReceive> queryAllReceiveByMaterialId(@Param("materialId") String searchValue);


}