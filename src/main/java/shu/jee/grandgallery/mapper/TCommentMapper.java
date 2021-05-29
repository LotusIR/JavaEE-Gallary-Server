package shu.jee.grandgallery.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import shu.jee.grandgallery.entity.data.Comment;
import shu.jee.grandgallery.entity.data.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-24
 */
@Mapper
public interface TCommentMapper extends BaseMapper<Comment> {

    Integer doComment(Integer userId,Integer pictureId,String content);
}
