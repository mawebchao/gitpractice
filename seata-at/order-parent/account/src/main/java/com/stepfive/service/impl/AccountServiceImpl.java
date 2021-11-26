package com.stepfive.service.impl;

import com.stepfive.mapper.AccountMapper;
import com.stepfive.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional
    public void decrease(Long userId, BigDecimal money) {
        accountMapper.decrease(userId,money);
        if (Math.random() < 0.5) {
            throw new RuntimeException("模拟异常");
        }
    }
}
