package com.cskaoyan.membertest;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.*;
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    WorkDetailMapper workDetailMapper;

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
/*        List<WorkDetail> workDetails = workDetailMapper.queryWorkDetailByPage(5, 0);
        System.out.println(workDetails);*/
/*        List<COrderDetail> cOrderDetails = cOrderDetailMapper.queryCOrderDetailByPageInCOrderId("%2%", 4, 0);
        System.out.println(cOrderDetails);*/
        ArrayList<String> strings = new ArrayList<>();
        strings.add("001");
        strings.add("002");
        List<COrderDetail> cOrderDetails = cOrderDetailMapper.queryCOrderDetailByPageInCustomIds(strings, 4,0);
        System.out.println(cOrderDetails);

    }
    public void fileTest(){
        File directory = new File("E://fileupload2");
        if (!directory.exists()){
            directory.mkdir();
        }

/*        //abc.txt
        //e:fileload/abc.txt
        String append = UUID.randomUUID().toString();
        String name = file.getOriginalFilename();
        append += name;
        File myfile = new File(directory, append);*/
    }

}
