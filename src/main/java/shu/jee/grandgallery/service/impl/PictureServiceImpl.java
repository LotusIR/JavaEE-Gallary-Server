package shu.jee.grandgallery.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shu.jee.grandgallery.entity.data.Comment;
import shu.jee.grandgallery.entity.data.Picture;
import shu.jee.grandgallery.entity.data.PictureInfo;
import shu.jee.grandgallery.mapper.TCommentMapper;
import shu.jee.grandgallery.mapper.TPictureMapper;
import shu.jee.grandgallery.service.PictureService;
import shu.jee.grandgallery.utils.dateformat;

import java.time.LocalDateTime;
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
    public List<Picture> getPictures(Integer uploaderId,String categoryName,String orderBy,String order,Integer page) {
        Integer numPerPage = 10;
        QueryWrapper<Picture> qry = new QueryWrapper<>();
        if (uploaderId != null)
            qry.eq("user_id",uploaderId);
        if (categoryName != null)
            qry.eq("category_name",categoryName);
        if (order != null && orderBy != null) {
            if (order.equals("ASC")) {
                qry.orderByAsc(orderBy);
            }
            else if (order.equals("DESC")) {
                qry.orderByDesc(orderBy);
            }
        }
        else qry.orderByDesc("view_time");
        return this.page(new Page<>(page,numPerPage),qry).getRecords();
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

    @Override
    public void addPicture(PictureInfo pi) {
        dateformat df=new dateformat();
        LocalDateTime now=LocalDateTime.now();
        pi.setUploaderName(df.localdatetimetostring(now));
        pi.setLikesCount(0);
        pi.setFavouritesCount(0);
        pi.setViewTime(0);
        pi.setCommentCount(0);
        this.getBaseMapper().addPicture(pi.getPictureName(),pi.getCategoryName(),pi.getUploaderId(),pi.getUploaderName(),pi.getPictureUrl(),pi.getLikesCount(),pi.getFavouritesCount(),pi.getViewTime(),pi.getCommentCount(),pi.getDescription());
    }


}
