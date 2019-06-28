package com.cskaoyan.controller.corder_management;

import com.cskaoyan.bean.Product;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {
    @RequestMapping("product/edit_judge")
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

}
