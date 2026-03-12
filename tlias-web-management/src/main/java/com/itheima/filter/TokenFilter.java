package com.itheima.filter;

import com.itheima.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
@Slf4j
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取请求的URI
        String requestURI = request.getRequestURI();

        // 判断是否为登录请求
        if(requestURI.contains("/login")){
            log.info("登录请求, 放行");
            filterChain.doFilter(request, response);
            return;
        }

        // 获取请求头中的token
        String token = request.getHeader("token");

        // 判断token是否存在, 如果不存在, 说明用户没有登录, 返回错误信息(响应码401)
        if(token == null || token.isEmpty()){
            log.info("令牌为空, 响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // token存在, 校验令牌, 如果校验失败 -> 返回错误信息(响应码401)
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("令牌非法, 响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // 校验通过, 放行
        log.info("令牌合法, 放行");
        filterChain.doFilter(request, response);
    }
}
