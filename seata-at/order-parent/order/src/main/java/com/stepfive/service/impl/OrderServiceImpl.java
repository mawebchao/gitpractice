package com.stepfive.service.impl;

import com.stepfive.feign.AccountClient;
import com.stepfive.feign.EasyIdGeneratorClient;
import com.stepfive.feign.StorageClient;
import com.stepfive.mapper.OrderMapper;
import com.stepfive.pojo.Order;
import com.stepfive.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    EasyIdGeneratorClient easyIdGeneratorClient;
    @Autowired
    private AccountClient accountClient;
    @Autowired
    private StorageClient storageClient;

    @Override
    public void create(Order order) {
        // TODO: 从全局唯一id发号器获得id，这里暂时随机产生一个 orderId
        Long orderId = Long.valueOf(easyIdGeneratorClient.nextId("order_business"));
        order.setId(orderId);

        orderMapper.create(order);

        // 修改库存
        storageClient.decrease(order.getProductId(), order.getCount());

        // 修改账户余额
        accountClient.decrease(order.getUserId(), order.getMoney());

    }
}
