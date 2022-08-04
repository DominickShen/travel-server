package com.example.travel.dao;

import com.example.travel.domain.Place;
import com.example.travel.domain.PlaceList;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlaceListMapper {
    /**
     *增加
     */
    public int insert(PlaceList placeList);

    /**
     *修改
     */
    public int update(PlaceList placeList);

    /**
     * 删除
     */
    public int delete(Integer id);

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
