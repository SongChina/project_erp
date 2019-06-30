package com.cskaoyan.service;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.bean.TechnologyPlanExample;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.vo.Vo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/6/29 17:12
 */
public interface TechnologyPlanService {
    Vo<TechnologyPlan> findTechnologyPlan(int page, int rows);
    //寻找单个工艺计划，回显
    TechnologyPlan serchTechnologyPlanById(String technologyPlanId);

    Vo<TechnologyPlan> findTechnologyPlanId(int page, int rows, String searchValue);

    //按工艺名称搜索
    Vo<TechnologyPlan> selectByTechnologyName(int page, int rows, String searchValue);

    //以上是新增的
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
