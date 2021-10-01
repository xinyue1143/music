package com.xiao.music.service.impl;/**
 * Description: music
 * Created by 28191 on 2021/9/28
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiao.music.dao.SingerMapper;
import com.xiao.music.pojo.Singer;
import com.xiao.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Classname SingerServiceImpl
 *@Description TODO
 *@Author 28191
 *@DATE 2021/9/28 9:38
 *@version 1.0
 */
@Service
public class SingerServiceImpl implements SingerService {


    char a = '1';

    @Autowired
    private SingerMapper singerMapper;

    /**
     * 增加
     *
     * @param singer
     */
    @Override
    public boolean insert(Singer singer) {
        return singerMapper.myInsert(singer)>0;
    }

    /**
     * 修改
     *
     * @param singer
     */
    @Override
    public boolean update(Singer singer) {
        return singerMapper.myUpdate(singer)>0;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public boolean delete(Integer id) {
        return singerMapper.myDelete(id)>0;
    }

    /**
     * 根据主键查询整个对象
     *
     * @param id
     */
    @Override
    public Singer selectByPrimaryKey(Integer id) {
        return singerMapper.mySelectByPrimaryKey(id);
    }

    /**
     * 查询所有歌手
     */
    @Override
    public List<Singer> allSinger() {
        return singerMapper.myAllSinger();
    }

    /**
     * 根据歌手名字模糊查询列表
     *
     * @param name
     */
    @Override
    public List<Singer> singerOfName(String name) {
        return singerMapper.mySingerOfName(name);
    }

    /**
     * 根据性别查询
     *
     * @param sex
     */
    @Override
    public List<Singer> singerOfSex(Integer sex) {
        return singerMapper.mySingerOfSex(sex);
    }

    @Override
    public Page<Singer> selectPage(Page page, LambdaQueryWrapper wrapper) {
        return singerMapper.selectPage(page,wrapper);
    }


}
