package com.stepfive.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stepfive.pojo.Storage;

public interface StorageMapper extends BaseMapper<Storage> {
    void decrease(Long productId, Integer count);
}
