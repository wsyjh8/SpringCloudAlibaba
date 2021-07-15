package com.itheima.service;

import com.itheima.domain.Product;



public interface ProductService {

    //根据pid查询产品信息
    Product findByPid(Integer pid);
}
