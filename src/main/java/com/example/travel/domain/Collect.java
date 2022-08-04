package com.example.travel.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Collect implements Serializable{
    private Integer id;     //主键
    private Integer userId; //用户id
    private Byte type;      //收藏类型（0景点1景点列表）
    private Integer placeId; //景点id
    private Integer placeListId; //景点列表id
    private Date createTime;    //收藏时间

}
