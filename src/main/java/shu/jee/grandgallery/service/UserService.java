package shu.jee.grandgallery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.v3.oas.models.security.SecurityScheme;
import shu.jee.grandgallery.entity.data.PictureInfo;
import shu.jee.grandgallery.entity.data.RecentVisit;
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

    boolean register(User user);

    User getByUsername(String username);
    
    Integer addHistory(Integer userId,Integer pictureId);

    User getBasicInfo(Integer userId);

    List<PictureInfo> getFavourites(Integer userId);

    List<RecentVisit> getRecentVisit(Integer userId);

    boolean isLikedPicture(Integer userId,Integer pictureId);

    boolean isFavouritePicture(Integer userId,Integer pictureId);

    List<Integer> getFriends(Integer userId);

    boolean addFriend(Integer userId1,Integer userId2);

    boolean deleteFriend(Integer userId1,Integer userId2);

    boolean isFriend(Integer userid1,Integer userid2);
}
