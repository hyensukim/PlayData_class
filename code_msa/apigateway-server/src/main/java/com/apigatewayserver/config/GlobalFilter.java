package com.apigatewayserver.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {

    public GlobalFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest req = exchange.getRequest();
            ServerHttpResponse resp = exchange.getResponse();

            System.out.println("global filter default message : " + config.getMessage());

            if(config.isPre()){
                System.out.println("global pre filter : " + req.getId());
            }

            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                if(config.isPost()){
                    System.out.println("global post filter : " + resp.getStatusCode());
                }
            }));
        };
    }


    @Getter @Setter
    public static class Config{
        private String message;
        private boolean pre;
        private boolean post;
    }

}
