package shu.jee.grandgallery.service.impl;

import shu.jee.grandgallery.entity.data.Category;
import shu.jee.grandgallery.mapper.TCategoryMapper;
import shu.jee.grandgallery.service.CategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<TCategoryMapper, Category> implements CategoryService {

}
