package com.example.gatewaymodel;

//全局过滤器

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//http://localhost:10010/userService/user/1?userid=user
//http://localhost:10010/user/1?userid=user
import java.util.List;
@Order(-1)//过滤器优先级，越小优先级越高 也可以通过实现 Ordered接口实现
@Component
public class LoginFilter implements GlobalFilter , Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> queryParams = request.getQueryParams();
         String user = queryParams.getFirst("userid");
        //判断参数是否符合
         if(user!=null&& user.equals("user")){
             Mono<Void> filter = chain.filter(exchange);//放行给下一个过滤器
             return filter;
         }
         //设置状态码
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
         //拦截请求
        return exchange.getResponse().setComplete();
    }

    //等同于@Order(-1)
    @Override
    public int getOrder() {
        return -1;
    }
}
