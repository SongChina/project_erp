package com.cskaoyan.controller;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.mapper.COrderMapper;
import com.cskaoyan.service.COrderService;
import com.cskaoyan.service.impl.COrderServiceImpl;
import com.cskaoyan.vo.COrderResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@org.springframework.stereotype.Controller
public class PlanModuleController {

/*    @Autowired
    COrderServiceImpl corderServiceimpl;*/

    @Autowired
    COrderMapper mapper;
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
    @RequestMapping("order/find")
    public ModelAndView test(HttpServletResponse response,
                                HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order_list");
        return modelAndView;
    }
    @RequestMapping("order/list")
    @ResponseBody
    public COrderResponseVo<List<COrder>> fillOrderData(HttpServletRequest request){
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        List<COrder> cOrders = mapper.selectByPage(10, 0);
        COrderResponseVo<List<COrder>> orders = new COrderResponseVo<>();
        orders.setTotal(11);
        orders.setRows(cOrders);
        return orders;
    }

    @RequestMapping("/")
    public String getIndexPage(HttpServletRequest request, HttpServletResponse response){

        return "home";
    }

}
