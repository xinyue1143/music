package com.xiao.music.controller;/**
 * Description: music
 * Created by 28191 on 2021/9/26
 */

import com.alibaba.fastjson.JSONObject;
import com.xiao.music.service.AdminService;
import com.xiao.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *@Classname AdminController
 *@Description TODO
 *@Author 28191
 *@DATE 2021/9/26 15:26
 *@version 1.0
 */
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    //判断是否登录成功
    @PostMapping("admin/login/status")
    public Object loginStatus(HttpServletRequest request, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean flag = adminService.verifyPassword(name,password);
        if (flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"登陆成功");
            session.setAttribute(Consts.NAME,name);
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"登陆失败,用户名或密码错误");
        return jsonObject;
    }
}
