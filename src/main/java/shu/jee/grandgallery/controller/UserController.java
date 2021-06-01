package shu.jee.grandgallery.controller;


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
    Response getFriends(Integer userId) {
        return Response.success(null,userService.getFriends(userId));
    }

    @GetMapping("/addFriend")
    Response addFriend(Integer userId1,Integer userId2) {
        userService.addFriend(userId1, userId2);
        return Response.success(null);
    }

    @GetMapping("/deleteFriend")
    Response deleteFriend(Integer userId1,Integer userId2) {
        userService.deleteFriend(userId1, userId2);
        return Response.success(null);
    }
}

