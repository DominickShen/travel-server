package com.example.travel.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 景点列表
 */
@Data
public class PlaceList implements Serializable {
    /*主键*/
    private Integer id;
    /*景点列表标题*/
    private String title;
    /*景点列表图片*/
    private String pic;
    /*简介*/
    private String intro;
    /*风格*/
    private String style;


}
