package com.xiao.music.controller;/**
 * Description: music
 * Created by 28191 on 2021/9/29
 */

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiao.music.pojo.ListSong;
import com.xiao.music.service.ListSongService;
import com.xiao.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


/**
 *@Classname ListSongController
 *@Description TODO
 *@Author 28191
 *@DATE 2021/9/29 15:59
 *@version 1.0
 */
@RestController
@RequestMapping("/listSong")
public class ListSongController {

    @Autowired
    private ListSongService listSongService;

    /**
     * 添加歌单中的歌曲
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addListSong(ListSong listSong) {
        JSONObject jsonObject = new JSONObject();
        boolean flag = listSongService.insert(listSong);
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "保存成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "保存失败");
        return jsonObject;

    }

    /**
     * 根据歌单id查询歌曲
     */
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Object detail(HttpServletRequest request){
        String songListId = request.getParameter("songListId");
        return listSongService.listSongOfSongListId(Integer.parseInt(songListId));
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/page")
    public Object findPage(@RequestParam(defaultValue = "2")Integer pageNum,
                           @RequestParam(defaultValue = "5")Integer pageSize,
                           @RequestParam(defaultValue = "")String search,
                           Integer songListId ){
        LambdaQueryWrapper<ListSong> wrapper = Wrappers.<ListSong>lambdaQuery();
        wrapper.eq(ListSong::getSongListId,songListId);
        if(StrUtil.isNotBlank(search)){
            wrapper.like(ListSong::getSongId, search);
        }
        Page<ListSong> listSongPage = listSongService.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return listSongPage;
    }


    /**
     * 删除歌曲
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object deleteListSong(HttpServletRequest request){
        String id = request.getParameter("id").trim();          //主键
        boolean flag = listSongService.delete(Integer.parseInt(id));
        return flag;
    }




}
