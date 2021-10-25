package com.xiao.music.service.impl;/**
 * Description: music
 * Created by 28191 on 2021/10/20
 */

import com.xiao.music.dao.RecordMapper;
import com.xiao.music.pojo.Record;
import com.xiao.music.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Classname RecordServiceImpl
 *@Description TODO
 *@Author 28191
 *@DATE 2021/10/20 11:05
 *@version 1.0
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;

    @Override
    public boolean insert(Record record) {
        return recordMapper.insert(record) > 0;
    }

    @Override
    public int selectRecordNum() {
        return recordMapper.selectRecordNum();
    }

    @Override
    public List<Record> selectRecordByUsers(String firstUser, String secondUser,Integer total) {
        return recordMapper.selectRecordByUsers(firstUser,secondUser,total);
    }
}
