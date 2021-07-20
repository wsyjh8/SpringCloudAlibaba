package com.itheima.service;

import com.itheima.domain.Order;
import com.itheima.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(value = "service-product") //微服务名称
public interface ProductService {

    @RequestMapping("/product/{pid}")
     Product findByPid(@PathVariable  Integer pid);

}
