package com.cskaoyan.membertest;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.COrderDetailMapper;
import com.cskaoyan.mapper.COrderMapper;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.mapper.ProductMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class TestBySong {
    @Autowired
    COrderMapper mapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    COrderDetailMapper cOrderDetailMapper;
    @Autowired
    CustomMapper customMapper;

    @Test
    public void selectTest(){
/*        int i = mapper.deleteByPrimaryKey("1");
        System.out.println(i);*/

/*        List<COrderDetail> cOrderDetails = cOrderDetailMapper.queryCOrderDetailByPage(3, 0);

        System.out.println(cOrderDetails);*/

/*        Custom custom = cOrderDetailMapper.selectCustomByPrimaryKey("001");
        System.out.println(custom);*/

        /*List<COrder> cOrders = mapper.selectByPage(1, 1);
        System.out.println(cOrders);
*/     /*   List<Product> products = productMapper.queryAllProduct();
        System.out.println(products);*/


        /*mapper.updateByExampleSelective()*/
    }

}
