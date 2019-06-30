package com.cskaoyan.service;


import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.bean.TechnologyRequirementExample;
import com.cskaoyan.vo.Vo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/6/29 17:30
 */
public interface TechnologyRequirementService {
    //工艺要求
    Vo<TechnologyRequirement> findTechnologyRequirement(int page, int rows);
    //根据工艺要求编号模糊查询
    Vo<TechnologyRequirement> SerchTechnologyRequirementId(int page, int rows, String searchValue);



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


    Vo<TechnologyRequirement> selectByTechnologyName(int page, int rows, String searchValue);
}
