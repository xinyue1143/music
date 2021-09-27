package com.xiao.music.pojo;/**
 * Description: music
 * Created by 28191 on 2021/9/26
 */

import java.io.Serializable;

/**
 *@Classname Admin
 *@Description TODO
 *@Author 28191
 *@DATE 2021/9/26 15:08
 *@version 1.0
 */
public class Admin implements Serializable {

    private Integer id; //主键
    private String name;  //账号
    private String password;    //密码

    public Admin() {
    }

    public Admin(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
