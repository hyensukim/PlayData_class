package com.apigatewayserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 로깅하기 위한 필터
 */
@Slf4j
@Component
public class LogFilter extends AbstractGatewayFilterFactory<LogFilter.Config> {

    public LogFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest req = exchange.getRequest();
            ServerHttpResponse resp = exchange.getResponse();

            log.info("log pre filter : %s" ,req.getId());

            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                log.info("log post filter : %s" ,resp.getStatusCode());
            }));
        });
    }

    public static class Config{

    }
}
