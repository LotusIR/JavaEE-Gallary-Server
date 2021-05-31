package shu.jee.grandgallery.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import shu.jee.grandgallery.entity.data.Picture;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import shu.jee.grandgallery.entity.data.PictureInfo;
import shu.jee.grandgallery.mapper.params.PictureParams;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-24
 */
@Mapper
public interface TPictureMapper extends BaseMapper<Picture> {

    PictureInfo getInfo(Integer pictureId);

    List<PictureInfo> getPictures(PictureParams params);

    Integer likePicture(Integer userId,Integer pictureId);

    Integer dislikePicture(Integer userId,Integer pictureId);

    Integer favouritePicture(Integer userId,Integer pictureId);

    Integer disFavouritePicture(Integer userId,Integer pictureId);

    List<PictureInfo> getFavourites(Integer userId);
}
