package com.example.travel.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 景点
 */
@Data

public class Place implements Serializable {
    /*主键*/


    private Integer id;
    //商家id



    private String name;
    /*景点名*/

    private String location;

    private Integer level;
    /*简介*/

    private String intro;

    private String placePic;

    private String details;

    private Integer traderId;

    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;

}
