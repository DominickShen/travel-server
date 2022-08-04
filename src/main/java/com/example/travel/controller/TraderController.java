package com.example.travel.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.travel.domain.Trader;
import com.example.travel.service.TraderService;
import com.example.travel.utils.Consts;
import io.swagger.models.auth.In;
import org.omg.CORBA.TRANSACTION_MODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/trader")
@RestController
public class TraderController {
    @Autowired
    private TraderService traderService;


    /**
     * 添加商家
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addTrader(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name").trim();      //姓名
        String intro=request.getParameter("intro").trim();
        String location=request.getParameter("location").trim();
     
        //保存到商家的对象中
        Trader trader=new Trader();
        trader.setName(name);
        trader.setIntro(intro);
        trader.setLocation(location);
        boolean flag = traderService.insert(trader);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"添加成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"添加失败");
        return jsonObject;
    }

    /**
     * 修改商家
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updateTrader(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();          //主键
        String name = request.getParameter("name").trim();      //姓名
        String intro=request.getParameter("intro").trim();
        String location=request.getParameter("location").trim();
        //保存到商家的对象中
        Trader trader = new Trader();
        trader.setId(Integer.parseInt(id));
        trader.setName(name);
        trader.setIntro(intro);
        trader.setLocation(location);

        boolean flag = traderService.update(trader);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"修改失败");
        return jsonObject;
    }


    /**
     * 删除商家
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object deleteTrader(HttpServletRequest request){
        String id = request.getParameter("id").trim();          //主键
        boolean flag = traderService.delete(Integer.parseInt(id));
        return flag;
    }

    /**
     * 根据主键查询整个对象
     */
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public Object selectByPrimaryKey(HttpServletRequest request){
        String id = request.getParameter("id").trim();          //主键
        return traderService.selectByPrimaryKey(Integer.parseInt(id));
    }

    /**
     * 查询所有商家
     */
    @RequestMapping(value = "/allTrader",method = RequestMethod.POST)
    public Object allTrader(HttpServletRequest request){
        return traderService.allTrader();
    }

    /**
     * 根据商家名字模糊查询列表
     */
    @RequestMapping(value = "/traderOfName",method = RequestMethod.GET)
    public Object traderOfName(HttpServletRequest request){
        String name = request.getParameter("name").trim();          //商家名字
        return traderService.traderOfName("%"+name+"%");
    }

    /**
     * 根据性别查询
//     */
//    @RequestMapping(value = "/singerOfSex",method = RequestMethod.GET)
//    public Object singerOfSex(HttpServletRequest request){
//        String sex = request.getParameter("sex").trim();          //性别
//        return traderService.singerOfSex(Integer.parseInt(sex));
//    }

    /**
     * 更新商家图片
     */
//     @RequestMapping(value = "/updateTraderPic",method = RequestMethod.POST)
//    public Object updateTraderPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id")int id){
//        JSONObject jsonObject = new JSONObject();
//        if(avatorFile.isEmpty()){
//            jsonObject.put(Consts.CODE,0);
//            jsonObject.put(Consts.MSG,"文件上传失败");
//            return jsonObject;
//        }
//        //文件名=当前时间到毫秒+原来的文件名
//        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
//        //文件路径
//        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
//                +System.getProperty("file.separator")+"singerPic";
//        //如果文件路径不存在，新增该路径
//        File file1 = new File(filePath);
//        if(!file1.exists()){
//            file1.mkdir();
//        }
//        //实际的文件地址
//        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
//        //存储到数据库里的相对文件地址
//        String storeAvatorPath = "/img/traderPic/"+fileName;
//        try {
//            avatorFile.transferTo(dest);
//            Trader trader = new Trader();
//            trader.setId(id);
//            trader.setPic(storeAvatorPath);
//            boolean flag = singerService.update(singer);
//            if(flag){
//                jsonObject.put(Consts.CODE,1);
//                jsonObject.put(Consts.MSG,"上传成功");
//                jsonObject.put("pic",storeAvatorPath);
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

}
