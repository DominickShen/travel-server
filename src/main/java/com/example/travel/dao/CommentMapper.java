package com.example.travel.dao;

import com.example.travel.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {

    /**
     *增加
     */
    public int insert(Comment comment);

    /**
     *修改
     */
    public int update(Comment comment);

    /**
     * 删除
     */
    public int delete(Integer id);

    /**
     * 根据主键查询整个对象
     */
    public Comment selectByPrimaryKey(Integer id);

    /**
     * 查询所有评论
     */
    public List<Comment> allComment();

    /**
     * 查询某个景点下的所有评论
     */
    public List<Comment> commentOfPlaceId(Integer placeId);

    /**
     * 查询某个景点列表下的所有评论
     */
    public List<Comment> commentOfPlaceListId(Integer placeListId);
}
