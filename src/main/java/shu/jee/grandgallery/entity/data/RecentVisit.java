package shu.jee.grandgallery.entity.data;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

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
  @TableName("t_recent_visit")
public class RecentVisit implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer userId;

    private Integer pictureId;

    private LocalDate visitTime;


}
