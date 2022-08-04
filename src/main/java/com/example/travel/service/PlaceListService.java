package com.example.travel.service;

import com.example.travel.domain.PlaceList;

import java.util.List;

public interface PlaceListService {
    /**
     *增加
     */
    public boolean insert(PlaceList placeList);

    /**
     *修改
     */
    public boolean update(PlaceList placeList);

    /**
     * 删除
     */
    public boolean delete(Integer id);

    /**
     * 根据主键查询整个对象
     */
    public PlaceList selectByPrimaryKey(Integer id);

    /**
     * 查询所有景点
     */
    public List<PlaceList> allPlaceList();

    /**
     * 根据标题精确查询景点列表
     */
    public List<PlaceList> placeListOfTitle(String title);

    /**
     * 根据标题模糊查询景点列表
     */
    public List<PlaceList> likeTitle(String title);

    /**
     * 根据风格模糊查询景点列表
     */
    public List<PlaceList> likeStyle(String style);
}
