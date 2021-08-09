package com.itheima.filters;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;



@Component
@Slf4j
//自定义的全局过滤器（作用是 统一鉴权）
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
      //统一鉴权
        String token = exchange.getRequest().getQueryParams().getFirst("token");

        //认证失败
        if(!StringUtils.equals("admin",token)){
            log.info("认证失败");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        //放行
        return chain.filter(exchange);
    }

    //标识当前过滤器的优先级，返回值越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
