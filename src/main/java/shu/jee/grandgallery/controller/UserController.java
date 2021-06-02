package shu.jee.grandgallery.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import shu.jee.grandgallery.entity.data.User;
import shu.jee.grandgallery.request.UserLoginReq;
import shu.jee.grandgallery.request.UserPictureReq;
import shu.jee.grandgallery.response.Response;
import shu.jee.grandgallery.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-24
 */
@RestController
@RequestMapping("//user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    Response login(@RequestBody UserLoginReq req) {
        if (userService.checkPassword(req.getUserId(),req.getPassword())) {
            return Response.success(null);
        }
        else return Response.error(null);
    }

    @GetMapping("/recommendCategories")
    Response recommendCategories(Integer userId) {
        return Response.success(null,userService.calcRecommendCategories(userId));
    }

    @PostMapping("/register")
    Response registerUser(@RequestBody User user) {
        if (userService.register(user)) {
            return Response.success(null, userService.getByUsername(user.getUserName()));
        } else {
            return Response.error("用户名已存在");
        }
    }

    @GetMapping("/addHistory")
    Response addHistory(Integer userId,Integer pictureId) {
        userService.addHistory(userId,pictureId);
        return Response.success(null);
    }

    @GetMapping("/getFavourites")
    Response getFavourite(Integer userId) {
        return Response.success(null,userService.getFavourites(userId));
    }

    @GetMapping("/isLike")
    Response isLike(Integer userId,Integer pictureId) {
        return Response.success(null,userService.isLikedPicture(userId,pictureId));
    }

    @GetMapping("/isFavourite")
    Response isFavourite(Integer userId,Integer pictureId) {
        return Response.success(null,userService.isFavouritePicture(userId,pictureId));
    }


    @GetMapping("/getRecent")
    Response getRecent(Integer userId) {
        return Response.success(null,userService.getRecentVisit(userId));
    }


    @GetMapping("/getFriends")
    @ApiOperation("获取userId的所有关注用户")
    Response getFriends(Integer userId) {
        return Response.success(null,userService.getFriends(userId));
    }


    @GetMapping("/addFriend")
    @ApiOperation("userId1关注userId2")
    Response addFriend(Integer userId1,Integer userId2) {
        if (userService.addFriend(userId1, userId2))
            return Response.success("关注成功");
        else return Response.error("已经关注过该用户");
    }

    @GetMapping("/deleteFriend")
    @ApiOperation("userId1取消关注userId2")
    Response deleteFriend(Integer userId1,Integer userId2) {
        if (userService.deleteFriend(userId1, userId2))
            return Response.success("取消关注成功");
        else return Response.error("你没有关注该用户");
    }

    @GetMapping("/isFriend")
    @ApiOperation("userId1是否关注userId2")
    Response isFriend(Integer userID1,Integer userID2){
        if (userService.isFriend(userID1,userID2))
            return Response.success(null,true);
        else
            return  Response.success(null,false);
    }


}

