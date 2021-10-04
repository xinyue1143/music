package com.xiao.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiao.music.pojo.Consumer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: music
 * Created by 28191 on 2021/9/26
 */
@Repository
public interface ConsumerMapper extends BaseMapper<Consumer> {

    /**
     * 增加
     */
    public int myInsert(Consumer consumer);

    /**
     * 修改
     */
    public int myUpdate(Consumer consumer);

    /**
     * 删除
     */
    public int myDelete(Integer id);

    /**
     * 根据主键查询整个对象
     */
    public Consumer mySelectByPrimaryKey(Integer id);

    /**
     * 查询所有用户
     */
    public List<Consumer> myAllConsumer();

    /**
     * 验证密码
     */
    public int verifyPassword(String username,String password);

    /**
     * 根据账号查询
     */
    public Consumer getByUsername(String username);


}
