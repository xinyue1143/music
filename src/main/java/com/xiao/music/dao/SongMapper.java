package com.xiao.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiao.music.pojo.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: music
 * Created by 28191 on 2021/9/29
 */
@Repository
public interface SongMapper extends BaseMapper<Song> {
    /**
     *增加
     */
    public int myInsert(Song song);

    /**
     *修改
     */
    public int myUpdate(Song song);

    /**
     * 删除
     */
    public int myDelete(Integer id);

    /**
     * 根据主键查询整个对象
     */
    public Song mySelectByPrimaryKey(Integer id);

    /**
     * 查询所有歌曲
     */
    public List<Song> myAllSong();

    /**
     * 根据歌名精确查询列表
     */
    public List<Song> mySongOfName(String name);

    /**
     * 根据歌名模糊查询列表
     */
    public List<Song> myLikeSongOfName(String name);

    /**
     * 根据歌手id查询
     */
    public List<Song> mySongOfSingerId(Integer singerId);
}


