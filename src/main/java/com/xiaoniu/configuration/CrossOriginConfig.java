package com.xiaoniu.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lhj
 * @date 2019/12/11 21:16
 */
@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
//                .allowedMethods("*")
                .allowedMethods("GET","POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
