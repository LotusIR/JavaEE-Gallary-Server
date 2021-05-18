package shu.jee.grandgallery.entity;

import java.time.LocalDateTime;
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
  @TableName("picture")
public class Picture implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    @TableField("picture_id")
      private Integer pictureId;

    @TableField("picture_Name")
    private String pictureName;

    @TableField("category_id")
    private Integer categoryId;

    @TableField("user_id")
    private Integer userId;

    @TableField("publish_time")
    private LocalDateTime publishTime;


}
