package com.example.travel.service.impl;

import com.example.travel.dao.CollectMapper;
import com.example.travel.domain.Collect;
import com.example.travel.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;

    @Override
    public boolean insert(Collect collect) {
        return collectMapper.insert(collect)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean deleteByUserIdPlaceId(Integer userId, Integer placeId) {
        return collectMapper.deleteByUserIdPlaceId(userId,placeId)>0;
    }

    @Override
    public List<Collect> allCollect() {
        return collectMapper.allCollect();
    }

    @Override
    public List<Collect> collectOfUserId(Integer userId) {
        return collectMapper.collectOfUserId(userId);
    }

    @Override
    public boolean existPlaceId(Integer userId, Integer placeId) {
        return collectMapper.existPlaceId(userId,placeId)>0;
    }
}
