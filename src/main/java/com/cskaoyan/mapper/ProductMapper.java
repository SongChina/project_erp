package com.cskaoyan.mapper;

import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);


    List<Product> queryAllProduct();

    List<Product> queryProductByPage(@Param("limit") int limit, @Param("offset") int offset);

    List<Product> queryProductByProductIdInPage(@Param("searchValue") String searchValue, @Param("limit") int limit, @Param("offset") int offset);

    List<Product> queryProductByProductNameInPage(@Param("searchValue") String searchValue, @Param("limit") int limit, @Param("offset") int offset);

    List<Product> queryProductByProductTypeInPage(@Param("searchValue") String searchValue, @Param("limit") int limit, @Param("offset") int offset);
}