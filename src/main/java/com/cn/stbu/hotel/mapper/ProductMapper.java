package com.cn.stbu.hotel.mapper;

import com.cn.stbu.hotel.domain.Product;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:53 2020/2/12
 */
public interface ProductMapper {

    List<Product> getProductList(Product product);

    int addProduct(Product product);

    int delProductByPid(int productId);

    Product getProductByPid(int productId);

    int updateProduct(Product product);
}
