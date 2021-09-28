package com.xiao.music.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiao.music.pojo.Singer;

import java.sql.Wrapper;
import java.util.List;

/**
 * Description: music
 * Created by 28191 on 2021/9/26
 */
public interface SingerService <T>{

    /**
     *增加
     */
    public boolean insert(Singer singer);

    /**
     *修改
     */
    public boolean update(Singer singer);

    /**
     * 删除
     */
    public boolean delete(Integer id);

    /**
     * 根据主键查询整个对象
     */
    public Singer selectByPrimaryKey(Integer id);

    /**
     * 查询所有歌手
     */
    public List<Singer> allSinger();

    /**
     * 根据歌手名字模糊查询列表
     */
    public List<Singer> singerOfName(String name);

    /**
     * 根据性别查询
     */
    public List<Singer> singerOfSex(Integer sex);

    public Page<Singer> selectPage(Page<Singer> page,LambdaQueryWrapper<Singer> wrapper);
}
