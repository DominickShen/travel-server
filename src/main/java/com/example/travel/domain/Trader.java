package com.example.travel.domain;


import lombok.Data;

import java.io.Serializable;

@Data
public class Trader implements Serializable {

  private Integer id;
  private String name;
  private String intro;
  private String location;
}
