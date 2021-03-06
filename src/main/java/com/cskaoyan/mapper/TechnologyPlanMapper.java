package com.cskaoyan.mapper;

import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.bean.TechnologyPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechnologyPlanMapper {

    //新增方法
    //查询所有工艺计划
    List<TechnologyPlan> findAllTechnologyPlan();

    //按工艺名称查询
    List<TechnologyPlan> selectByTechnologyName(@Param("searchValue") String searchValue);


    long countByExample(TechnologyPlanExample example);

    int deleteByExample(TechnologyPlanExample example);

    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    List<TechnologyPlan> selectByExample(TechnologyPlanExample example);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByExampleSelective(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByExample(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);



}