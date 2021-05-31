package shu.jee.grandgallery.controller;


import com.UpYun;
import com.upyun.UpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import shu.jee.grandgallery.entity.data.PictureInfo;
import shu.jee.grandgallery.entity.data.Tags;
import shu.jee.grandgallery.entity.data.User;
import shu.jee.grandgallery.request.CommentReq;
import shu.jee.grandgallery.request.UploadReq;
import shu.jee.grandgallery.request.UserPictureReq;
import shu.jee.grandgallery.response.Response;
import shu.jee.grandgallery.service.PictureService;
import shu.jee.grandgallery.service.TagsService;
import shu.jee.grandgallery.service.UserService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-24
 */
@RestController
@RequestMapping("//picture")
public class PictureController {

    @Autowired
    PictureService pictureService;

    @Autowired
    TagsService tagsService;

    @Autowired
    UserService userService;

    @RequestMapping("/getInfo")
    Response getInfo(Integer pictureId) {
        PictureInfo info = pictureService.getInformation(pictureId);
        if (info == null) return Response.error(null);
        else return Response.success(null,info);
    }

    @RequestMapping("/getTags")
    Response getTags(Integer pictureId) {
        Map<String,Object> qryMap = new HashMap<>();
        qryMap.put("picture_id",pictureId);
        List<Tags> tags = tagsService.listByMap(qryMap);
        List<String> tagNames = new ArrayList<>();
        for (Tags tag:tags) {
            tagNames.add(tag.getTagName());
        }
        return Response.success(null,tagNames);
    }

    @RequestMapping("/getPictures")
    Response getPictures(String category,Integer page,String method) {
        if (method == null)
            return Response.success(null,pictureService.getPictures(category,page,"picture_id","asc"));
        else if (method.equals("latest"))
            return Response.success(null,pictureService.getPictures(category,page,"publish_time","desc"));
        else if (method.equals("hottest"))
            return Response.success(null,pictureService.getPictures(category,page,"view_time","desc"));
        else
            return Response.success(null,pictureService.getPictures(category,page,"picture_id","asc"));

    }

    @RequestMapping("/comment")
    Response doComment(@RequestBody CommentReq req) {
        if (pictureService.doComment(req.getUserId(),req.getPictureId(),req.getContent())) {
            return Response.success(null);
        }
        else {
            return Response.error(null);
        }
    }

    @RequestMapping("/likePicture")
    Response likePicture(@RequestBody UserPictureReq req) {
        pictureService.likePicture(req.getUserId(), req.getPictureId());
        return Response.success(null);
    }

    @RequestMapping("/dislikePicture")
    Response dislikePicture(@RequestBody UserPictureReq req) {
        pictureService.dislikePicture(req.getUserId(), req.getPictureId());
        return Response.success(null);
    }

    @RequestMapping("/favouritePicture")
    Response favouritePicture(@RequestBody UserPictureReq req) {
        pictureService.favouritePicture(req.getUserId(), req.getPictureId());
        return Response.success(null);
    }

    @RequestMapping("/disFavouritePicture")
    Response disFavouritePicture(@RequestBody UserPictureReq req) {
        pictureService.disFavouritePicture(req.getUserId(), req.getPictureId());
        return Response.success(null);
    }

    @RequestMapping("/getComment")
    Response getComment(Integer pictureId) {
        return Response.success(null,pictureService.getComment(pictureId));
    }

    @RequestMapping("/getPublisher")
    Response getPublisher(Integer pictureId) {
        PictureInfo pictureInfo = pictureService.getInformation(pictureId);
        Integer publisherId = pictureInfo.getUploaderId();
        return Response.success(null,userService.getBasicInfo(publisherId));
    }

    @PostMapping("/uploadPicture")
    Response uploadPicture(MultipartFile file,String picturename,String categoryname,String description,Integer userid) throws IOException, UpException {
        PictureInfo pictureInfo=new PictureInfo();
        pictureInfo.setPictureName(picturename);
        pictureInfo.setDescription(description);
        pictureInfo.setCategoryName(categoryname);
        pictureInfo.setUploaderId(userid);
        UpYun upYun=new UpYun("grandgallery-image","zjh","Sb1GzBevRLbpcG2WsfOp5JFmmQrQOTLn");
        String filename=file.getOriginalFilename()+ UUID.randomUUID().toString()+".jpg";
        pictureInfo.setPictureUrl("http://job-imags.test.upcdn.net/"+filename);
        System.out.println("图片名称："+filename);
        boolean re = upYun.writeFile(filename,file.getBytes(),false);
        pictureService.addPicture(pictureInfo);
        return Response.success(null);
    }


}

