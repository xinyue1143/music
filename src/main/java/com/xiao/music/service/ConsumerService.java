package com.xiao.music.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiao.music.pojo.Consumer;
import com.xiao.music.pojo.Singer;

import java.util.List;

/**
 * Description: music
 * Created by 28191 on 2021/10/4
 */
public interface ConsumerService {
    /**
     *增加
     */
    public boolean insert(Consumer consumer);

    /**
     *修改
     */
    public boolean update(Consumer consumer);

    /**
     * 删除
     */
    public boolean delete(Integer id);

    /**
     * 根据主键查询整个对象
     */
    public Consumer selectByPrimaryKey(Integer id);

    /**
     * 查询所有用户
     */
    public List<Consumer> allConsumer();

    /**
     * 查看密码是否正确
     */
    public boolean verifyPassword(String username,String password);

    /**
     * 根据账号查询
     */
    public Consumer getByUsername(String username);

    public Page<Consumer> selectPage(Page<Consumer> page, LambdaQueryWrapper<Consumer> wrapper);

}
