package com.stepfive.tcc.impl;

import com.netflix.discovery.converters.Auto;
import com.stepfive.mapper.OrderMapper;
import com.stepfive.pojo.Order;
import com.stepfive.tcc.OrderTccAction;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderTccActionImpl implements OrderTccAction {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public boolean prepareCreateOrder(BusinessActionContext businessActionContext, Long orderId, Long userId, Long productId, Integer count, BigDecimal money) {
        Order order = new Order(orderId, userId, productId, count, money, 0);
        orderMapper.create(order);

        return true;
    }

    @Override
    public boolean commit(BusinessActionContext businessActionContext) {

        // 防止幂等性，如果commit阶段重复执行则直接返回
//        if (ResultHolder.getResult(getClass(), businessActionContext.getXid()) == null) {
//            return true;
//        }

        //Long orderId = (Long) businessActionContext.getActionContext("orderId");
        long orderId = Long.parseLong(businessActionContext.getActionContext("orderId").toString());
        orderMapper.updateStatus(orderId, 1);

        //提交成功是删除标识
//        ResultHolder.removeResult(getClass(), businessActionContext.getXid());
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext businessActionContext) {
        long orderId = Long.parseLong(businessActionContext.getActionContext("orderId").toString());
        orderMapper.deleteById(orderId);
        return true;
    }
}
