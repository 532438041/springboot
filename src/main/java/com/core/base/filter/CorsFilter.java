package com.core.base.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description 配置Cors 解决跨域问题
 * @author smallTao.liu
 * @date 2018/6/19 11:17
 * @version V1.0
 */
@WebFilter
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Accept");
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig fConfig) {

    }

    @Override
    public void destroy() {
    }
}
