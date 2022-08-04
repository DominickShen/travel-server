package com.example.travel.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.travel.domain.ListPlace;
import com.example.travel.service.ListPlaceService;
import com.example.travel.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 景点列表的景点管理controller
 */
@RestController
@RequestMapping("/listPlace")
public class ListPlaceController {

    @Autowired
    private ListPlaceService listPlaceService;

    /**
     * 给景点列表添加景点
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addListPlace(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        //获取前端传来的参数
        String placeId = request.getParameter("placeId").trim();  //景点id
        String placeListId = request.getParameter("placeListId").trim(); //景点列表id
        ListPlace listPlace = new ListPlace();
        listPlace.setPlaceId(Integer.parseInt(placeId));
        listPlace.setPlaceListId(Integer.parseInt(placeListId));
        boolean flag = listPlaceService.insert(listPlace);
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"保存成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"保存失败");
        return jsonObject;

    }

    /**
     * 根据景点列表id查询景点
     */
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Object detail(HttpServletRequest request){
        String placeListId = request.getParameter("placeListId");
        return listPlaceService.listPlaceOfPlaceListId(Integer.parseInt(placeListId));
    }

    /**
     * 删除景点列表里的景点
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object delete(HttpServletRequest request){
        String placeId = request.getParameter("placeId").trim();                 //景点id
        String placeListId = request.getParameter("placeListId").trim();        //列表id
        boolean flag = listPlaceService.deleteByPlaceIdAndPlaceListId(Integer.parseInt(placeId),Integer.parseInt(placeListId));
        return flag;
    }

}




















