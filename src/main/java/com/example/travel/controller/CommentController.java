package com.example.travel.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.travel.domain.Comment;
import com.example.travel.service.CommentService;
import com.example.travel.utils.Consts;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addComment(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String userId = request.getParameter("userId");           //用户id
        String type = request.getParameter("type");               //评论类型（0景点1景点列表）
        String placeId = request.getParameter("placeId");           //景点id
        String placeListId = request.getParameter("placeListId");   //景点列表id
        String content = request.getParameter("content").trim();      //评论内容

        Comment comment = new Comment();
        comment.setUserId(Integer.parseInt(userId));
        comment.setType(new Byte(type));
        if (new Byte(type) == 0) {
            comment.setPlaceId(Integer.parseInt(placeId));
        } else {
            comment.setPlaceListId(Integer.parseInt(placeListId));
        }
        comment.setContent(content);
        boolean flag = commentService.insert(comment);
        if (flag) {   //保存成功
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "评论成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "评论失败");
        return jsonObject;


    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updateComment(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id=request.getParameter("id").trim();
        String userId=request.getParameter("uerId").trim();
        String type = request.getParameter("type").trim();               //评论类型（0景点1景点列表）
        String placeId = request.getParameter("placeId").trim();           //
        String placeListId = request.getParameter("placeListId").trim();   //
        String content = request.getParameter("content").trim();         //评论内容

        Comment comment = new Comment();
        comment.setId(Integer.parseInt(id));
        comment.setUserId(Integer.parseInt(userId));
        comment.setType(new Byte(type));
        if(placeId!=null&&placeId.equals("")){
            placeId = null;
        }else {
            comment.setPlaceId(Integer.parseInt(placeId));
        }
        if(placeListId!=null&&placeListId.equals("")){
            placeListId = null;
        }else {
            comment.setPlaceListId(Integer.parseInt(placeListId));
        }
        comment.setContent(content);

        boolean flag = commentService.update(comment);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"修改失败");
        return jsonObject;


    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object deleteComment(HttpServletRequest request){
        String id=request.getParameter("id");
        boolean delete = commentService.delete(Integer.parseInt(id));
        return delete;
    }
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public Object selectByPrimaryKey(HttpServletRequest request){
        String id = request.getParameter("id").trim();          //主键
        return commentService.selectByPrimaryKey(Integer.parseInt(id));
    }

    /**
     * 查询所有评论
     */
    @RequestMapping(value = "/allComment",method = RequestMethod.GET)
    public Object allComment(HttpServletRequest request){
        return commentService.allComment();
    }

    /**
     * 查询某个景点下的所有评论
     */
    @RequestMapping(value = "/commentOfPlaceId",method = RequestMethod.GET)
    public Object commentOfPlaceId(HttpServletRequest request){
        String placeId = request.getParameter("placeId");          //景点id
        return commentService.commentOfPlaceId(Integer.parseInt(placeId));
    }

    /**
     * 查询某个景点列表下的所有评论
     */
    @RequestMapping(value = "/commentOfPlaceListId",method = RequestMethod.GET)
    public Object commentOfPlaceListId(HttpServletRequest request){
        String placeListId = request.getParameter("placeListId");          //景点id
        return commentService.commentOfPlaceListId(Integer.parseInt(placeListId));
    }

    /**
     * 给某个评论点赞
     */
    @RequestMapping(value = "/like",method = RequestMethod.POST)
    public Object like(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();           //主键
        String up = request.getParameter("up").trim();           //用户id

        //保存到评论的对象中
        Comment comment = new Comment();
        comment.setId(Integer.parseInt(id));
        comment.setUp(Integer.parseInt(up));

        boolean flag = commentService.update(comment);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"点赞成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"点赞失败");
        return jsonObject;
    }
}
