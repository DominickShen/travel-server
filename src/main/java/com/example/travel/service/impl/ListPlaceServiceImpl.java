package com.example.travel.service.impl;

import com.example.travel.dao.ListPlaceMapper;
import com.example.travel.domain.ListPlace;
import com.example.travel.service.ListPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPlaceServiceImpl implements ListPlaceService {
    @Autowired
    private ListPlaceMapper listPlaceMapper;


    @Override
    public boolean insert(ListPlace listPlace) {
        return listPlaceMapper.insert(listPlace)>0;
    }

    @Override
    public boolean update(ListPlace listPlace) {
        return listPlaceMapper.update(listPlace)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return listPlaceMapper.delete(id)>0;
    }

    @Override
    public boolean deleteByPlaceIdAndPlaceListId(Integer placeId, Integer placeListId) {
        return listPlaceMapper.deleteByPlaceIdAndPlaceListId(placeId,placeListId)>0;
    }

    @Override
    public ListPlace selectByPrimaryKey(Integer id) {
        return listPlaceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ListPlace> allListPlace() {
        return listPlaceMapper.allListPlace();
    }

    @Override
    public List<ListPlace> listPlaceOfPlaceListId(Integer placeListId) {
        return listPlaceMapper.listPlaceOfPlaceListId(placeListId);
    }
}
