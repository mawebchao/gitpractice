package com.stepfive.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stepfive.pojo.Account;

import java.math.BigDecimal;

public interface AccountMapper extends BaseMapper<Account> {
    void decrease(Long userId, BigDecimal money);
}
