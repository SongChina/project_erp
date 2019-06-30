package com.cskaoyan.controller;

import com.cskaoyan.bean.*;
import com.cskaoyan.service.EmployeeService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class EmployeeController {

    @Autowired
    HttpSession session;

    @Autowired
    EmployeeService employeeService;

    //获取所有employee_p
    @RequestMapping("employee/get_data")
    @ResponseBody
    public Employee_p[] getEmployee(){
        Employee_p[] employee_ps = employeeService.getEmployee();
        return employee_ps;
    }

    @RequestMapping("employee/find")
    public ModelAndView employeefind(ModelAndView modelAndView, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("employee:add");
        sysPermissionList.add("employee:edit");
        sysPermissionList.add("employee:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        modelAndView.setViewName("employee_list");
        return modelAndView;
    }

    @RequestMapping("employee/list")
    public EmployeeList employeepage(int page, int rows) {
        return employeeService.getEmployeePage(page, rows);
    }

    @RequestMapping("employee/add_judge")
    public String employeeadd() {
        return "{}";
    }
//
    @RequestMapping("employee/delete_judge")
    public String employeedelete() {
        return "{}";
    }

    @RequestMapping("employee/edit_judge")
    public String employeeedit() {
        return "{}";
    }
//
    @RequestMapping("employee/add")
    public ModelAndView employeeadd(ModelAndView modelAndView) {
        modelAndView.setViewName("employee_add");
        return modelAndView;
    }
//
    @RequestMapping("employee/edit")
    public ModelAndView employeeedit(ModelAndView modelAndView) {
        modelAndView.setViewName("employee_edit");
        return modelAndView;
    }

    @RequestMapping("employee/insert")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo employeeinsert(Employee employee) {
        int status = employeeService.addEmployee(employee);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        } else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }
//
    @RequestMapping("employee/update_all")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo employeeupdata(Employee employee) {
        int status = employeeService.updataEmployee(employee);//service层加方法
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        } else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }
//
    @RequestMapping("employee/delete_batch")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseVo employeedelete(String[] ids) {
        int status = employeeService.deleteEmployee(ids);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        } else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }
//
    @RequestMapping("employee/search_employee_by_employeeId")
    public EmployeeList searchByEmployeeId(String searchValue, int page, int rows) {
        return employeeService.selectEmployeeByEmployeeId(searchValue, page, rows);
    }
    @RequestMapping("employee/search_employee_by_employeeName")
    public EmployeeList searchByEmployeeName(String searchValue, int page, int rows) {
        return employeeService.selectEmployeeByEmployeeName(searchValue, page, rows);
    }
    @RequestMapping("employee/search_employee_by_departmentName")
    public EmployeeList searchByDepartmentName(String searchValue, int page, int rows) {
        return employeeService.selectEmployeeByDepartmentName(searchValue, page, rows);
    }

    //Restful获取employee
    @RequestMapping("employee/get/{empId}")
    @ResponseBody
    public Employee_p getEmployeeById(@PathVariable("empId") String empId){
        Employee_p employee_p = employeeService.getEmployeeById(empId);
        return employee_p;
    }
}
