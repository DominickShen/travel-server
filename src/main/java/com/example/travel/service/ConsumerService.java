package com.example.travel.service;

import com.example.travel.domain.Consumer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConsumerService {
    /**
     *增加
     */
    public boolean insert(Consumer Consumer);

    /**
     *修改
     */
    public boolean update(Consumer Consumer);

    /**
     * 删除
     */
    public boolean delete(Integer id);

    /**
     * 根据主键查询整个对象
     */
    public Consumer selectByPrimaryKey(Integer id);

    /**
     * 查询所有景点
     */
    public List<Consumer> allConsumer();

    /**
     * 根据用户名模糊查询列表
     */
    public boolean verifyPassword(@Param("username")String username, @Param("password")String password);

    public Consumer getByUsername(String username);

}
