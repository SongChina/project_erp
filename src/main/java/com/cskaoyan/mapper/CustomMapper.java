package com.cskaoyan.mapper;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.CustomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomMapper {
    List<Custom> queryCustomByCustomIdInPage(@Param("searchValue") String searchValue, @Param("limit") int limit, @Param("offset") int offset);

    long countByExample(CustomExample example);

    int deleteByExample(CustomExample example);

    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    List<Custom> selectByExample(CustomExample example);

    Custom selectByPrimaryKey(String customId);

    int updateByExampleSelective(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByExample(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    List<Custom> queryAllCustom();

    List<Custom> queryCustomByPage(@Param("limit") int limit, @Param("offset") int offset);

    List<Custom> queryCustomByCustomNameInPage(@Param("searchValue") String searchValue, @Param("limit") int limit, @Param("offset") int offset);
}