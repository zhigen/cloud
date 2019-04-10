package com.zglu.service;

import com.zglu.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import java.util.Map;

@Component
public class Token {

    @Autowired
    private RoleApi roleApi;

    public boolean check(ServerWebExchange exchange){
        MultiValueMap<String, String> multiValueMap = exchange.getRequest().getQueryParams();
        Integer userId = get(multiValueMap.getFirst("token"));
        System.out.println(roleApi.get(1));
        System.out.println(exchange.getRequest().getMethod());
        System.out.println(exchange.getRequest().getURI().getPath());
        return false;
    }

    public Integer get(String token){
        try {
            Map map = TokenUtil.parserToken(token);
            Integer userId = (Integer)map.get("userId");
            return userId;
        } catch (Exception e) {
            return null;
        }
    }
}
