package com.cskaoyan.mapper;

import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.bean.UnqualifyApplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnqualifyApplyMapper {
    long countByExample(UnqualifyApplyExample example);

    int deleteByExample(UnqualifyApplyExample example);

    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    List<UnqualifyApply> selectByExample(UnqualifyApplyExample example);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByExampleSelective(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByExample(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);

    List<UnqualifyApply> selectUnqualifyApply();

    List<UnqualifyApply> searchUnqualifyByUnqualifyId(@Param("searchValue") String searchValue);
    List<UnqualifyApply> searchUnqualifyByPAgeByProductName(@Param("searchValue") String searchValue);

    int update_note(@Param("unqualifyApplyId") String unqualifyApplyId, @Param("note") String note);
    int update_all(@Param("unqualify") UnqualifyApply unqualifyApply);

}