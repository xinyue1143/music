package com.xiao.music.service.impl;/**
 * Description: music
 * Created by 28191 on 2021/10/1
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiao.music.dao.SongListMapper;
import com.xiao.music.pojo.SongList;
import com.xiao.music.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Classname SongListServiceImpl
 *@Description TODO
 *@Author 28191
 *@DATE 2021/10/1 14:22
 *@version 1.0
 */
@Service
public class SongListServiceImpl implements SongListService {

    @Autowired
    private SongListMapper songListMapper;

    /**
     * 增加
     *
     * @param songList
     */
    @Override
    public boolean myInsert(SongList songList) {
        return songListMapper.myInsert(songList) > 0;
    }

    /**
     * 修改
     *
     * @param songList
     */
    @Override
    public boolean myUpdate(SongList songList) {
        return songListMapper.myUpdate(songList) > 0;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public boolean myDelete(Integer id) {
        return songListMapper.myDelete(id) > 0;
    }

    /**
     * 根据主键查询整个对象
     *
     * @param id
     */
    @Override
    public SongList mySelectByPrimaryKey(Integer id) {
        return songListMapper.mySelectByPrimaryKey(id);
    }

    /**
     * 查询所有歌单
     */
    @Override
    public List<SongList> myAllSongList() {
        return songListMapper.myAllSongList();
    }

    /**
     * 根据标题精确查询列表
     *
     * @param title
     */
    @Override
    public List<SongList> mySongListOfTitle(String title) {
        return songListMapper.mySongListOfTitle(title);
    }

    /**
     * 根据标题模糊查询列表
     *
     * @param title
     */
    @Override
    public List<SongList> likeTitle(String title) {
        return songListMapper.likeTitle(title);
    }

    /**
     * 根据风格模糊查询列表
     *
     * @param style
     */
    @Override
    public List<SongList> likeStyle(Integer style) {
        return songListMapper.likeStyle(style);
    }

    @Override
    public Page<SongList> selectPage(Page<SongList> page, LambdaQueryWrapper<SongList> wrapper) {
        return songListMapper.selectPage(page,wrapper);
    }
}
