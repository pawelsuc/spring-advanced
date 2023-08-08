package com.pawelsuc.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(2)
public class HeaderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse newServletResponse = (HttpServletResponse) servletResponse;
        newServletResponse.addHeader("java", "jest najlepsza!");

        filterChain.doFilter(servletRequest, newServletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
