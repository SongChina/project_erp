package com.cskaoyan.service.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.TechnologyPlanMapper;
import com.cskaoyan.service.TechnologyPlanService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/6/29 17:13
 */
@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;


    @Override
    public Vo<TechnologyPlan> findTechnologyPlan(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.findAllTechnologyPlan();
        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(technologyPlans);
        Vo<TechnologyPlan> technologyPlanVo = new Vo<>();
        //前端需要返回的数据？需要返回rows，total，把它封装成javabean类型，返回给前端，
        technologyPlanVo.setRows(pageInfo.getList());
        //记录数据总数
        technologyPlanVo.setTotal(pageInfo.getTotal());
        return technologyPlanVo;
    }

    //工艺计划回显
    @Override
    public TechnologyPlan serchTechnologyPlanById(String technologyPlanId) {
        TechnologyPlan technologyPlan = technologyPlanMapper.selectByPrimaryKey(technologyPlanId);
        return  technologyPlan;
    }

    //搜索
    @Override
    public Vo<TechnologyPlan> findTechnologyPlanId(int page, int rows, String searchValue) {
        //创建一个多条件查询实例
        TechnologyPlanExample technologyPlanExample = new TechnologyPlanExample();
        //创建条件（准则）
        TechnologyPlanExample.Criteria criteria = technologyPlanExample.createCriteria();
        //在准则中添加条件，模糊查询必须加%
        criteria.andTechnologyPlanIdLike("%" + searchValue + "%");

        List<TechnologyPlan> technologies = technologyPlanMapper.selectByExample(technologyPlanExample);

        Vo<TechnologyPlan> technologyVo = new Vo<>();
        //上面传的是一个list
        technologyVo.setRows(technologies);
        //technology.size传的是数量
        technologyVo.setTotal(technologies.size());

        return technologyVo;
    }

    //按工艺名称查询
    @Override
    public Vo<TechnologyPlan> selectByTechnologyName(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlanList = technologyPlanMapper.selectByTechnologyName(searchValue);
        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(technologyPlanList);
        Vo<TechnologyPlan> technologyPlanVo = new Vo<>();
        //上面传的是一个list
        technologyPlanVo.setRows(pageInfo.getList());
        //technology.size传的是数量
        technologyPlanVo.setTotal(pageInfo.getTotal());
        return technologyPlanVo;
    }


    @Override
    public long countByExample(TechnologyPlanExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(TechnologyPlanExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String technologyPlanId) {

        return technologyPlanMapper.deleteByPrimaryKey(technologyPlanId);
    }

    @Override
    public int insert(TechnologyPlan record) {
        //technologyPlanMapper  dao层，和数据库交换数据，是Mapper和映射文件实现的
        int insert = technologyPlanMapper.insert(record);

        return insert;
    }

    @Override
    public int insertSelective(TechnologyPlan record) {
        return 0;
    }

    @Override
    public List<TechnologyPlan> selectByExample(TechnologyPlanExample example) {
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.selectByExample(example);

        return technologyPlans;
    }



    @Override
    public TechnologyPlan selectByPrimaryKey(String technologyPlanId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(TechnologyPlan record, TechnologyPlanExample example) {
        return 0;
    }

    @Override
    public int updateByExample(TechnologyPlan record, TechnologyPlanExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(TechnologyPlan record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TechnologyPlan record) {
        return technologyPlanMapper.updateByPrimaryKey(record);
    }

}
