package com.cn.stbu.hotel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description:
 * Datetime:    2020/2/26 0026   10:31
 * Author:  IDEA
 */
@Configuration
public class webConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/camera").setViewName("videoTest");
        registry.addViewController("text/v/cap").setViewName("capture");
        registry.addViewController("/").setViewName("index");
    }
}
