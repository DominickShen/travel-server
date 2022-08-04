package com.example.travel.service.impl;

import com.example.travel.dao.PlaceListMapper;
import com.example.travel.domain.PlaceList;
import com.example.travel.service.PlaceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlaceListServiceImpl implements PlaceListService {
    @Autowired
    private PlaceListMapper placeListMapper;

    @Override
    public boolean insert(PlaceList placeList) {
        return placeListMapper.insert(placeList)>0;
    }

    @Override
    public boolean update(PlaceList placeList) {
        return placeListMapper.update(placeList)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return placeListMapper.delete(id)>0;
    }

    @Override
    public PlaceList selectByPrimaryKey(Integer id) {
        return placeListMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PlaceList> allPlaceList() {
        return placeListMapper.allPlaceList();
    }

    @Override
    public List<PlaceList> placeListOfTitle(String title) {
        return placeListMapper.placeListOfTitle(title);
    }

    @Override
    public List<PlaceList> likeTitle(String title) {
        return placeListMapper.likeTitle(title);
    }

    @Override
    public List<PlaceList> likeStyle(String style) {
        return placeListMapper.likeStyle(style);
    }
}
