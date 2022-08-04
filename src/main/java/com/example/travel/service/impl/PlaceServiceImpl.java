package com.example.travel.service.impl;

import com.example.travel.dao.PlaceMapper;
import com.example.travel.domain.Place;
import com.example.travel.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 景点service实现类
 */
@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceMapper placeMapper;

    @Override
    public boolean insert(Place place) {

        return placeMapper.insert(place)>0;
    }

    @Override
    public boolean update(Place place) {
        return placeMapper.update(place)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return placeMapper.delete(id)>0;
    }

    @Override
    public Place selectByPrimaryKey(Integer id) {
        return placeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Place> allPlace() {
        return placeMapper.allPlace();
    }

    @Override
    public List<Place> placeOfName(String name) {
        return placeMapper.placeOfName(name);
    }

    @Override
    public List<Place> placeOfTraderId(Integer traderId) {
        return placeMapper.placeOfTraderId(traderId);
    }
}
