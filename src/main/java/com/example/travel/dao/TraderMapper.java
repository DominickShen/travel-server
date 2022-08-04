package com.example.travel.dao;

import com.example.travel.domain.Place;
import com.example.travel.domain.Trader;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商家Dao
 */
@Repository
public interface TraderMapper {
    /**
     *增加
     */
    public int insert(Trader trader);

    /**
     *修改
     */
    public int update(Trader trader);

    /**
     * 删除
     */
    public int delete(Integer id);

    /**
     * 根据主键查询整个对象
     */
    public Trader selectByPrimaryKey(Integer id);

    /**
     * 查询所有景点
     */
    public List<Trader> allTrader();

    /**
     * 根据景点名精确查询列表
     */
    public List<Trader>  traderOfName(String name);

    /**
     * 根据商家id查询
     */
    //public List<Trader> traderOfIntro(String intro);
}
















