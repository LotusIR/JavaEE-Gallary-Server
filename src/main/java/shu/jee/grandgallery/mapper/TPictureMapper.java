package shu.jee.grandgallery.mapper;

import org.apache.ibatis.annotations.Insert;
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

    @Insert("insert into t_picture(picture_name,category_name,user_id,publish_time,picture_url,likes_count,favourites_count,view_time,comment_count,description) values(#{picturename},#{categoryname},#{userId},#{publishtime},#{pictureurl},#{likescount},#{favouritescount},#{viewtime},#{commentcount},#{description})")
    Integer addPicture(String picturename,String categoryname,Integer userId,String publishtime,String pictureurl,Integer likescount,Integer favouritescount,Integer viewtime,Integer commentcount,String description);
}
