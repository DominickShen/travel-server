package com.example.travel.service;

import com.example.travel.domain.Place;
import com.example.travel.domain.Trader;

import java.util.List;

/**
 * 景点service接口
 */
public interface TraderService {
    /**
     *增加
     */
    public boolean insert(Trader trader);

    /**
     *修改
     */
    public boolean update(Trader trader);

    /**
     * 删除
     */
    public boolean delete(Integer id);

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
