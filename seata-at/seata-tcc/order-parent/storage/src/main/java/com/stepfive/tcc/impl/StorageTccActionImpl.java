package com.stepfive.tcc.impl;

import com.stepfive.mapper.StorageMapper;
import com.stepfive.tcc.StorageTccAction;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StorageTccActionImpl implements StorageTccAction {
    @Autowired
    private StorageMapper storageMapper;
    @Override
    @Transactional
    public boolean prepareCreateOrder(BusinessActionContext businessActionContext,  Long productId, Integer count) {
        storageMapper.updateFrozen(productId, count);
        System.out.println(1/0);
        return true;
    }

    @Override
    @Transactional
    public boolean commit(BusinessActionContext businessActionContext) {
        storageMapper.updateFrozenToUsed(Long.valueOf(businessActionContext.getActionContext("productId")+""), Integer.valueOf(businessActionContext.getActionContext("count")+""));
        return true;
    }

    @Override
    @Transactional
    public boolean rollback(BusinessActionContext businessActionContext) {
        storageMapper.updateFrozenToResidue(Long.valueOf(businessActionContext.getActionContext("productId")+""), Integer.valueOf(businessActionContext.getActionContext("count")+""));
        return true;
    }
}
