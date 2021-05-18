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
  @TableName("picture_category")
public class PictureCategory implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    @TableField("category_id")
      private Integer categoryId;

    @TableField("category_name")
    private String categoryName;


}
