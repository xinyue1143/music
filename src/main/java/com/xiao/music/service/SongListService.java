package com.xiao.music.service;

/**
 * Description: music
 * Created by 28191 on 2021/10/1
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiao.music.pojo.SongList;

import java.util.List;

/**
 * 歌单Service接口
 */
public interface SongListService {


    /**
     *增加
     */
    public boolean myInsert(SongList songList);

    /**
     *修改
     */
    public boolean myUpdate(SongList songList);

    /**
     * 删除
     */
    public boolean myDelete(Integer id);

    /**
     * 根据主键查询整个对象
     */
    public SongList mySelectByPrimaryKey(Integer id);

    /**
     * 查询所有歌单
     */
    public List<SongList> myAllSongList();

    /**
     * 根据标题精确查询列表
     */
    public List<SongList> mySongListOfTitle(String title);

    /**
     * 根据标题模糊查询列表
     */
    public List<SongList> likeTitle(String title);

    /**
     * 根据风格模糊查询列表
     */
    public List<SongList> likeStyle(String style);

    public Page<SongList> selectPage(Page<SongList> page, LambdaQueryWrapper<SongList> wrapper);

}
