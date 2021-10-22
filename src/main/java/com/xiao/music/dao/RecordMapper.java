package com.xiao.music.dao;

import com.xiao.music.pojo.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: music
 * Created by 28191 on 2021/10/20
 */
@Repository
public interface RecordMapper {

    public int insert(Record record);

    public int selectRecordNum();

    public List<Record> selectRecordByUsers(String firstUser,String secondUser);
}
