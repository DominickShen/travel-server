package com.example.travel.service.impl;

import com.example.travel.dao.CommentMapper;
import com.example.travel.domain.Comment;
import com.example.travel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper commentMapper;
    @Override
    public boolean insert(Comment comment) {
        return commentMapper.insert(comment)>0;
    }

    @Override
    public boolean update(Comment comment) {
        return commentMapper.update(comment)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return commentMapper.delete(id)>0;
    }

    @Override
    public Comment selectByPrimaryKey(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Comment> allComment() {
        return commentMapper.allComment();
    }

    @Override
    public List<Comment> commentOfPlaceId(Integer placeId) {
        return commentMapper.commentOfPlaceId(placeId);
    }

    @Override
    public List<Comment> commentOfPlaceListId(Integer placeListId) {
        return commentMapper.commentOfPlaceListId(placeListId);
    }
}
