package com.cskaoyan.controller.corder_management;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.COrderDetailMapper;
import com.cskaoyan.mapper.COrderMapper;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.vo.COrderResponseVo;
import com.cskaoyan.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD5;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class COrderController {
    @Autowired
    COrderMapper mapper;

    @RequestMapping("order/add_judge")
    @ResponseBody
    public String getNothing() {
        return "{}";
    }

    @RequestMapping("order/find")
    public ModelAndView test(HttpServletResponse response,
                             HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order_list");
        return modelAndView;
    }

    @Autowired
    COrderDetailMapper cOrderDetailMapper;

    @RequestMapping("order/list")
    @ResponseBody
    public COrderResponseVo<COrderDetail> fillOrderDataPaging(@RequestParam("page") Integer page,
                                                              @RequestParam("rows") Integer rows) {
        int limit = rows;
        int offset = (page - 1) * rows;
        List<COrderDetail> cOrderDetails = cOrderDetailMapper.queryCOrderDetailByPage(limit, offset);
        COrderResponseVo<COrderDetail> orders = new COrderResponseVo<>();
        orders.setTotal(11);
        orders.setRows(cOrderDetails);
        return orders;
    }



    @RequestMapping("order/add")
    public ModelAndView getOrderAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order_add");
        return modelAndView;
    }

    @RequestMapping("file/upload")
    @ResponseBody
    public UploadMessage fileUpload(HttpServletRequest request,MultipartFile file) throws IOException {
        String outPath = request.getSession().getServletContext().getRealPath("upload/corder/file");
        File directory = new File(outPath);
        if (!directory.exists()){
            directory.mkdir();
        }

        //abc.txt
        //e:fileload/abc.txt
        String append = uuid();
        String name = file.getOriginalFilename();
        append += name;
        File myfile = new File(directory, append);
        file.transferTo(myfile);

        String url = "/file/" + append;
        UploadMessage uploadMessage = new UploadMessage();
        uploadMessage.setError(0);
        uploadMessage.setUrl(url);
        return uploadMessage;
    }
    @RequestMapping("pic/upload")
    @ResponseBody
    public UploadMessage uploadImage(HttpServletRequest request, MultipartFile uploadFile) throws IOException {
/*        Resource resource = new ClassPathResource("");
        URL basicPath = resource.getURL();*/
/*        String basicPath = request.getContextPath();*/
        String projectPath = request.getContextPath();
        String outPath = request.getSession().getServletContext().getRealPath("upload/corder/image");
        File directory = new File(outPath);
        if (!directory.exists()){
            directory.mkdir();
        }

        String append = uuid();

        String name = uploadFile.getOriginalFilename();
        append += name;
        File myfile = new File(directory, append);
        uploadFile.transferTo(myfile);

        String url = "/pic/" + append;
        UploadMessage uploadMessage = new UploadMessage();
        uploadMessage.setError(0);
        uploadMessage.setUrl(url);
        return uploadMessage;
    }
    public static  String uuid(){
        String s= UUID.randomUUID().toString();

        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);


    }

    @RequestMapping("order/search_order_by_orderId")
    @ResponseBody
    public COrderResponseVo<COrderDetail> findCOrdersInCOrderId(@RequestParam("searchValue") String searchValue,
                                                      @RequestParam("page") Integer page,
                                                      @RequestParam("rows") Integer rows) {
        int limit = rows;
        int offset = (page - 1) * rows;
        List<COrderDetail> cOrderDetails = cOrderDetailMapper.queryCOrderDetailByPageInCOrderId("%" +searchValue + "%", limit, offset);

        COrderResponseVo<COrderDetail> orders = new COrderResponseVo<>();
        orders.setTotal(11);
        orders.setRows(cOrderDetails);
        return orders;
    }

    @Autowired
    CustomMapper customMapper;

    @RequestMapping("order/search_order_by_orderCustom")
    @ResponseBody
    public COrderResponseVo<COrderDetail> findCOrdersInCustomName(@RequestParam("searchValue") String searchValue,
                                                                @RequestParam("page") Integer page,
                                                                @RequestParam("rows") Integer rows) {
        int limit = rows;
        int offset = (page - 1) * rows;
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomNameLike("%" +searchValue + "%");
        List<Custom> customs = customMapper.selectByExample(customExample);
        COrderResponseVo<COrderDetail> orders = new COrderResponseVo<>();
        List<String> customIds = new ArrayList<>();
        List<COrderDetail> cOrderDetails = new ArrayList<>();

        if(customs.size() == 0){
            orders.setRows(cOrderDetails);
            orders.setTotal(0);
            return orders;
        }


        for (Custom custom : customs) {
            customIds.add(custom.getCustomId());
        }
        cOrderDetails = cOrderDetailMapper.queryCOrderDetailByPageInCustomIds(customIds, limit, offset);
        orders.setTotal(11);
        orders.setRows(cOrderDetails);
        return orders;
    }

    @Autowired
    ProductMapper productMapper;

    @RequestMapping("order/search_order_by_orderProduct")
    @ResponseBody
    public COrderResponseVo<COrderDetail> findCOrdersInProductName(@RequestParam("searchValue") String searchValue,
                                                                  @RequestParam("page") Integer page,
                                                                  @RequestParam("rows") Integer rows) {
        int limit = rows;
        int offset = (page - 1) * rows;
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductNameLike("%" +searchValue + "%");
        List<Product> products = productMapper.selectByExample(productExample);

        COrderResponseVo<COrderDetail> orders = new COrderResponseVo<>();
        List<String> productIds = new ArrayList<>();
        List<COrderDetail> cOrderDetails = new ArrayList<>();

        if(products.size() == 0){
            orders.setRows(cOrderDetails);
            orders.setTotal(0);
            return orders;
        }


        for (Product product : products) {
            productIds.add(product.getProductId());
        }
        cOrderDetails = cOrderDetailMapper.queryCOrderDetailByPageInProductIds(productIds, limit, offset);
        orders.setTotal(11);
        orders.setRows(cOrderDetails);
        return orders;
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

    @RequestMapping("order/delete_judge")
    @ResponseBody
    public String getNothing2() {
        return "{}";
    }

    @RequestMapping("order/edit_judge")
    @ResponseBody
    public String getNothing3() {
        return "{}";
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
    }
}
