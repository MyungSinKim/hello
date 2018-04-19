package com.example.hello.configuration;

import com.example.hello.filter.VisitFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Standard Redis configuration.
 */
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean visitFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        VisitFilter timeFilter = new VisitFilter();
        registrationBean.setFilter(timeFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }
}