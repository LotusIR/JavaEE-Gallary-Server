package shu.jee.grandgallery.entity.data;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
  @TableName("t_comment")
public class Comment {
    private Integer userId;
    private Integer pictureId;
    private String content;
}
