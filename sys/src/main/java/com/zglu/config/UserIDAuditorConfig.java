package com.zglu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Configuration
public class UserIDAuditorConfig implements AuditorAware<Integer> {

    @Override
    public Optional<Integer> getCurrentAuditor() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getParameter("userId");
        Integer userId = Integer.valueOf(token);
        return Optional.ofNullable(userId);
    }

}