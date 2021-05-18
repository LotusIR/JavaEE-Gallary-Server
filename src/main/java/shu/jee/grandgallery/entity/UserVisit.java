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
  @TableName("user_visit")
public class UserVisit implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    @TableField("visit_num")
      private Integer visitNum;

    @TableField("user_id")
    private Integer userId;

    @TableField("picture_id")
    private Integer pictureId;

    @TableField("visit_time")
    private LocalDateTime visitTime;


}
