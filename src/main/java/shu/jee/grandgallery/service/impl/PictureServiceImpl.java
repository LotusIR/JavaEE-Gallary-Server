package shu.jee.grandgallery.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import org.springframework.beans.factory.annotation.Autowired;
import shu.jee.grandgallery.entity.data.Comment;
import shu.jee.grandgallery.entity.data.Picture;
import shu.jee.grandgallery.entity.data.PictureInfo;
import shu.jee.grandgallery.mapper.TCommentMapper;
import shu.jee.grandgallery.mapper.TPictureMapper;
import shu.jee.grandgallery.mapper.params.PictureParams;
import shu.jee.grandgallery.service.PictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-24
 */
@Service
public class PictureServiceImpl extends ServiceImpl<TPictureMapper, Picture> implements PictureService {

    @Autowired
    TCommentMapper commentMapper;

    @Override
    public PictureInfo getInformation(Integer pictureId) {
        return getBaseMapper().getInfo(pictureId);
    }

    @Override
    public List<PictureInfo> getPictures(String category, Integer page, String orderBy, String order) {
        Integer numPerPage = 20;
        return getBaseMapper().getPictures(new PictureParams(category,numPerPage*(page-1),numPerPage*page,orderBy,order));
    }

    @Override
    public boolean doComment(Integer userId, Integer pictureId, String content) {
        return commentMapper.doComment(userId,pictureId,content) > 0;
    }

    @Override
    public List<Comment> getComment(Integer pictureId) {
        Map<String,Object> qryMap = new HashMap<>();
        qryMap.put("picture_id",pictureId);
        return commentMapper.selectByMap(qryMap);
    }

    @Override
    public void likePicture(Integer userId, Integer pictureId) {
        this.getBaseMapper().likePicture(userId, pictureId);
    }

    @Override
    public void dislikePicture(Integer userId, Integer pictureId) {
        this.getBaseMapper().dislikePicture(userId,pictureId);
    }

    @Override
    public void favouritePicture(Integer userId, Integer pictureId) {
        this.getBaseMapper().favouritePicture(userId,pictureId);
    }

    @Override
    public void disFavouritePicture(Integer userId, Integer pictureId) {
        this.getBaseMapper().disFavouritePicture(userId, pictureId);
    }


}
