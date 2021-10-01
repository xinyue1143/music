package com.xiao.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiao.music.pojo.Song;
import com.xiao.music.pojo.SongList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: music
 * Created by 28191 on 2021/9/29
 */
@Repository
public interface SongListMapper extends BaseMapper<SongList> {
    /**
     *增加
     */
    public int myInsert(SongList songList);

    /**
     *修改
     */
    public int myUpdate(SongList songList);

    /**
     * 删除
     */
    public int myDelete(Integer id);

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
    public List<SongList> likeStyle(Integer style);
}


