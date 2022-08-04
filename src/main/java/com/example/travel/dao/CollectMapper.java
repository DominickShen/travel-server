package com.example.travel.dao;

import com.example.travel.domain.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectMapper {
    /**
     *增加
     */
    public int insert(Collect collect);

    /**
     * 删除
     */
    public int delete(Integer id);

    /**
     * 根据用户id和景点d删除
     */
    public int deleteByUserIdPlaceId(@Param("userId") Integer userId, @Param("placeId") Integer placeId);

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
    public int existPlaceId(@Param("userId") Integer userId, @Param("placeId") Integer placeId);
}
