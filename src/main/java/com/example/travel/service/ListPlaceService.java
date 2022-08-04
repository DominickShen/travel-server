package com.example.travel.service;


import com.example.travel.domain.ListPlace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 景点列表里面的景点service接口
 */
public interface ListPlaceService {
    /**
     *增加
     */
    public boolean insert(ListPlace listPlace);

    /**
     *修改
     */
    public boolean update(ListPlace listPlace);

    /**
     * 删除
     */
    public boolean delete(Integer id);

    /**
     * 根据景点id和景点列表id删除
     */
    public boolean deleteByPlaceIdAndPlaceListId(@Param("placeId") Integer placeId, @Param("placeListId") Integer placeListId);

    /**
     * 根据主键查询整个对象
     */
    public ListPlace  selectByPrimaryKey(Integer id);

    /**
     * 查询所有景点列表里面的景点
     */
    public List<ListPlace> allListPlace();

    /**
     * 根据景点列表id查询所有的景点
     */
    public List<ListPlace> listPlaceOfPlaceListId(Integer placeListId);
}
