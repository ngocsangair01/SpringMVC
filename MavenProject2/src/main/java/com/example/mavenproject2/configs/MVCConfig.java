package com.example.mavenproject2.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class MVCConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
    }
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setViewClass(JstlView.class);
        resourceViewResolver.setPrefix("/WEB-INF/class/");
        resourceViewResolver.setSuffix(".jsp");
        return resourceViewResolver;
    }
}