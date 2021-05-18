package shu.jee.grandgallery.service;

import shu.jee.grandgallery.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-18
 */
public interface UserService extends IService<User> {

    boolean checkPassword(Integer userId,String userPassword);

}
