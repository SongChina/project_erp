package com.cskaoyan.controller;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.service.COrderService;
import com.cskaoyan.service.impl.COrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    COrderServiceImpl corderServiceimpl;
    @RequestMapping("list")
    @ResponseBody
    public List<COrder> listOrder(HttpServletResponse response, HttpServletRequest request){
        List<COrder> cOrders = corderServiceimpl.queryCOrdersByPage(1, 10);
        /*request.setAttribute();*/
        return cOrders;
    }

    @RequestMapping("/")
    public String getIndexPage(HttpServletRequest request, HttpServletResponse response){
        return "home";
    }

}
