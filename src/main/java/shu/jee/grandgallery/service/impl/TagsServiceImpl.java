package shu.jee.grandgallery.service.impl;

import shu.jee.grandgallery.entity.data.Tags;
import shu.jee.grandgallery.mapper.TTagsMapper;
import shu.jee.grandgallery.response.Response;
import shu.jee.grandgallery.service.TagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-24
 */
@Service
public class TagsServiceImpl extends ServiceImpl<TTagsMapper, Tags> implements TagsService {

    @Override
    public List<String> analyzeTagStr(String tagStr) {
        String pattern = "#[\\u4e00-\\u9fa5_a-zA-Z0-9]*";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(tagStr);
        List<String> res = new ArrayList<>();
        while (m.find()) res.add(m.group(0));
        return res;
    }
}
