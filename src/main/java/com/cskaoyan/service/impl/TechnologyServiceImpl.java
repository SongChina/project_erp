package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyExample;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.service.TechnologyService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/6/29 16:10
 */
@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public Vo<Technology> findTechnology(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Technology> technologies = technologyMapper.selectByExample(new TechnologyExample());
        PageInfo<Technology> pageInfo = new PageInfo<>(technologies);
        Vo<Technology> technologyVo = new Vo<>();
        technologyVo.setRows(pageInfo.getList());
        technologyVo.setTotal(pageInfo.getTotal());
        return technologyVo;
    }

    @Override
    public Vo<Technology> SerchTechnologyId(int page, int rows, String searchValue) {
        //创建一个多条件查询实例
        TechnologyExample technologyExample = new TechnologyExample();
        //创建条件（准则）
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        //在准则中添加条件，模糊查询必须加%
        criteria.andTechnologyIdLike("%" + searchValue + "%");

        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);

        Vo<Technology> technologyVo = new Vo<>();
        //上面传的是一个list
        technologyVo.setRows(technologies);
        //technology.size传的是数量
        technologyVo.setTotal(technologies.size());

        return technologyVo;
    }


    @Override
    public Vo<Technology> SerchTechnologyName(int page, int rows, String searchValue) {
        //创建一个多条件查询实例
        TechnologyExample technologyExample = new TechnologyExample();
        //创建条件（准则）
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        //在准则中添加条件，模糊查询必须加%
        criteria.andTechnologyNameLike("%" + searchValue + "%");

        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);

        Vo<Technology> technologyVo = new Vo<>();
        //上面传的是一个list
        technologyVo.setRows(technologies);
        //technology.size传的是数量
        technologyVo.setTotal(technologies.size());

        return technologyVo;
    }

    @Override
    public Technology serchTechnologyById(String technologyId) {
        Technology technology = technologyMapper.selectByPrimaryKey(technologyId);
        return technology;
    }

    @Override
    public long countByExample(TechnologyExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(TechnologyExample example) {
        return 0 ;
    }

    @Override
    public int deleteByPrimaryKey(String technologyId) {
        return technologyMapper.deleteByPrimaryKey(technologyId);
    }

    @Override
    public int insert(Technology record) {
        return technologyMapper.insert(record);
    }

    @Override
    public int insertSelective(Technology record) {
        return 0;
    }

    //搜索
    @Override
    public List<Technology> selectByExample(TechnologyExample example) {
        return technologyMapper.selectByExample(example);
    }

    //根据Id搜出一个
    @Override
    public Technology selectByPrimaryKey(String technologyId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Technology record, TechnologyExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Technology record, TechnologyExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Technology record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Technology record) {
        return technologyMapper.updateByPrimaryKey(record);
    }
}
