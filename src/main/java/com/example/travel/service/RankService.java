package com.example.travel.service;

import com.example.travel.domain.Rank;

public interface RankService {
    public boolean insert(Rank rank);


    /**
     * 查询所有景点
     */
    public boolean selectScoreSum(Integer placeListId);

    /**
     * 查总评分人数
     */
    public boolean selectRankNum(Integer placeListId);

    public int rankOfPlaceListId(Integer placeListId);
}
