package com.apigatewayserver.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomFilter3 extends AbstractGatewayFilterFactory<CustomFilter3.Config> {

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) ->{
            ServerHttpRequest req = exchange.getRequest();
            ServerHttpResponse resp = exchange.getResponse();
            String print_ = String.format(
                    "req-id : " + req.getId() + "\n" +
                    "req-cookies : " + req.getCookies() + "\n" +
                    "req-local-address : " + req.getLocalAddress() + "\n" +
                    "req-remote-address : " + req.getRemoteAddress() + "\n" +
                    "req-path : " + req.getPath() + "\n" +
                    "req-method : " + req.getMethod() + "\n" +
                    "req-query-params : " + req.getQueryParams()
            );

            String print_2 = String.format(
                    "resp-status-code : %s \n" +
                    "resp-cookies : %s \n" +
                    "resp-headers : %s \n"
            ,resp.getStatusCode(),resp.getCookies(),resp.getHeaders());

            System.out.println("req 관련 정보 : \n" + print_);

            System.out.println();

            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                System.out.println("resp 관련 정보 : \n" + print_2);
            }));
        };
    }

    public static class Config{

    }
}
