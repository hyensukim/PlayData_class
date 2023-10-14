package com.apigatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 기본으로 제공하는 필터 기능 및 라우터 Config 파일로 설정
@Configuration
public class FilterConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder,CustomFilter3 customFilter3){
        return builder.routes()
                .route(r-> r.path("/first-service/**")
                        .filters(f->f.filter(customFilter3.apply(new CustomFilter3.Config())))
                        .uri("http://localhost:8001/"))
                .route(r->r.path("/second-service/**")
                        .filters(f->f.addRequestHeader("second-req","2")
                                .addResponseHeader("second-resp","2"))
                        .uri("http://localhost:8002/"))
                .build();
    }
}
