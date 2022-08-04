package com.example.travel.service;

import com.example.travel.domain.Comment;

import java.util.List;

public interface CommentService {
    /**
     *增加
     */
    public boolean insert(Comment comment);

    /**
     *修改
     */
    public boolean update(Comment comment);

    /**
     * 删除
     */
    public boolean delete(Integer id);

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
