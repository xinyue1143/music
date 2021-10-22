package com.xiao.music.pojo;/**
 * Description: music
 * Created by 28191 on 2021/10/20
 */

/**
 *@Classname Message
 *@Description TODO
 *@Author 28191
 *@DATE 2021/10/20 16:58
 *@version 1.0
 */
public class Message {

    private String toName;
    private String message;

    public Message() {
    }

    public Message(String toName, String message) {
        this.toName = toName;
        this.message = message;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
