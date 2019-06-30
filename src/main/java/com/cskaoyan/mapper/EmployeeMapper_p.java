package com.cskaoyan.mapper;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.EmployeeExample;
import com.cskaoyan.bean.Employee_p;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EmployeeMapper_p {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(String empId);

    int insert(Employee_p record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(String empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee_p record);

    List<Employee_p>getEmployee_pList();

    List<Employee_p> getByID(@Param("id") String id);
    int countgetByID(@Param("id") String id);

    List<Employee_p> getByName(@Param("id") String id);
    int countgetByName(@Param("id") String id);

    List<Employee_p> getByDepartment(@Param("id") String id);
    int countgetByDepartment(@Param("id") String id);

    Employee_p selectByEmpId(@Param("empId") String empId);

    Employee_p[] getEmployees();
}