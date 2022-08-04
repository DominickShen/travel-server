package com.example.travel.dao;

import com.example.travel.domain.Place;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商家Dao
 */
@Repository
public interface PlaceMapper {
    /**
     *增加
     */
    public int insert(Place place);

    /**
     *修改
     */
    public int update(Place place);

    /**
     * 删除
     */
    public int delete(Integer id);

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
















