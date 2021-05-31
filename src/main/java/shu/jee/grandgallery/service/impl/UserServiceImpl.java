package shu.jee.grandgallery.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shu.jee.grandgallery.entity.data.PictureInfo;
import shu.jee.grandgallery.entity.manual.CategoryCnt;
import shu.jee.grandgallery.entity.data.HistoryVisit;
import shu.jee.grandgallery.entity.data.RecentVisit;
import shu.jee.grandgallery.entity.data.User;
import shu.jee.grandgallery.mapper.TPictureMapper;
import shu.jee.grandgallery.mapper.TRecentVisitMapper;
import shu.jee.grandgallery.mapper.TUserMapper;
import shu.jee.grandgallery.service.HistoryVisitService;
import shu.jee.grandgallery.service.PictureService;
import shu.jee.grandgallery.service.RecentVisitService;
import shu.jee.grandgallery.service.UserService;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<TUserMapper, User> implements UserService {

    @Autowired
    HistoryVisitService historyVisitService;

    @Autowired
    RecentVisitService recentVisitService;

    @Autowired
    PictureService pictureService;

    @Autowired
    TPictureMapper pictureMapper;

    List<HistoryVisit> getHistoryVisit(Integer userId) {
        Map<String,Object> qryMap = new HashMap<String,Object>();
        qryMap.put("user_id",userId);
        return historyVisitService.listByMap(qryMap);
    }

    @Override
    public List<RecentVisit> getRecentVisit(Integer userId) {
        Map<String,Object> qryMap = new HashMap<String,Object>();
        qryMap.put("user_id",userId);
        return recentVisitService.listByMap(qryMap);
    }

    @Override
    public boolean isLikedPicture(Integer userId, Integer pictureId) {
        return this.getBaseMapper().likedPicture(userId,pictureId) > 0;
    }

    @Override
    public boolean isFavouritePicture(Integer userId, Integer pictureId) {
        return this.getBaseMapper().isFavourite(userId,pictureId) > 0;
    }

    @Override
    public boolean checkPassword(Integer userId, String password) {
        User user = getById(userId);
        if (user == null) return false;
        else return user.getUserPassword().equals(password);
    }

    @Override
    public List<CategoryCnt> calcRecommendCategories(Integer userId) {
        Integer historyW = 30,recentW = 70;
        List<HistoryVisit> history = getHistoryVisit(userId);
        List<RecentVisit> recent = getRecentVisit(userId);
        Map<String,Integer> cnt = new HashMap<String,Integer>();
        for(HistoryVisit visit:history) {
            String category = visit.getCategoryName();
            Integer times = visit.getHistoryNum();
            if (cnt.containsKey(category))
                cnt.put(category,cnt.get(category)+times*historyW);
            else
                cnt.put(category,times*historyW);
        }
        for(RecentVisit visit:recent) {
            String category = pictureService.getById(visit.getPictureId()).getCategoryName();
            if (cnt.containsKey(category))
                cnt.put(category,cnt.get(category)+recentW);
            else
                cnt.put(category,recentW);
        }
        List< CategoryCnt > res = new ArrayList<>();
        for(Map.Entry<String,Integer> entry:cnt.entrySet()) {
            res.add(new CategoryCnt(entry.getKey(),entry.getValue()));
        }
        res.sort(new Comparator<CategoryCnt>() {
            @Override
            public int compare(CategoryCnt o1, CategoryCnt o2) {
                return o2.getWeight().compareTo(o1.getWeight());
            }
        });
        res = res.subList(0,Math.min(res.size(),10));
        return res;
    }

    @Override
    public boolean register(User user) {
        if (this.getBaseMapper().insert(user) > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public User getByUsername(String username) {
        QueryWrapper<User> qry = new QueryWrapper<>();
        qry.eq("user_name",username);
        return this.getBaseMapper().selectOne(qry);
    }

    @Override
    public Integer addHistory(Integer userId, Integer pictureId) {
        return ((TRecentVisitMapper)recentVisitService.getBaseMapper()).addHistory(userId,pictureId);
    }

    @Override
    public User getBasicInfo(Integer userId) {
        User user = this.getById(userId);
        user.setUserPassword(null);
        return user;
    }

    @Override
    public List<PictureInfo> getFavourites(Integer userId) {
        return pictureMapper.getFavourites(userId);
    }


}
