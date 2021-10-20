package com.xiao.music.config;/**
 * Description: music
 * Created by 28191 on 2021/10/18
 */

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 *@Classname WebSocketConfig
 *@Description TODO
 *@Author 28191
 *@DATE 2021/10/18 16:19
 *@version 1.0
 */
@Configuration
public class WebSocketConfig {


    // 注入ServerEndpointExporter bean对象，自动注册使用了@ServerEndpoint注解的bean
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
