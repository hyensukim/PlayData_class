package com.apigatewayserver.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.sql.SQLOutput;

/*
    커스텀 필터
 */
@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
    public CustomFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest req = exchange.getRequest();
            ServerHttpResponse resp = exchange.getResponse();

            // pre-filter는 그냥 작성하면 돌아간다.
            System.out.println("Custom pre-filter : " + req.getId());

            // post-filter는 return 구문 속에 코드를 작성해서 만든다.
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                System.out.println("Custom post-filter : status code : " + resp.getStatusCode());
            }));
        });
    }

    // 내부 클래스 사용 : 응집도를 높이기 위해서 관련 있는 설정 클래스를 내부에 정의함.
    public static class Config{

    }
}
