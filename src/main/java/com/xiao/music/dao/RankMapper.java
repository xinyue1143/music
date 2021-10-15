package com.xiao.music.dao;

import com.xiao.music.pojo.Rank;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评价Dao
 */
@Repository
public interface RankMapper {
    /**
     *增加
     */
    public int insert(Rank rank);

    /**
     * 查总分
     */
    public int selectScoreSum(Integer songListId);

    /**
     * 查总评分人数
     */
    public int selectRankNum(Integer songListId);
}
















