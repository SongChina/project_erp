package com.cskaoyan.mapper;

import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.bean.TechnologyRequirementExample;
import java.util.List;

import com.cskaoyan.vo.TechnologyRequirementVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface TechnologyRequirementMapper {


    //查询所有工艺要求
    List<TechnologyRequirement> findAllTechnologyRequirements();

    //通过工艺名称查询
    List<TechnologyRequirement> selectByTechnologyName(@Param("searchValue") String searchValue);


    //逆向工程生成
    long countByExample(TechnologyRequirementExample example);

    int deleteByExample(TechnologyRequirementExample example);

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    List<TechnologyRequirement> selectByExample(TechnologyRequirementExample example);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByExampleSelective(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByExample(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);



}