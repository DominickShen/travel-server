package com.example.travel.service.impl;

import com.example.travel.dao.RankMapper;
import com.example.travel.domain.Rank;
import com.example.travel.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl implements RankService{
    @Autowired
    private RankMapper rankMapper;

    @Override
    public boolean insert(Rank rank) {
        return rankMapper.insert(rank)>0;
    }

    @Override
    public boolean selectScoreSum(Integer songListId) {
        return rankMapper.selectScoreSum(songListId)>0;
    }

    @Override
    public boolean selectRankNum(Integer songListId) {
        return rankMapper.selectRankNum(songListId)>0;
    }

    @Override
    public int rankOfPlaceListId(Integer songListId) {

        int rankNum=rankMapper.selectRankNum(songListId);
        if(rankNum==0){
            return 5;
        }
        return rankMapper.selectScoreSum(songListId)/rankNum;
    }
}
