package com.xiao.music.pojo;/**
 * Description: music
 * Created by 28191 on 2021/10/20
 */

import java.io.Serializable;

/**
 *@Classname Record
 *@Description TODO
 *@Author 28191
 *@DATE 2021/10/20 10:11
 *@version 1.0
 */
public class Record implements Serializable {

    /*主键*/
    private Integer id;
    /*发送者*/
    private String fromName;
    /*接收者*/
    private String toName;
    /*信息*/
    private String message;

    public Record() {
    }

    public Record(Integer id, String fromName, String toName, String message) {
        this.id = id;
        this.fromName = fromName;
        this.toName = toName;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
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
