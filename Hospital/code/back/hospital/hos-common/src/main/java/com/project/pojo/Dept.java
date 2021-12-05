package com.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@TableName("dept")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dept {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
}
