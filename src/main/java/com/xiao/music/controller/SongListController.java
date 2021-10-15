package com.xiao.music.controller;/**
 * Description: music
 * Created by 28191 on 2021/9/28
 */


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiao.music.pojo.SongList;
import com.xiao.music.service.SongListService;
import com.xiao.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 *@Classname SongListController
 *@Description TODO
 *@Author 28191
 *@DATE 2021/9/28 9:42
 *@version 1.0
 */
@RestController
@RequestMapping("/songList")
public class SongListController {

    @Autowired
    private SongListService songListService;


    /**
     * 添加歌单
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addSongList(@RequestBody SongList SongList){
        JSONObject jsonObject = new JSONObject();
        boolean flag = songListService.myInsert(SongList);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"添加成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"添加失败");
        return jsonObject;
    }

    /**
     * 修改歌单
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updateSongList(@RequestBody SongList songList){
        JSONObject jsonObject = new JSONObject();
        boolean flag = songListService.myUpdate(songList);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"修改失败");
        return jsonObject;
    }


    /**
     * 删除歌单
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object deleteSongList(HttpServletRequest request){
        String id = request.getParameter("id").trim();          //主键
        boolean flag = songListService.myDelete(Integer.parseInt(id));
        return flag;
    }

    /**
     * 根据主键查询整个对象
     */
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public Object selectByPrimaryKey(HttpServletRequest request){
        String id = request.getParameter("id").trim();          //主键
        return songListService.mySelectByPrimaryKey(Integer.parseInt(id));
    }

    /**
     * 查询所有歌单
     */
    @RequestMapping(value = "/allSongList",method = RequestMethod.GET)
    public Object allSongList(HttpServletRequest request){
        return songListService.myAllSongList();
    }

    /**
     * 根据标签精确查询列表
     */
    @RequestMapping(value = "/SongListOfTitle",method = RequestMethod.GET)
    public Object SongListOfName(HttpServletRequest request){
        String title = request.getParameter("title").trim();          //歌单名字
        return songListService.mySongListOfTitle(title);
    }
    /**
     * 根据标签模糊查询列表
     */
    @RequestMapping(value = "/likeTitle",method = RequestMethod.GET)
    public Object likeTitle(HttpServletRequest request){
        String title = request.getParameter("title").trim();          //歌单名字
        return songListService.likeTitle("%"+title+"%");
    }
    /**
     * 根据风格模糊查询列表
     */
    @RequestMapping(value = "/likeStyle",method = RequestMethod.GET)
    public Object likeStyle(HttpServletRequest request){
        String style = request.getParameter("style").trim();          //歌单名字
        return songListService.likeStyle("%"+style+"%");
    }

    /**
     * 根据性别查询
     */
//    @RequestMapping(value = "/SongListOfSex",method = RequestMethod.GET)
//    public Object SongListOfSex(HttpServletRequest request){
//        String sex = request.getParameter("sex").trim();          //性别
//        return SongListService.SongListOfSex(Integer.parseInt(sex));
//    }




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
                              @RequestParam(defaultValue = "")String search ){
        LambdaQueryWrapper<SongList> wrapper = Wrappers.<SongList>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(SongList::getTitle, search);
        }

        Page<SongList> SongListPage = songListService.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return SongListPage;
    }
    /**
     * 更新歌手图片
     */
    @RequestMapping(value = "/updateSongListPic",method = RequestMethod.POST)
    public Object updateSongListPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id")int id){
        JSONObject jsonObject = new JSONObject();
        if(avatorFile.isEmpty()){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"文件上传失败");
            return jsonObject;
        }
        //文件名=当前时间到毫秒+原来的文件名
        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
        //文件路径
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                +System.getProperty("file.separator")+"SongListPic";
        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库里的相对文件地址
        String storeAvatorPath = "/img/SongListPic/"+fileName;
        try {
            avatorFile.transferTo(dest);
            SongList SongList = new SongList();
            SongList.setId(id);
            SongList.setPic(storeAvatorPath);
            boolean flag = songListService.myUpdate(SongList);
            if(flag){
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"上传成功");
                jsonObject.put("pic",storeAvatorPath);
                return jsonObject;
            }
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败");
            return jsonObject;
        } catch (IOException e) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败"+e.getMessage());
        }finally {
            return jsonObject;
        }
    }
}
