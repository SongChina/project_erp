package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyExample;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.bean.TechnologyRequirementExample;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.mapper.TechnologyRequirementMapper;
import com.cskaoyan.service.TechnologyRequirementService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/6/29 17:31
 */
@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;
    @Autowired
    TechnologyMapper technologyMapper;


    @Override
    public Vo<TechnologyRequirement> findTechnologyRequirement(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.findAllTechnologyRequirements();
        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(technologyRequirements);
        Vo<TechnologyRequirement> technologyRequirementVo = new Vo<>();
        //前端需要返回的数据？需要返回rows，total，把它封装成javabean类型，返回给前端，
        technologyRequirementVo.setRows(pageInfo.getList());
        //记录数据总数
        technologyRequirementVo.setTotal(pageInfo.getTotal());
        return technologyRequirementVo;
    }

    @Override
    public Vo<TechnologyRequirement> SerchTechnologyRequirementId(int page, int rows, String searchValue) {
        //创建一个多条件查询实例
        TechnologyRequirementExample technologyRequirementExample = new TechnologyRequirementExample();
        //创建条件（准则）
        TechnologyRequirementExample.Criteria criteria = technologyRequirementExample.createCriteria();
        //在准则中添加条件，模糊查询必须加%
        criteria.andTechnologyRequirementIdLike("%" + searchValue + "%");

        List<TechnologyRequirement> technologies = technologyRequirementMapper.selectByExample(technologyRequirementExample);

        Vo<TechnologyRequirement> technologyVo = new Vo<>();
        //上面传的是一个list
        technologyVo.setRows(technologies);
        //technology.size传的是数量
        technologyVo.setTotal(technologies.size());

        return technologyVo;
    }

    //按照工艺名称查询
    @Override
    public Vo<TechnologyRequirement> selectByTechnologyName(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<TechnologyRequirement> technologyRequirementList = technologyRequirementMapper.selectByTechnologyName(searchValue);
        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(technologyRequirementList);
        Vo<TechnologyRequirement> technologyRequirementVo = new Vo<>();
        //上面传的是一个list
        technologyRequirementVo.setRows(pageInfo.getList());
        //technology.size传的是数量
        technologyRequirementVo.setTotal(pageInfo.getTotal());
        return technologyRequirementVo;
    }




    @Override
    public long countByExample(TechnologyRequirementExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(TechnologyRequirementExample example) {
        return 0;
    }

    //删除方法
    @Override
    public int deleteByPrimaryKey(String technologyRequirementId) {
        return technologyRequirementMapper.deleteByPrimaryKey(technologyRequirementId);
    }


    @Override
    public int insert(TechnologyRequirement record) {
        int insert = technologyRequirementMapper.insert(record);

        return insert;
    }

    @Override
    public int insertSelective(TechnologyRequirement record) {
        return 0;
    }

    @Override
    public List<TechnologyRequirement> selectByExample(TechnologyRequirementExample example) {
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.selectByExample(example);

        return technologyRequirements;
    }

    @Override
    public TechnologyRequirement selectByPrimaryKey(String technologyRequirementId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(TechnologyRequirement record, TechnologyRequirementExample example) {
        return 0;
    }

    @Override
    public int updateByExample(TechnologyRequirement record, TechnologyRequirementExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(TechnologyRequirement record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TechnologyRequirement record) {
        return technologyRequirementMapper.updateByPrimaryKey(record);
    }


}
