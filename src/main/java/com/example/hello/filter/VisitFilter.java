package com.example.hello.filter;

import com.example.hello.util.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/4/16 18:21
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
public class VisitFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(VisitFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //System.out.println("=======初始化过滤器=========");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://47.98.163.159");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT,DELETE");

        String ipAddr = IPUtil.getIpAddr((HttpServletRequest) request);

        //long start = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        //System.out.println("filter 耗时：" + (System.currentTimeMillis() - start));

        logger.warn("请求IP地址：" + ipAddr);
    }

    @Override
    public void destroy() {
        //System.out.println("=======销毁过滤器=========");
    }

}