package com.itheima.predicates;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.BeforeRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;


@Component
public class AgeRoutePredicateFactory extends  AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config>{

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                //1.接收前台传入age参数

                String ageStr = serverWebExchange.getRequest().getQueryParams().getFirst("Age");

                //2.先判断是否为空
                if(StringUtils.isNotEmpty(ageStr)){
                    int age = Integer.parseInt(ageStr);
                    if(age < config.getMaxAge() && age > config.getMinAge()){
                        return true;
                    }
                    return false;
                }

                return false;
            }
        } ;

    }


    //读取配置文件中参数值 给他赋值到配置类中的属性上
    @Override
    public List<String> shortcutFieldOrder() {

        //这个位置顺序必须跟配置文件中的值顺序对应
        return Arrays.asList("minAge","maxAge");
    }

    public AgeRoutePredicateFactory() {
        super(AgeRoutePredicateFactory.Config.class);
    }

    public static class Config{
        private int minAge;
        private int maxAge;

        public Config(int minAge, int maxAge) {
            this.minAge = minAge;
            this.maxAge = maxAge;
        }

        public Config() {

        }


        public int getMinAge() {
            return minAge;
        }

        public void setMinAge(int minAge) {
            this.minAge = minAge;
        }

        public int getMaxAge() {
            return maxAge;
        }

        public void setMaxAge(int maxAge) {
            this.maxAge = maxAge;
        }

    }
}

