package com.project.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class CategoryOperationVO {
    Integer id;
    String name;
    List<String> operationList;
    Integer catId;
}
