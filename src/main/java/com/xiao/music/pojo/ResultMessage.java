package com.xiao.music.pojo;/**
 * Description: music
 * Created by 28191 on 2021/10/18
 */

/**
 *@Classname ResultMessage 服务器发送给浏览器的websocket数据
 *@Description TODO
 *@Author 28191
 *@DATE 2021/10/18 11:53
 *@version 1.0
 */
public class ResultMessage {
    private boolean isSystem;

    private String fromName;

    private Object message;

    public boolean isSystem() {
        return isSystem;
    }

    public void setIsSystem(boolean isSystem) {
        this.isSystem = isSystem;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
