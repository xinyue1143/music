package com.xiao.music.controller;

import com.alibaba.fastjson.JSONObject;

import com.xiao.music.pojo.Collect;
import com.xiao.music.service.CollectService;
import com.xiao.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 收藏控制类
 */
@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    /**
     * 添加收藏
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addCollect(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String userId = request.getParameter("userId");           //用户id
        String type = request.getParameter("type");               //收藏类型（0歌曲1歌单）
        String songId = request.getParameter("songId");           //歌曲id
        if(songId==null||songId.equals("")){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"收藏歌曲为空");
            return jsonObject;
        }
        if(collectService.existSongId(Integer.parseInt(userId),Integer.parseInt(songId))){
            jsonObject.put(Consts.CODE,2);
            jsonObject.put(Consts.MSG,"已收藏");
            return jsonObject;
        }

        //保存到收藏的对象中
        Collect Collect = new Collect();
        Collect.setUserId(Integer.parseInt(userId));
        Collect.setType(new Byte(type));
        Collect.setSongId(Integer.parseInt(songId));

        boolean flag = collectService.insert(Collect);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"收藏成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"收藏失败");
        return jsonObject;
    }

    /**
     * 查看收藏是否存在
     */
    @RequestMapping(value = "/exist",method = RequestMethod.GET)
    public Object existCollect(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String userId = request.getParameter("userId");           //用户id
        String songId = request.getParameter("songId");           //歌曲id
        if(collectService.existSongId(Integer.parseInt(userId),Integer.parseInt(songId))){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"已收藏");
            return jsonObject;
        }else {
            jsonObject.put(Consts.CODE,2);
            jsonObject.put(Consts.MSG,"还未收藏");
            return jsonObject;
        }
    }

    /**
     * 删除收藏
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object deleteCollect(HttpServletRequest request){
        String userId = request.getParameter("userId");           //用户id
        String songId = request.getParameter("songId");           //歌曲id
        boolean flag = collectService.deleteByUserIdSongId(Integer.parseInt(userId),Integer.parseInt(songId));
        return flag;
    }

    /**
     * 查询所有收藏
     */
    @RequestMapping(value = "/allCollect",method = RequestMethod.GET)
    public Object allCollect(HttpServletRequest request){
        return collectService.allCollect();
    }

    /**
     * 查询某个用户的收藏列表
     */
    @RequestMapping(value = "/collectOfUserId",method = RequestMethod.GET)
    public Object collectOfUserId(HttpServletRequest request){
        String userId = request.getParameter("userId");          //用户id
        return collectService.collectOfUserId(Integer.parseInt(userId));
    }

}






















