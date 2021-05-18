package shu.jee.grandgallery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import shu.jee.grandgallery.response.Response;
import shu.jee.grandgallery.service.UserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-18
 */
@RestController
@RequestMapping("//user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    Response login(Integer userId,String password) {
        if (userService.checkPassword(userId,password)) {
            System.out.println(Response.success((null)));
            return Response.success(null);
        }
        else {
            return Response.error(null);
        }
    }


}

