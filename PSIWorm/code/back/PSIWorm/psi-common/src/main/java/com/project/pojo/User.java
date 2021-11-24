package com.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.List;

@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Component
public class User {
    @TableId(type = IdType.AUTO)
    Integer id;
    String username;
    String password;
    @TableField("role_ids")
    String roleIds;
}
