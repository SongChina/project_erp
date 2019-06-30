package com.cskaoyan.service;


import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.DepartmentList;

import java.util.List;


public interface DepartmentService {

     DepartmentList getDepartmentList(String page, String rows);

     DepartmentList getDepartmentById(String searchValue, String page, String rows);

     DepartmentList getDepartmentByName(String searchValue, String page, String rows);


     int insert(Department department);

     int update(Department department);

     int delete(String[] ids);

     List<Department> getdata();

}
