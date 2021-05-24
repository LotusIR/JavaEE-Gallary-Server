package shu.jee.grandgallery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import shu.jee.grandgallery.entity.manual.CategoryCnt;
import shu.jee.grandgallery.entity.data.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-24
 */
public interface UserService extends IService<User> {

    boolean checkPassword(Integer userId,String password);

    List<CategoryCnt> calcRecommendCategories(Integer userId);
}
