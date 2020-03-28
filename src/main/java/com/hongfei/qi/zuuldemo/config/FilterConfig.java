package com.hongfei.qi.zuuldemo.config;

import com.hongfei.qi.zuuldemo.filter.ErrorFilter;
import com.hongfei.qi.zuuldemo.filter.IPFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    /*@Bean
    public IPFilter ipFilter(){
        return new IPFilter();
    }*/

    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }
}
