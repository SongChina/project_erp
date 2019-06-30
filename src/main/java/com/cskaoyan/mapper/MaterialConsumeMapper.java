package com.cskaoyan.mapper;


import com.cskaoyan.bean.MaterialConsume;
import com.cskaoyan.bean.MaterialConsumeExample;
import java.util.List;


import org.apache.ibatis.annotations.Param;


public interface MaterialConsumeMapper {
    long countByExample();

    int deleteByExample(MaterialConsumeExample example);

    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsume record);



    List<MaterialConsume> selectByExample(MaterialConsumeExample example);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByExampleSelective(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByExample(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByPrimaryKey(MaterialConsume record);

    int insertSelective(MaterialConsume record);//增
    int deleteByIds(@Param("ids") String[] ids);//删
    int update(MaterialConsume record);//改

    //查
    List<MaterialConsume> selectAll();
    List<MaterialConsume> selectByPage(@Param("pageSize") int pageSize, @Param("offset") int offset);
    List<MaterialConsume> queryConsumeById(@Param("consumeId") String searchValue, @Param("pageSize") int pageSize, @Param("offset") int offset);
    List<MaterialConsume> queryAllConsumeById(@Param("consumeId") String searchValue);

    List<MaterialConsume> queryConsumeByMaterialId(@Param("materialId") String searchValue, @Param("pageSize") int pageSize, @Param("offset") int offset);
    List<MaterialConsume> queryAllConsumeByMaterialId(@Param("materialId") String searchValue);

    List<MaterialConsume> queryConsumeByWorkId(@Param("workId") String searchValue, @Param("pageSize") int pageSize, @Param("offset") int offset);
    List<MaterialConsume> queryAllConsumeByWorkId(@Param("workId") String searchValue);


}