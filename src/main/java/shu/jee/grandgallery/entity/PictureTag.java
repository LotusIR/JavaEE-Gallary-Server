package shu.jee.grandgallery.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 杨宇辰
 * @since 2021-05-18
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
  @TableName("picture_tag")
public class PictureTag implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    @TableField("tag_id")
      private Integer tagId;

    @TableField("picture_id")
    private Integer pictureId;

    @TableField("tag_name")
    private String tagName;


}
