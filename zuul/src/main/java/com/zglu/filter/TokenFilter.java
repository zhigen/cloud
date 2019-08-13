package com.zglu.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.zglu.result.Result;
import com.zglu.service.SysApi;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class TokenFilter extends ZuulFilter {

    @Autowired
    private SysApi sysApi;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        Result result = checkToken(request);
        if (!result.ifSuccess()) {
            requestContext.setResponseBody(JSON.toJSONString(result));
        }
        return null;
    }

    public Result checkToken(HttpServletRequest request) {
        //校验权限
        String url = request.getRequestURI();
        String method = request.getMethod();
        String token = request.getHeader("token");
        return sysApi.get(url, method, token);
    }
}