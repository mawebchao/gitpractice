package com.stepfive.tcc;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

import java.math.BigDecimal;

@LocalTCC
public interface StorageTccAction {
    @TwoPhaseBusinessAction(name = "storageTccAction", commitMethod = "commit", rollbackMethod = "rollback")
    boolean prepareCreateOrder(BusinessActionContext businessActionContext,
                               @BusinessActionContextParameter(paramName = "productId") Long productId,
                               @BusinessActionContextParameter(paramName = "count") Integer count);

    // 第二阶段 - 提交
    boolean commit(BusinessActionContext businessActionContext);

    // 第二阶段 - 回滚
    boolean rollback(BusinessActionContext businessActionContext);
}
