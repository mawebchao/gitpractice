package com.project.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("category")
@Accessors(chain = true)
public class Category implements Serializable {
    private static final long serialVersionUID = 6179339236402089813L;
    @TableId("id")
    Integer id;
    String name;
    Byte level;
    @TableField("parent_id")
    Integer parentId;
    @TableField(exist = false)
    List<Category> children;
}
