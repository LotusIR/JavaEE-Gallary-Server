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
  @TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    @TableField("user_id")
      private Integer userId;

    @TableField("user_name")
    private String userName;

    @TableField("user_password")
    private String userPassword;

    private String sex;

    private Integer age;

    private String publisher;

    @TableField("user_email")
    private String userEmail;


}
