package com.example.travel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
* 热更新、热加载
* 1、Ctrl+Shift+A -->搜索registry,找到Registry...,注意是带三个点的那个，然后找到compiler.automake.allow.when.app.running，勾选
* 2、执行快捷键Ctrl+F9才进行热加载
*
* */
@SpringBootApplication

@MapperScan("com.example.travel.dao")
@ComponentScan("com.example")
public class TravelApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelApplication.class, args);
    }

}
