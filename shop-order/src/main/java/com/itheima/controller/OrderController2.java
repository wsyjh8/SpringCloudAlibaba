package com.itheima.controller;


import com.alibaba.fastjson.JSON;
import com.itheima.domain.Order;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController2 {



    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/order/pro2/{pid}")
    public Order order(@PathVariable("pid") Integer pid){

        log.info("接收到{}号商品的下单请求，接下来调用商品微服务查询此商品信息，",pid);

     /*  List<ServiceInstance> instances = discoveryClient.getInstances("service-product");

        ServiceInstance serviceInstance = instances.get(0);

        Product product = restTemplate.getForObject("http://"+serviceInstance.getHost() +":" + serviceInstance.getPort()+"/product/"+pid,Product.class);
*/
       /* Product product = restTemplate.getForObject("http://service-product/product/"+pid, Product.class);
*/

        Product product = productService.findByPid(pid);

        try {
            Thread.sleep(20001);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        log.info("查询到{}号商品的信息，内容是：{}",pid, JSON.toJSONString(product));

        Order order = new Order();

        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);

   //     orderService.createOrder(order);

        log.info("创建订单成功，订单信息为{}", JSON.toJSONString(order));

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return order;
    }



    @RequestMapping("order/message")
    public String message(){
        return "测试";
    }

}