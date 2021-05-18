package shu.jee.grandgallery.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import shu.jee.grandgallery.entity.User;
import shu.jee.grandgallery.mapper.UserMapper;
import shu.jee.grandgallery.service.UserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean checkPassword(Integer userId, String userPassword) {
        User user = getById(userId);
        return user.getUserPassword().equals(userPassword);
    }
}
