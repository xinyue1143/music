package com.xiao.music.ws;/**
 * Description: music
 * Created by 28191 on 2021/10/18
 */

import com.xiao.music.utils.MessageUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import com.xiao.music.config.WebSocketConfig;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *@Classname ChatEndpoint
 *@Description TODO
 *@Author 28191
 *@DATE 2021/10/18 16:15
 *@version 1.0
 */
@ServerEndpoint(value = "/chat",configurator = GetHttpSessionConfigurator.class)
@Component
public class ChatEndpoint {

    //用来存储每一个客户端对象对应的ChatEndPoint对象
    private static Map<String,ChatEndpoint> onlineUsers = new ConcurrentHashMap<>();

    //声明session对象，通过该对象可以发送消息给指定用户
    private Session session;

    //声明Httpsession对象，之前保存过用户名
    private HttpSession httpSession;

    @OnOpen
    // 连接建立时被调用
    public void onOpen(Session session, EndpointConfig config){
        //将局部的session对象赋值给成员session
        this.session = session;
        //获取httpSession对象
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        this.httpSession = httpSession;
        //从httpSession对象中获取用户名
        String username = (String) httpSession.getAttribute("username");
        //将当前对象存储到容器中
        onlineUsers.put(username,this);
        //将当前在线的所有用户名推送给所有客户端
        //1.获取消息
        String message = MessageUtils.getMessage(true,null,getNames());
        //2.调用方法进行系统消息的推送
        broadcastAllUsers(message);
    }

    private void broadcastAllUsers(String message){
        try {
            //要将该消息推送给所有的客户端
            Set<String> names = onlineUsers.keySet();
            for(String name : names){
                ChatEndpoint chatEndpoint = onlineUsers.get(name);
                chatEndpoint.session.getBasicRemote().sendText(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Set<String> getNames(){
        return onlineUsers.keySet();
    }

    @OnMessage
    //接收到客户端发送的数据时被调用
    public void onMessage(String message,Session session){

    }

    @OnClose
    //连接关闭时被调用
    public void onClose(Session session){
        System.out.println("连接已关闭");
    }
}
