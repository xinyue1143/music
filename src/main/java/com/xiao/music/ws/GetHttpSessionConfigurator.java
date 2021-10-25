package com.xiao.music.ws;/**
 * Description: music
 * Created by 28191 on 2021/10/18
 */


import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import java.util.List;
import java.util.Map;

/**
 *@Classname GetHttpSessionConfigurator
 *@Description TODO
 *@Author 28191
 *@DATE 2021/10/18 16:35
 *@version 1.0
 */
public class GetHttpSessionConfigurator extends ServerEndpointConfig.Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        Map<String, List<String>> headers = request.getHeaders();
//        List<String> authorization = headers.get("Authorization");
        System.out.println(headers);
        //将HttpSession对象存储到配置对象中
        sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
    }
}
