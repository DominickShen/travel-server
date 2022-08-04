package com.example.travel.dao;

import com.example.travel.domain.Consumer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumerMapper {

    /**
     *增加
     */
    public int insert(Consumer Consumer);

    /**
     *修改
     */
    public int update(Consumer Consumer);

    /**
     * 删除
     */
    public int delete(Integer id);

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
    public int verifyPassword(@Param("username")String username, @Param("password")String password);

    public Consumer getByUsername(String username);

}
