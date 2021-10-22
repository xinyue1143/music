package com.xiao.music.service;

import com.xiao.music.pojo.Record;

import java.util.List;

/**
 * Description: music
 * Created by 28191 on 2021/10/20
 */
public interface RecordService {

    public boolean insert(Record record);

    public int selectRecordNum();

    public List<Record> selectRecordByUsers(String firstUser, String secondUser);

}
