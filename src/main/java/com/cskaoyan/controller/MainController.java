package com.cskaoyan.controller;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.COrderDetailMapper;
import com.cskaoyan.mapper.COrderMapper;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.vo.COrderResponseVo;
import com.cskaoyan.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class MainController {

/*    @Autowired
    COrderServiceImpl corderServiceimpl;*/


/*    @RequestMapping("list")
    @ResponseBody
    public List<COrder> listOrder(HttpServletResponse response, HttpServletRequest request){
        *//*List<COrder> cOrders = corderServiceimpl.queryCOrdersByPage(1, 10);*//*
        COrder cOrder = mapper.selectByPrimaryKey("000001");
        List<COrder> cOrders = mapper.selectByPage(10, 1);
        *//*request.setAttribute();*//*
        return cOrders;
    }*/
    /*    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
*/

    /*************order相关请求*****************/





    @RequestMapping("custom/edit_judge")
    @ResponseBody
    public String getNothing10() {
        return "{}";
    }



    /***************************custom相关请求************************/

    @RequestMapping("/")
    public String getIndexPage(HttpServletRequest request, HttpServletResponse response) {

        return "home";
    }

}
