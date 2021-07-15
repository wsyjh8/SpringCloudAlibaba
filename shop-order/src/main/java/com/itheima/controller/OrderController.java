package com.itheima.controller;


import com.itheima.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {



    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/order/pro/{pid}")
    public Order order(@PathVariable("pid") Integer id){

        log.info("接收到");

        return ;
    }




}