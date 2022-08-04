package com.example.travel.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.travel.domain.Rank;
import com.example.travel.service.RankService;
import com.example.travel.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController

public class RankController {

    @Autowired
    private RankService rankService;
    /**
     * 新增评价
     */
    @RequestMapping(value = "/rank/add",method = RequestMethod.POST)
    public Object add(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String placeListId = request.getParameter("placeListId");
        String consumerId = request.getParameter("consumerId");
        String score = request.getParameter("score");

        Rank rank = new Rank();
        rank.setPlaceListId(Integer.parseInt(placeListId));
        rank.setConsumerId(Integer.parseInt(consumerId));
        rank.setScore(Integer.parseInt(score));
        boolean flag = rankService.insert(rank);
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"评价成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"评价失败");
        return jsonObject;
    }

    /**
     * 计算平均分
     */
    @RequestMapping(value = "/rank",method = RequestMethod.GET)
    public Object rankOfPlaceListId(HttpServletRequest request){
        String placeListId = request.getParameter("placeListId");
        return rankService.rankOfPlaceListId(Integer.parseInt(placeListId));
    }

}
