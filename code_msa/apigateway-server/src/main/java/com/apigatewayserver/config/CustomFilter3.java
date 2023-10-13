package com.apigatewayserver.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

// 필터 직접 구현
public class CustomFilter3 extends AbstractGatewayFilterFactory<CustomFilter3.Config> {

    public CustomFilter3(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
//        GatewayFilter gatewayFilter = new OrderedGatewayFilter(((exchange, chain) -> {
//
//        }, order...));
        return null;
    }

    public static class Config{

    }
}
