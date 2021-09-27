package com.xiao.music.service.impl;/**
 * Description: music
 * Created by 28191 on 2021/9/26
 */

import com.xiao.music.dao.AdminMapper;
import com.xiao.music.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Classname AdminServiceImpl
 *@Description TODO
 *@Author 28191
 *@DATE 2021/9/26 15:23
 *@version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean verifyPassword(String username, String password) {
        return adminMapper.verifyPassword(username,password) > 0;
    }
}
