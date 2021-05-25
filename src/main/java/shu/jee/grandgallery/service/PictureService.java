package shu.jee.grandgallery.service;

import shu.jee.grandgallery.entity.data.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
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

    List<PictureInfo> getPictures(String category,Integer page, String orderBy, String order);
}
