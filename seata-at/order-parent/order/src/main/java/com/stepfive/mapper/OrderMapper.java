package com.stepfive.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stepfive.pojo.Order;

public interface OrderMapper extends BaseMapper<Order> {
    void create(Order order);
}
