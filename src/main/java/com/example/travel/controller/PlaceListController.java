package com.example.travel.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.travel.domain.PlaceList;
import com.example.travel.service.PlaceListService;
import com.example.travel.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/placeList")
public class PlaceListController {

    @Autowired
    private PlaceListService placeListService;

    //添加景点
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addPlaceList(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String title = request.getParameter("title").trim();      //标题
        String pic = request.getParameter("pic").trim();        //景点列表图片
        String intro = request.getParameter("intro").trim();//简介
        String style = request.getParameter("style").trim();    //风格

        //保存到景点列表的对象中
        PlaceList placeList = new PlaceList();
        placeList.setTitle(title);
        placeList.setPic(pic);
        placeList.setIntro(intro);
        placeList.setStyle(style);
        boolean flag = placeListService.insert(placeList);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"添加成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"添加失败");
        return jsonObject;
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updatePlaceList(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();          //主键
        String title = request.getParameter("title").trim();      //标题
        String intro = request.getParameter("intro").trim();//简介
        String style = request.getParameter("style").trim();    //风格
        //保存到景点列表的对象中
        PlaceList placeList = new PlaceList();
        placeList.setId(Integer.parseInt(id));
        placeList.setTitle(title);
        placeList.setIntro(intro);
        placeList.setStyle(style);
        boolean flag = placeListService.update(placeList);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"修改失败");
        return jsonObject;
    }

    @RequestMapping(value="/delete",method = RequestMethod.GET)
    public Object deletePlaceList(HttpServletRequest request){
        String id=request.getParameter("id");
        boolean flag = placeListService.delete(Integer.parseInt(id));
        return flag;

    }
    @RequestMapping(value = "/allPlaceList",method = RequestMethod.GET)
    public Object allPlaceList(HttpServletRequest request){
        return placeListService.allPlaceList();
    }
    /**
     * 根据标题精确查询景点列表列表
     */
    @RequestMapping(value = "/placeListOfTitle",method = RequestMethod.GET)
    public Object placeListOfTitle(HttpServletRequest request){
        String title = request.getParameter("title").trim();          //景点列表标题
        return placeListService.placeListOfTitle(title);
    }

    /**
     * 根据标题模糊查询景点列表列表
     */
    @RequestMapping(value = "/likeTitle",method = RequestMethod.GET)
    public Object likeTitle(HttpServletRequest request){
        String title = request.getParameter("title").trim();          //景点列表标题
        return placeListService.likeTitle("%"+title+"%");
    }

    /**
     * 根据风格模糊查询景点列表列表
     */
    @RequestMapping(value = "/likeStyle",method = RequestMethod.GET)
    public Object likeStyle(HttpServletRequest request){
        String style = request.getParameter("style").trim();          //景点列表风格
        return placeListService.likeTitle("%"+style+"%");
    }

    /**
     * 更新景点列表图片
     */
    @RequestMapping(value = "/updatePlaceListPic",method = RequestMethod.POST)
    public Object updatePlaceListPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id")int id){
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
                +System.getProperty("file.separator")+"placeListPic";
        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库里的相对文件地址
        String storeAvatorPath = "/img/placeListPic/"+fileName;
        try {
            avatorFile.transferTo(dest);
            PlaceList placeList = new PlaceList();
            placeList.setId(id);
            placeList.setPic(storeAvatorPath);
            boolean flag = placeListService.update(placeList);
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
    }


}
