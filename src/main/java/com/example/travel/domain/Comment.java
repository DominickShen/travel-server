package com.example.travel.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Comment implements Serializable {
    /*主键*/
    private Integer id;
    /*用户id*/
    private Integer userId;
    /*评论类型（0景点1景点列表）*/
    private Byte type;
    /*景点id*/
    private Integer placeId;
    /*景点列表id*/
    private Integer placeListId;
    /*评论内容*/
    private String content;
    /*评论时间*/
    private Date createTime;
    /*评论点赞数*/
    private Integer up;
}
