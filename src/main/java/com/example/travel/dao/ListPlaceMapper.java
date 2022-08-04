package com.example.travel.dao;

import com.example.travel.domain.ListPlace;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 景点列表里面的景点Dao
 */
@Repository
public interface ListPlaceMapper {
    /**
     *增加
     */
    public int insert(ListPlace listPlace);

    /**
     *修改
     */
    public int update(ListPlace listPlace);

    /**
     * 删除
     */
    public int delete(Integer id);

    /**
     * 根据景点id和景点列表id删除
     */
    public int deleteByPlaceIdAndPlaceListId(@Param("placeId")Integer placeId, @Param("placeListId") Integer placeListId);

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
















