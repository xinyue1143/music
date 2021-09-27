package com.xiao.music.dao;

import org.springframework.stereotype.Repository;

/**
 * Description: music
 * Created by 28191 on 2021/9/26
 */
@Repository
public interface AdminMapper {
    /*验证密码是否正确*/
    public int verifyPassword(String username,String password);
}
