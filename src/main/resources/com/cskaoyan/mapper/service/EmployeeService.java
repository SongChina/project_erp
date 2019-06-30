package com.cskaoyan.service;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.DepartmentList;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.EmployeeList;
import com.github.pagehelper.Page;

import java.util.List;

public interface EmployeeService {

//    List<Employee> getEmployeeList();

    EmployeeList getEmployeePage(int page, int rows);

    int addEmployee(Employee employee);
//
    int updataEmployee(Employee employee);

    int deleteEmployee(String[] employeeIds);
//
    EmployeeList selectEmployeeByEmployeeId(String searchValue,int page,int rows);
//
    EmployeeList selectEmployeeByEmployeeName(String searchValue,int page,int rows);

    EmployeeList selectEmployeeByDepartmentName(String searchValue,int page,int rows);
}
