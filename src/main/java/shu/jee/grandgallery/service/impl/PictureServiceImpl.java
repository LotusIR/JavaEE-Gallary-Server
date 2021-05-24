package shu.jee.grandgallery.service.impl;

import shu.jee.grandgallery.entity.data.Picture;
import shu.jee.grandgallery.entity.data.PictureInfo;
import shu.jee.grandgallery.mapper.TPictureMapper;
import shu.jee.grandgallery.service.PictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
}
