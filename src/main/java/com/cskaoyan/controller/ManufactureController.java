package com.cskaoyan.controller;

import com.cskaoyan.bean.WorkDetail;
import com.cskaoyan.mapper.WorkDetailMapper;
import com.cskaoyan.mapper.WorkMapper;
import com.cskaoyan.vo.COrderResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ManufactureController {
    /*@Autowired
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
    }*/
}
