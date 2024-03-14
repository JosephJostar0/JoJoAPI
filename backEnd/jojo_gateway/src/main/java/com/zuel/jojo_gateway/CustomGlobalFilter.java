package com.zuel.jojo_gateway;

import com.zuel.jojoapi_client_sdk.utils.SignUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    private static final List<String> IP_WHITE_LIST = Arrays.asList("172.17.195.245");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1. log of requests
        ServerHttpRequest request = exchange.getRequest();
        log.info("\ngetId: " + request.getId());
        log.info("\ngetPath: " + request.getPath().value());
        log.info("\ngetMethod: " + request.getMethod());
        log.info("\ngetQueryParams: " + request.getQueryParams());
        String sourceAddress = request.getLocalAddress().getHostString();
        log.info("\ngetLocalAddress.getHostString(): " + sourceAddress);
        log.info("\ngetRemoteAddress: " + request.getRemoteAddress());

        // 2. black list
        ServerHttpResponse response = exchange.getResponse();
        if (!IP_WHITE_LIST.contains(sourceAddress)) {
            response.setStatusCode(HttpStatus.FORBIDDEN);
            return response.setComplete();
        }

        // 3. authentication
        HttpHeaders headers = request.getHeaders();
        String accessKey = headers.getFirst("accessKey");
        String nonce = headers.getFirst("nonce");
        String timestamp = headers.getFirst("timestamp");
        String sign = headers.getFirst("sign");
        String body = headers.getFirst("body");
        // todo check the key with database
//        String serverSign = SignUtils.genSign(body, "abcdefg");
//        if (!sign.equals((serverSign))){
//            return handleNoAuth(response);
//        }
        if (accessKey.equals("nahida")) {
            return handleNoAuth(response);
        }
        if (Long.parseLong(nonce) > 10000L) {
            return handleNoAuth(response);
        }
        Long currentTime = System.currentTimeMillis() / 1000;
        final Long FIVE_MINUTES = 60 * 5L;
        if ((currentTime - Long.parseLong(timestamp)) >= FIVE_MINUTES) {
            return handleNoAuth(response);
        }

        // todo check interfaceInfo from database, also check whether method matched or not
        // todo if call interface success, do cnt++
        if (response.getStatusCode() == HttpStatus.OK) {

        } else {
            return handleInvokeError(response);
        }

        log.info("\n\ncustom global filter\n\n");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }

    public Mono<Void> handleNoAuth(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.FORBIDDEN);
        return response.setComplete();
    }

    public Mono<Void> handleInvokeError(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        return response.setComplete();
    }
}
