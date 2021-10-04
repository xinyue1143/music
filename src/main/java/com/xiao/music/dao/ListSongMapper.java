package com.xiao.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiao.music.pojo.ListSong;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: music 歌单中的歌曲
 * Created by 28191 on 2021/9/29
 */
@Repository
public interface ListSongMapper extends BaseMapper<ListSong> {
    /**
     *增加
     */
    public int myInsert(ListSong listSong);

    /**
     *修改
     */
    public int myUpdate(ListSong listSong);

    /**
     * 删除
     */
    public int myDelete(Integer id);

    /**
     * 根据歌曲id和歌单id删除
     */
    public int myDeleteBySongIdAndSongListId(Integer songId,Integer songListId);

    /**
     * 根据主键查询整个对象
     */
    public ListSong mySelectByPrimaryKey(Integer id);

    /**
     * 查询所有的歌单中的歌曲
     */
    public List<ListSong> myAllListSong();


    /**
     * 根据歌单id查询其所有的歌曲
     */
    public List<ListSong> myListSongOfSongListId(Integer songListId);
}


