package com.example.travel.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.travel.domain.Place;
import com.example.travel.service.PlaceService;
import com.example.travel.utils.Consts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.beans.IntrospectionException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 景点管理controller
 */
@RestController
@RequestMapping("/place")

public class PlaceController {

    @Autowired
    private PlaceService placeService;
//
//    /**
//     * 添加景点
//     */

    @PostMapping("/add")
    public Object addPlace(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        //获取前端传来的参数

        String name = request.getParameter("name").trim();
        String location = request.getParameter("location").trim();
        String level = request.getParameter("level").trim();
        String intro = request.getParameter("intro").trim();          //简介
        String placePic =  "/img/placePic/1.jpg";   ;
        String details = request.getParameter("details").trim();  //默认图片
        String traderId = request.getParameter("traderId").trim();

            Place place = new Place();
            place.setName(name);
            place.setLocation(location);
            place.setLevel(Integer.parseInt(level));
            place.setIntro(intro);
            place.setPlacePic(placePic);
            place.setDetails(details);
            place.setTraderId(Integer.parseInt(traderId));
            boolean flag = placeService.insert(place);
            if(flag){
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"保存成功");
                return jsonObject;
            }
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"保存失败");
            return jsonObject;

    }
//    @PostMapping("/add")
//    public Object addPlace(HttpServletRequest request, @RequestParam("file")MultipartFile mpFile){
//        JSONObject jsonObject = new JSONObject();
//        //获取前端传来的参数
//
//        String name = request.getParameter("name").trim();
//        String location = request.getParameter("location").trim();
//        String level = request.getParameter("level").trim();
//        String intro = request.getParameter("intro").trim();          //简介
//        String placePic =  "/img/placePic/1.jpg";   ;
//        String details = request.getParameter("details").trim();  //默认图片
//        String traderId = request.getParameter("traderId").trim();     //歌词
//
//        //上传图片
//        if(mpFile.isEmpty()){
//            jsonObject.put(Consts.CODE,0);
//            jsonObject.put(Consts.MSG,"景点上传失败");
//            return jsonObject;
//        }
//        //文件名=当前时间到毫秒+原来的文件名
//        String fileName = System.currentTimeMillis()+mpFile.getOriginalFilename();
//        //文件路径
//        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"place";
//        //如果文件路径不存在，新增该路径
//        File file1 = new File(filePath);
//        if(!file1.exists()){
//            file1.mkdir();
//        }
//        //实际的文件地址
//        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
//        //存储到数据库里的相对文件地址
//        String storeUrlPath = "/img/placePic"+fileName;
//        try {
//            mpFile.transferTo(dest);
//            Place place = new Place();
//            place.setName(name);
//            place.setLocation(location);
//            place.setLevel(Integer.parseInt(level));
//            place.setIntro(intro);
//            place.setPlacePic(placePic);
//            place.setDetails(details);
//            place.setTraderId(Integer.parseInt(traderId));
//            boolean flag = placeService.insert(place);
//            if(flag){
//                jsonObject.put(Consts.CODE,1);
//                jsonObject.put(Consts.MSG,"保存成功");
//                jsonObject.put("avator",storeUrlPath);
//                return jsonObject;
//            }
//            jsonObject.put(Consts.CODE,0);
//            jsonObject.put(Consts.MSG,"保存失败");
//            return jsonObject;
//        } catch (IOException e) {
//            jsonObject.put(Consts.CODE,0);
//            jsonObject.put(Consts.MSG,"保存失败"+e.getMessage());
//        }finally {
//            return jsonObject;
//        }
//    }
//    /**
//     * 根据商家id查询景点
//     */
    @RequestMapping(value = "/trader/detail",method = RequestMethod.GET)
    public Object placeOfTraderId(HttpServletRequest request){
        String traderId = request.getParameter("traderId");
        return placeService.placeOfTraderId(Integer.parseInt(traderId));
    }
