package shu.jee.grandgallery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import shu.jee.grandgallery.request.UserLoginReq;
import shu.jee.grandgallery.response.Response;
import shu.jee.grandgallery.service.UserService;

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

    @RequestMapping("/login")
    Response login(@RequestBody UserLoginReq req) {
        if (userService.checkPassword(req.getUserId(),req.getPassword())) {
            return Response.success(null);
        }
        else return Response.error(null);
    }

    @RequestMapping("/recommendCategories")
    Response recommendCategories(Integer userId) {
        return Response.success(null,userService.calcRecommendCategories(userId));
    }
}

