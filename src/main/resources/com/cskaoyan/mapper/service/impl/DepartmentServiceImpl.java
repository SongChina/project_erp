package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.DepartmentExample;
import com.cskaoyan.bean.DepartmentList;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;


    @Override
    public DepartmentList getDepartmentList(String page, String rows) {
        DepartmentExample departmentExample = new DepartmentExample();
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        int  count = (int) departmentMapper.countByExample(departmentExample);
        DepartmentList departmentList = new DepartmentList();
        departmentList.setTotal(count);
        departmentList.setRows(departments);
        return departmentList;
    }

    @Override
    public DepartmentList getDepartmentById(String searchValue, String page, String rows) {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDepartmentIdEqualTo(searchValue);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        int count = (int) departmentMapper.countByExample(departmentExample);
        DepartmentList departmentList = new DepartmentList();
        departmentList.setTotal(count);
        departmentList.setRows(departments);
        return departmentList;
    }

    @Override
    public DepartmentList getDepartmentByName(String searchValue, String page, String rows) {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDepartmentNameEqualTo(searchValue);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        int count = (int) departmentMapper.countByExample(departmentExample);
        DepartmentList departmentList = new DepartmentList();
        departmentList.setTotal(count);
        departmentList.setRows(departments);
        return departmentList;
    }

    @Override
    public int insert(Department department) {
        int insert = departmentMapper.insert(department);
        return insert;
    }

    @Override
    public int update(Department department) {
        int update = departmentMapper.updateByPrimaryKey(department);
        return update;
    }

    @Override
    public int delete(String[] ids) {
        int status = 1;
        for (String id : ids) {
            int i = departmentMapper.deleteByPrimaryKey(id);
            if(i == 0){
                status = 0;
            }
        }
        return status;
    }

    @Override
    public List<Department> getdata() {
        DepartmentExample departmentExample = new DepartmentExample();
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        return departments;
    }
}
