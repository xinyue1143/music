package com.xiao.music.service.impl;/**
 * Description: music
 * Created by 28191 on 2021/10/2
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiao.music.dao.ListSongMapper;
import com.xiao.music.pojo.ListSong;
import com.xiao.music.pojo.Song;
import com.xiao.music.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Classname ListSongServiceImpl
 *@Description TODO
 *@Author 28191
 *@DATE 2021/10/2 11:07
 *@version 1.0
 */
@Service
public class ListSongServiceImpl implements ListSongService {
    @Autowired
    private ListSongMapper listSongMapper;
    /**
     * 增加
     *
     * @param listSong
     */
    @Override
    public boolean insert(ListSong listSong) {
        return listSongMapper.myInsert(listSong)>0;
    }

    /**
     * 修改
     *
     * @param listSong
     */
    @Override
    public boolean update(ListSong listSong) {
        return listSongMapper.myUpdate(listSong)>0;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public boolean delete(Integer id) {
        return listSongMapper.myDelete(id)>0;
    }

    /**
     * 根据歌曲id和歌单id删除
     */
    @Override
    public boolean deleteBySongIdAndSongListId(Integer songId,Integer songListId){
        return listSongMapper.myDeleteBySongIdAndSongListId(songId,songListId)>0;
    }

    /**
     * 根据主键查询整个对象
     *
     * @param id
     */
    @Override
    public ListSong selectByPrimaryKey(Integer id) {
        return listSongMapper.mySelectByPrimaryKey(id);
    }

    /**
     * 查询所有歌单里面的歌曲
     */
    @Override
    public List<ListSong> allListSong() {
        return listSongMapper.myAllListSong();
    }

    /**
     * 根据歌单id查询所有的歌曲
     *
     * @param songListId
     */
    @Override
    public List<ListSong> listSongOfSongListId(Integer songListId) {
        return listSongMapper.myListSongOfSongListId(songListId);
    }

    @Override
    public Page<ListSong> selectPage(Page<ListSong> page, LambdaQueryWrapper<ListSong> wrapper) {
        return listSongMapper.selectPage(page,wrapper);
    }
}
