package com.example.travel.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 景点列表里面的景点
 */
@Data
public class ListPlace implements Serializable {

    private Integer id;     //主键

    private Integer placeId; //景点id

    private Integer placeListId; //景点列表id


}
