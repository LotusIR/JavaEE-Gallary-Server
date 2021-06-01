package shu.jee.grandgallery.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;
import shu.jee.grandgallery.entity.data.Comment;
import shu.jee.grandgallery.entity.data.Picture;
import shu.jee.grandgallery.entity.data.PictureInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-24
 */
public interface PictureService extends IService<Picture> {

    PictureInfo getInformation(Integer pictureId);

    List<Picture> getPictures(Integer uploaderId, String categoryName, String orderBy, String order, Integer page);

    boolean doComment(Integer userId,Integer pictureId,String content);

    List<Comment> getComment(Integer pictureId);

    void likePicture(Integer userId,Integer pictureId);

    void dislikePicture(Integer userId,Integer pictureId);

    void favouritePicture(Integer userId,Integer pictureId);

    void disFavouritePicture(Integer userId,Integer pictureId);

    void addPicture(PictureInfo pi);
}
