package com.jianghaike.ddd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

/**
 * @author jianghaike
 */
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // 允许所有域名进行跨域调用
        config.setAllowedOrigins(Collections.singletonList("*"));
        // 放行全部原始头信息
        config.setAllowedHeaders(Collections.singletonList("*"));
        // 允许所有请求方法跨域调用
        config.setAllowedMethods(Collections.singletonList("*"));
        // 允许跨域发送cookie
        config.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
