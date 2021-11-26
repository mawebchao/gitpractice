package com.stepfive.service.impl;

import com.stepfive.mapper.StorageMapper;
import com.stepfive.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;

    @Override
    @Transactional
    public void decrease(Long productId, Integer count) throws Exception {
        storageMapper.decrease(productId,count);
    }
}
