package com.xiao.music.pojo;/**
 * Description: music
 * Created by 28191 on 2021/10/2
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 *@Classname ListSong 歌曲歌单
 *@Description TODO
 *@Author 28191
 *@DATE 2021/10/2 10:38
 *@version 1.0
 */
@TableName("list_song")
public class ListSong implements Serializable {

    /*
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /*
     * 歌曲id
     */
    private Integer songId;

    /*
     * 歌单id
     */
    private Integer songListId;

    public ListSong() {
    }

    public ListSong(Integer id, Integer songId, Integer songListId) {
        this.id = id;
        this.songId = songId;
        this.songListId = songListId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getSongListId() {
        return songListId;
    }

    public void setSongListId(Integer songListId) {
        this.songListId = songListId;
    }
}
