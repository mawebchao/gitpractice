package com.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@TableName("Operation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Operation {
    @TableId(type = IdType.AUTO)
    Integer id;
    @TableField("operations")
    String operations;
    @TableField("roleId")
    Integer roleId;
    @TableField("catId")
    Integer catId;
}
