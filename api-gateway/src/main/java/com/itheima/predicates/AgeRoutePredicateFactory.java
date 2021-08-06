package com.itheima.predicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.web.server.ServerWebExchange;

import java.time.ZonedDateTime;
import java.util.function.Predicate;

public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {

    public AgeRoutePredicateFactory() {
            super(Config.class);
            }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return null;
    }

    
    public static class Config{
        private int minAge;
        private int maxAge;

        public Config(int minAge, int maxAge) {
            this.minAge = minAge;
            this.maxAge = maxAge;
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

