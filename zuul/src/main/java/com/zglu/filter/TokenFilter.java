package com.zglu.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.zglu.result.Result;
import com.zglu.result.ResultCode;
import com.zglu.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
public class TokenFilter extends ZuulFilter {

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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("token");
        Integer userId = this.get(token);
        if (userId == null) {
            return Result.error(ResultCode.USER_TOKEN_ERROR);
        }
        final String[] url = new String[]{request.getRequestURI()};
        Map map = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        map.forEach((k, v) -> url[0] = url[0].replaceFirst("/" + v, "/{" + k + "}"));

//        User user = userService.get(userId);
//        if (user == null) {
//            return Result.error(ResultCode.USER_NOT_EXIST);
//        }
//        if (!user.getEnable()) {
//            return Result.error(ResultCode.USER_DISABLE);
//        }
//
//        if (!permissionService.check(userId,url[0],request.getMethod())) {
//            return Result.error(ResultCode.ROLE_NOT_PERMISSION);
//        }
        return null;
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
