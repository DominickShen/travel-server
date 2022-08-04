package com.example.travel.service;

import com.example.travel.domain.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectService {
    /**
     *增加
     */
    public boolean insert(Collect collect);

    /**
     * 删除
     */
    public boolean delete(Integer id);

    /**
     * 根据用户id和景点d删除
     */
    public boolean deleteByUserIdPlaceId(@Param("userId") Integer userId, @Param("placeId") Integer placeId);

    /**
     * 查询所有收藏
     */
    public List<Collect> allCollect();

    /**
     * 查询某个用户的收藏列表
     */
    public List<Collect> collectOfUserId(Integer userId);

    /**
     * 查询某个用户是否已经收藏了某个景点列表
     */
    public boolean existPlaceId(@Param("userId") Integer userId, @Param("placeId") Integer placeId);
}
