package shu.jee.grandgallery.mapper;

import org.apache.ibatis.annotations.Mapper;
import shu.jee.grandgallery.entity.data.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-24
 */
@Mapper
public interface TUserMapper extends BaseMapper<User> {

    Integer likedPicture(Integer userId,Integer pictureId);

    Integer isFavourite(Integer userId,Integer pictureId);
}
