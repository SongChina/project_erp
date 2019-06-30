package com.cskaoyan.service;

import com.cskaoyan.bean.*;
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
    EmployeeList selectEmployeeByEmployeeId(String searchValue, int page, int rows);
//
    EmployeeList selectEmployeeByEmployeeName(String searchValue, int page, int rows);

    EmployeeList selectEmployeeByDepartmentName(String searchValue, int page, int rows);

    //通过id查询
    Employee_p getEmployeeById(String empId);

    Employee_p[] getEmployee();
}