//
//    /**
//     * 修改景点
//     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updatePlaced(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();          //主键
        String name = request.getParameter("name").trim();
        String location = request.getParameter("location").trim();
        String level = request.getParameter("level").trim();
        String intro = request.getParameter("intro").trim();          //简介
        String placePic = "/img/placePic/1.jpg";
        String details = request.getParameter("details").trim();  //默认图片

        //保存到商家的对象中
        Place place = new Place();
        place.setId(Integer.parseInt(id));
        place.setName(name);
        place.setLocation(location);
        place.setLevel(Integer.parseInt(level));
        place.setIntro(intro);
        place.setPlacePic(placePic);
        place.setDetails(details);
        boolean flag = placeService.update(place);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"修改失败");
        return jsonObject;
    }

//    /**
//     * 删除景点
//     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object deletePlace(HttpServletRequest request){
        //-TODO 先查询到数据库中对应的文件地址，删除掉它再进行下面的代码
        String id = request.getParameter("id").trim();          //主键
        boolean flag = placeService.delete(Integer.parseInt(id));
        return flag;
    }


    @RequestMapping(value = "/updatePlacePic",method = RequestMethod.POST)
    public Object updatePlacePic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id")int id){
        JSONObject jsonObject = new JSONObject();
        if(avatorFile.isEmpty()){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"文件上传失败");
            return jsonObject;
        }
        //文件名=当前时间到毫秒+原来的文件名
        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
        //文件路径
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                +System.getProperty("file.separator")+"placePic";
        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库里的相对文件地址
        String storeAvatorPath = "/img/placePic/"+fileName;
        try {
            avatorFile.transferTo(dest);
            Place place = new Place();
            place.setId(id);
            place.setPlacePic(storeAvatorPath);
            boolean flag = placeService.update(place);
            if(flag){
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"上传成功");
                jsonObject.put("pic",storeAvatorPath);
                return jsonObject;
            }
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败");
            return jsonObject;
        } catch (IOException e) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败"+e.getMessage());
        }finally {
            return jsonObject;
        }
    }//
//
//    /**
//     * 更新景点
//     */
//    @RequestMapping(value = "/updateSongUrl",method = RequestMethod.POST)
//    public Object updateSongUrl(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id")int id){
//        JSONObject jsonObject = new JSONObject();
//        if(avatorFile.isEmpty()){
//            jsonObject.put(Consts.CODE,0);
//            jsonObject.put(Consts.MSG,"文件上传失败");
//            return jsonObject;
//        }
//        //文件名=当前时间到毫秒+原来的文件名
//        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
//        //文件路径
//        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"song";
//        //如果文件路径不存在，新增该路径
//        File file1 = new File(filePath);
//        if(!file1.exists()){
//            file1.mkdir();
//        }
//        //实际的文件地址
//        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
//        //存储到数据库里的相对文件地址
//        String storeAvatorPath = "/song/"+fileName;
//        try {
//            avatorFile.transferTo(dest);
//            Place place = new Place();
//            place.setId(id);
//            place.setUrl(storeAvatorPath);
//            boolean flag = placeService.update(place);
//            if(flag){
//                jsonObject.put(Consts.CODE,1);
//                jsonObject.put(Consts.MSG,"上传成功");
//                jsonObject.put("avator",storeAvatorPath);
//                return jsonObject;
//            }
//            jsonObject.put(Consts.CODE,0);
//            jsonObject.put(Consts.MSG,"上传失败");
//            return jsonObject;
//        } catch (IOException e) {
//            jsonObject.put(Consts.CODE,0);
//            jsonObject.put(Consts.MSG,"上传失败"+e.getMessage());
//        }finally {
//            return jsonObject;
//        }
//    }

    /**
     * 根据景点id查询景点对象
     */
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Object detail(HttpServletRequest request){
        String placeId = request.getParameter("placeId");
        return placeService.selectByPrimaryKey(Integer.parseInt(placeId));
    }

//    /**
//     * 根据商家id查询景点
//     */
    @RequestMapping(value = "/placeOfPlaceName",method = RequestMethod.GET)
    public Object placeOfPlaceName(HttpServletRequest request){
        String placeName = request.getParameter("placeName");
        List<Place> places = placeService.placeOfName(placeName);
        return places;
    }
    @RequestMapping(value = "/allPlace",method = RequestMethod.GET)
    public Object allPlace(HttpServletRequest request){
        return placeService.allPlace();
    }


}




















