package shu.jee.grandgallery.service;

import shu.jee.grandgallery.entity.data.Tags;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-24
 */
public interface TagsService extends IService<Tags> {

    List<String> analyzeTagStr(String tagStr);
}
