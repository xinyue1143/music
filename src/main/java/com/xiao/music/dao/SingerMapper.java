package com.xiao.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiao.music.pojo.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: music
 * Created by 28191 on 2021/9/26
 */
@Repository
public interface SingerMapper extends BaseMapper<Singer> {

    /**
     * 增加
     */
    public int insert(Singer singer);

    /**
     * 修改
     */
    public int update(Singer singer);

    /**
     * 删除
     */
    public int delete(Integer id);

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
}
