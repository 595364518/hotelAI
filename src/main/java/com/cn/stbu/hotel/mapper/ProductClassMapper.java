package com.cn.stbu.hotel.mapper;

import com.cn.stbu.hotel.domain.ProductClass;

import java.util.List;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:54 2020/2/12
 */
public interface ProductClassMapper {

    List<ProductClass> getProductClassList();

    int addProductClass(ProductClass productClass);

    int delProductClassByCid(int classId);

    int updateProductClass(ProductClass productClass);

    ProductClass getProductClassByCid(int classId);

}
