package com.cskaoyan.controller.corder_management;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.COrderDetailMapper;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.vo.COrderResponseVo;
import com.cskaoyan.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @RequestMapping("product/*_judge")
    @ResponseBody
    public String getNothing5() {
        return "{}";
    }
    @ResponseBody
    @RequestMapping("product/update_all")
    public Message updateProduct(Product product){
        Message message = new Message();
        int i = productMapper.updateByPrimaryKey(product);
        if(i > 0){
            message.setStatus(200);
            message.setMsg("OK");
        }
        return message;
    }

    @Autowired
    ProductMapper productMapper;

    @RequestMapping("product/get_data")
    @ResponseBody
    public List<Product> getAllProduct() {
        List<Product> products = productMapper.queryAllProduct();
        return products;

    }
    @RequestMapping("product/get/{productId}")
    @ResponseBody
    public Product getSingleProduct(@PathVariable("productId") String productId){
        Product product = productMapper.selectByPrimaryKey(productId);
        return product;
    }



    @RequestMapping("product/find")
    public ModelAndView test(HttpServletResponse response,
                             HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product_list");
        return modelAndView;
    }

    @RequestMapping("product/list")
    @ResponseBody
    public COrderResponseVo<Product> fillProductDataPaging(@RequestParam("page") Integer page,
                                                              @RequestParam("rows") Integer rows) {
        int limit = rows;
        int offset = (page - 1) * rows;
        List<Product> products = productMapper.queryProductByPage(limit, offset);
        COrderResponseVo<Product> result = new COrderResponseVo<>();
        result.setTotal(11);
        result.setRows(products);
        return result;
    }



    @RequestMapping("product/add")
    public ModelAndView getOrderAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product_add");
        return modelAndView;
    }


    @RequestMapping("product/insert")
    @ResponseBody
    public Object insertProduct(Product product) {
        Message message = new Message();
        Product temp = productMapper.selectByPrimaryKey(product.getProductId());
        if (temp != null) {
            message.setStatus(400);
            return message;
        }

        int insert = productMapper.insert(product);
        if (insert > 0) {
            message.setStatus(200);
            message.setMsg("OK");
        }
        return message;
    }




    @RequestMapping("product/delete_batch")
    public Message deleteOrder(String[] ids) {

        Message message = new Message();
        ArrayList<String> idsList = new ArrayList<>();
        for (String id : ids) {
            idsList.add(id);
        }

        ProductExample ProductExample = new ProductExample();
        ProductExample.Criteria criteria = ProductExample.createCriteria();
        criteria.andProductIdIn(idsList);

        int i = productMapper.deleteByExample(ProductExample);
        message.setStatus(200);
        message.setMsg("OK");
        return message;
    }

    @RequestMapping("product/edit")
    public ModelAndView getOrderEditPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product_edit");
        return modelAndView;
    }

 /*   @ResponseBody
    @RequestMapping("product/update_all")
    public Message update67(Product product){
        Message message = new Message();
        int i = productMapper.updateByPrimaryKey(product);
        if(i > 0){
            message.setStatus(200);
            message.setMsg("OK");
        }
        return message;
    }*/


}
