package com.cskaoyan.controller.work_management;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.COrderDetailMapper;
import com.cskaoyan.mapper.COrderMapper;
import com.cskaoyan.mapper.WorkDetailMapper;
import com.cskaoyan.mapper.WorkMapper;
import com.cskaoyan.vo.COrderResponseVo;
import com.cskaoyan.vo.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WorkController {
    @Autowired
    WorkMapper workMapper;

    @RequestMapping("work/*_judge")
    @ResponseBody
    public String getNothing() {
        return "{}";
    }

    @RequestMapping("work/find")
    public ModelAndView test(HttpServletResponse response,
                             HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("work_list");
        return modelAndView;
    }

    @Autowired
    WorkDetailMapper workDetailMapper;

    @RequestMapping("work/list")
    @ResponseBody
    public COrderResponseVo<WorkDetail> fillOrderDataPaging(@RequestParam("page") Integer page,
                                                            @RequestParam("rows") Integer rows) {
        int limit = rows;
        int offset = (page - 1) * rows;
        List<WorkDetail> workDetails = workDetailMapper.queryWorkDetailByPage(limit, offset);
        COrderResponseVo<WorkDetail> result = new COrderResponseVo<>();
        result.setTotal(11);
        result.setRows(workDetails);
        return result;
    }


    @RequestMapping("work/search_work_by_workId")
    @ResponseBody
    public COrderResponseVo<WorkDetail> getWorkByWorkId(@Param("searchValue") String searchValue,
                                                           @Param("page") int page, @Param("rows") int rows){
        int limit = rows;
        int offset = (page - 1) * rows;
        List<WorkDetail> workDetails = workDetailMapper.queryWorkByWorkIdInPage("%" + searchValue + "%", limit, offset);

        COrderResponseVo<WorkDetail> result = new COrderResponseVo<>();
        result.setTotal(11);
        result.setRows(workDetails);
        return result;
    }

    @RequestMapping("work/search_work_by_workProcess")
    @ResponseBody
    public COrderResponseVo<WorkDetail> getWorkByProcessId(@Param("searchValue") String searchValue,
                                                  @Param("page") int page, @Param("rows") int rows){
        int limit = rows;
        int offset = (page - 1) * rows;
        List<WorkDetail> workDetails = workDetailMapper.queryWorkByProcessIdInPage("%" + searchValue + "%", limit, offset);

        COrderResponseVo<WorkDetail> result = new COrderResponseVo<>();
        result.setTotal(11);
        result.setRows(workDetails);
        return result;
    }

/*
    @RequestMapping("order/add")
    public ModelAndView getOrderAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order_add");
        return modelAndView;
    }


    @RequestMapping("order/insert")
    @ResponseBody
    public Object insertOrder(COrder cOrder) {
        Message message = new Message();
        COrder temp = mapper.selectByPrimaryKey(cOrder.getOrderId());
        if (temp != null) {
            message.setStatus(400);
            return message;
        }
        int insert = mapper.insert(cOrder);
        if (insert > 0) {
            message.setStatus(200);
            message.setMsg("OK");
        }
        return message;
    }





    @RequestMapping("order/delete_batch")
    public Message deleteOrder(String[] ids) {

        Message message = new Message();
        ArrayList<String> idsList = new ArrayList<>();
        for (String id : ids) {
            idsList.add(id);
        }

        COrderExample cOrderExample = new COrderExample();
        COrderExample.Criteria criteria = cOrderExample.createCriteria();
        criteria.andOrderIdIn(idsList);

        int i = mapper.deleteByExample(cOrderExample);
        message.setStatus(200);
        message.setMsg("OK");
        return message;
    }

    @RequestMapping("order/edit")
    public ModelAndView getOrderEditPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order_edit");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("order/update_all")
    public Message update(COrder cOrder){
        Message message = new Message();
        int i = mapper.updateByPrimaryKey(cOrder);
        if(i > 0){
            message.setStatus(200);
            message.setMsg("OK");
        }
        return message;
    }
    @RequestMapping("order/update_note")
    @ResponseBody
    public Message updateCOrderNote(String note, String orderId){
        Message message = new Message();
        COrderExample cOrderExample = new COrderExample();
        COrderExample.Criteria criteria = cOrderExample.createCriteria();
        List<String> orderIds = new ArrayList<>();
        orderIds.add(orderId);
        criteria.andOrderIdIn(orderIds);

        COrder cOrder = new COrder();
        cOrder.setNote(note);

        int i = mapper.updateByExampleSelective(cOrder, cOrderExample);
        if(i > 0){
            message.setStatus(200);
            message.setMsg("OK");
        }
        return message;
    }*/
}
