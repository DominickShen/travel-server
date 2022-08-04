package com.example.travel.service;

import com.example.travel.domain.Place;


import java.util.List;

/**
 * 景点service接口
 */
public interface PlaceService {
    /**
     *增加
     */
    public boolean insert(Place place);

    /**
     *修改
     */
    public boolean update(Place place);

    /**
     * 删除
     */
    public boolean delete(Integer id);

    /**
     * 根据主键查询整个对象
     */
    public Place selectByPrimaryKey(Integer id);

    /**
     * 查询所有景点
     */
    public List<Place> allPlace();

    /**
     * 根据景点名精确查询列表
     */
    public List<Place>  placeOfName(String name);

    /**
     * 根据商家id查询
     */
    public List<Place> placeOfTraderId(Integer traderId);

}
