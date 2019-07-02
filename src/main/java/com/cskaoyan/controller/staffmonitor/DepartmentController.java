package com.cskaoyan.controller.staffmonitor;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.DepartmentList;
import com.cskaoyan.bean.ResponseVo;
import com.cskaoyan.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    HttpSession session;

    @RequestMapping("department/find")
    public ModelAndView getDepartment(ModelAndView modelAndView){
        modelAndView.setViewName("department_list");
        String[] sysPermissionList = {"department:add", "department:edit", "department:delete"};
        session.setAttribute("sysPermissionList", sysPermissionList);
        return modelAndView;
    }


    @RequestMapping("department/list")
    @ResponseBody
    public DepartmentList getDepartmentList(String page, String rows){
        DepartmentList departmentList = departmentService.getDepartmentList(page, rows);
        return departmentList;
    }


    @RequestMapping("department/search_department_by_departmentId")
    @ResponseBody
    public DepartmentList getDepartmentById(String searchValue, String page, String rows){
        DepartmentList departmentList = departmentService.getDepartmentById(searchValue, page, rows);
        return departmentList;

    }

    @RequestMapping("department/search_department_by_departmentName")
    @ResponseBody
    public DepartmentList getDepartmentByName(String searchValue, String page, String rows){
        DepartmentList departmentList = departmentService.getDepartmentByName(searchValue, page, rows);
        return departmentList;

    }
    @RequestMapping("department/add_judge")
    @ResponseBody
    public String getNothing(){return " ";}

    @RequestMapping("department/add")
    public ModelAndView getDepartmentAddPage(ModelAndView modelAndView){
        modelAndView.setViewName("department_add");
        return modelAndView;
    }

    @RequestMapping("department/insert")
    @ResponseBody
    public ResponseVo insert(Department department){
        int status = departmentService.insert(department);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if(status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("Ok");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("department/update_all")
    @ResponseBody
    public ResponseVo update(Department department){
        int status = departmentService.update(department);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if(status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("Ok");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("department/edit_judge")
    @ResponseBody
    public String getNothing1(){return " ";}

    @RequestMapping("department/edit")
    public ModelAndView getDepartmentEditPage(ModelAndView modelAndView){
        modelAndView.setViewName("department_edit");
        return modelAndView;
    }

    @RequestMapping("department/delete_judge")
    @ResponseBody
    public String getNothing3(){return " ";}

    //@RequestMapping("department/delete_batch")
    @RequestMapping("department/delete_batch")
    @ResponseBody
    public ResponseVo delete(String[] ids){
        int status = departmentService.delete(ids);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if(status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("Ok");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("department/get_data")
    @ResponseBody
    public List<Department> getdata(){
        return departmentService.getdata();
    }

}
