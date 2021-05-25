package shu.jee.grandgallery.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import shu.jee.grandgallery.entity.data.Picture;
import shu.jee.grandgallery.entity.data.PictureInfo;
import shu.jee.grandgallery.mapper.TPictureMapper;
import shu.jee.grandgallery.mapper.params.PictureParams;
import shu.jee.grandgallery.service.PictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;

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

    @Override
    public PictureInfo getInformation(Integer pictureId) {
        return getBaseMapper().getInfo(pictureId);
    }

    @Override
    public List<PictureInfo> getPictures(String category, Integer page, String orderBy, String order) {
        Integer numPerPage = 20;
        return getBaseMapper().getPictures(new PictureParams(category,numPerPage*(page-1),numPerPage*page,orderBy,order));
    }


}
