package com.example.travel.domain;


import lombok.Data;

import java.io.Serializable;

@Data
public class Rank implements Serializable{
    private Integer id;
    private Integer placeListId;
    private Integer consumerId;
    private Integer score;

}
