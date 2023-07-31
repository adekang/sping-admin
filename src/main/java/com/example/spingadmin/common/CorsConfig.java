package com.example.spingadmin.common;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


//@Configuration
//public class WebConfig  {
//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration config = new CorsConfiguration();
//
//        config.addAllowedOrigin("https://localhost:3000");
//        config.setAllowCredentials(true);
//        config.addAllowedMethod(CorsConfiguration.ALL);
//        config.addAllowedHeader(CorsConfiguration.ALL);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//
//        return new CorsFilter(source);
//    }
//}
