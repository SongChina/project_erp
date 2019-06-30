package com.cskaoyan.mapper;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.MaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialMapper {
    long countByExample(MaterialExample example);

    int deleteByExample(MaterialExample example);

    int deleteByPrimaryKey(String materialId);

    int deleteByIds(@Param("ids") String[] ids);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByExample(MaterialExample example);

    Material selectByPrimaryKey(String materialId);

    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    int updateByMaterial(@Param("material") Material material);
    List<Material> selectAll();
    List<Material> selectByPage(@Param("pageSize") int pageSize, @Param("offset") int offset);
    List<Material> queryMaterialById(@Param("materialId") String searchValue, @Param("pageSize") int pageSize, @Param("offset") int offset);
    List<Material> queryAllMaterialById(@Param("materialId") String searchValue);

    List<Material> queryMaterialByType(@Param("materialType") String searchValue, @Param("pageSize") int pageSize, @Param("offset") int offset);
    List<Material> queryAllMaterialByType(@Param("materialType") String searchValue);


}