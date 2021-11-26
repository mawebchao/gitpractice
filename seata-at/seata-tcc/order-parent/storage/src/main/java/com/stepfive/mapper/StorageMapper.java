package com.stepfive.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stepfive.pojo.Storage;
import org.apache.ibatis.annotations.Param;

public interface StorageMapper extends BaseMapper<Storage> {
    void decrease(Long productId, Integer count);

    // 冻结库存
    void updateFrozen(Long productId, Integer count);

    // 提交时，把冻结量修改到已售出
    void updateFrozenToUsed(Long productId, Integer count);

    // 回滚时，把冻结量修改到可用库存
    void updateFrozenToResidue(Long productId, Integer count);
}
