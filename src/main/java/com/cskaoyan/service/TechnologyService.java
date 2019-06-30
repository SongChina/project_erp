package com.cskaoyan.service;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyExample;
import com.cskaoyan.vo.Vo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/6/29 16:09
 */
public interface TechnologyService {

    //工艺管理-
    Vo<Technology> findTechnology(int page, int rows);


    //工艺管理通过编号模糊查询
    Vo<Technology> SerchTechnologyId(int page, int rows, String searchValue);
    //通过工艺名称模糊查询
    Vo<Technology> SerchTechnologyName(int page, int rows, String searchValue);

    //通过id查找单个工艺
    Technology serchTechnologyById(String technologyId);

    //以上新增方法
    long countByExample(TechnologyExample example);

    int deleteByExample(TechnologyExample example);

    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    List<Technology> selectByExample(TechnologyExample example);

    Technology selectByPrimaryKey(String technologyId);

    int updateByExampleSelective(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByExample(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);



}
