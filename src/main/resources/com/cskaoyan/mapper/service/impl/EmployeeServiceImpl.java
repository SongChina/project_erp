package com.cskaoyan.service.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.mapper.EmployeeMapper_p;
import com.cskaoyan.service.EmployeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmployeeMapper_p employeeMapper_p;


//    @Override
//    public List <Employee> getEmployeeList() {
//        EmployeeExample employeeExample = new EmployeeExample();
//        List<Employee> employee = employeeMapper.selectByExample(employeeExample);
//        return employee;
//    }

    @Override
    public EmployeeList getEmployeePage(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Employee_p> employee= employeeMapper_p.getEmployee_pList();
        EmployeeList employeeList1 = new EmployeeList();
        employeeList1.setTotal((int) employeeMapper.countByExample(new EmployeeExample()));
        employeeList1.setRows(employee);
        return employeeList1;
    }
//
    @Override
    public int addEmployee(Employee employee) {
        int insert = employeeMapper.insert(employee);
        return insert;
    }
//
    @Override
    public int updataEmployee(Employee employee) {
        int i = employeeMapper.updateByPrimaryKey(employee);
        return i;
    }

    @Override
    public int deleteEmployee(String[] employeeIds) {
        for (String id : employeeIds) {
            int i = employeeMapper.deleteByPrimaryKey(id);
            if(1 != i){
                return 0;
            }
        }
        return 1;
    }
//
    public EmployeeList selectEmployeeByEmployeeId(String id,int page,int rows){
        PageHelper.startPage(page, rows);
        List<Employee_p> employee_ps = employeeMapper_p.getByID(id);
        int count = employeeMapper_p.countgetByID(id);
        EmployeeList employeeList = new EmployeeList();
        employeeList.setTotal(count);
        employeeList.setRows(employee_ps);
        return employeeList;

    }
//
    @Override
    public EmployeeList selectEmployeeByEmployeeName(String employeename, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Employee_p> employee_ps = employeeMapper_p.getByName(employeename);
        int count = employeeMapper_p.countgetByName(employeename);
        EmployeeList employeeList = new EmployeeList();
        employeeList.setTotal(count);
        employeeList.setRows(employee_ps);
        return employeeList;
    }

    @Override
    public EmployeeList selectEmployeeByDepartmentName(String departmentname, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Employee_p> employee_ps = employeeMapper_p.getByDepartment(departmentname);
        int count = employeeMapper_p.countgetByDepartment(departmentname);
        EmployeeList employeeList = new EmployeeList();
        employeeList.setTotal(count);
        employeeList.setRows(employee_ps);
        return employeeList;
    }
}
