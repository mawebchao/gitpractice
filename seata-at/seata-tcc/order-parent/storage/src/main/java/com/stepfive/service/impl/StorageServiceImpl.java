package com.stepfive.service.impl;

import com.stepfive.mapper.StorageMapper;
import com.stepfive.service.StorageService;
import com.stepfive.tcc.StorageTccAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;

    @Autowired
    private StorageTccAction storageTccAction;
    @Override
    public void decrease(Long productId, Integer count){
//        storageMapper.decrease(productId,count);
        storageTccAction.prepareCreateOrder(null, productId, count);
    }
}
