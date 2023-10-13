package com.apigatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
//        return builder.routes() // 라이팅 정보 설정 추가 - S
//                .route(r -> r.path("/first-service/**")
//                        .filters(f->f.addRequestHeader("fsreqh","fsreqhv")
//                                .addResponseHeader("fsresph","fsresphv"))
//                        .uri("http://localhost:8001/")
//                )// 개별 라우트 정보 설정 추가(1개소)
//                .route(r -> r.path("/second-service/**")
//                        .filters(f -> f.addRequestHeader("secreqh","secreqhv")
//                                .addResponseHeader("secresph","secresphv"))
//                        .uri("http://localhost:8002/")
//                )// 개별 라우트 정보 설정 추가(1개소)
//                .build();// 라이팅 정보 설정 추가 - E
//    }
}
