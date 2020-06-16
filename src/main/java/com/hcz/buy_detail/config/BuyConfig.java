package com.hcz.buy_detail.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dragon-king
 * @createdate 2020/6/12 - 9:48
 */
@Configuration
public class BuyConfig {

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }



}
