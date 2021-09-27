package com.xiao.music.config;/**
 * Description: music
 * Created by 28191 on 2021/9/26
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *@Classname WebMvcConfig  解决跨域问题
 *@Description TODO
 *@Author 28191
 *@DATE 2021/9/26 15:03
 *@version 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true);

    }
}
