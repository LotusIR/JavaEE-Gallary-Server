package shu.jee.grandgallery.entity.data;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

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
 * @since 2021-05-24
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
  @TableName("t_picture")
public class Picture implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "picture_id", type = IdType.AUTO)
      private Integer pictureId;

    private String pictureName;

    private String categoryName;

    private Integer userId;

    private Date publishTime;


}
