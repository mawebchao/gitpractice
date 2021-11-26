package com.stepfive.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stepfive.pojo.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper extends BaseMapper<Order> {
    void create(Order order);
    //插入冻结状态的订单
    void insertFrozen(Order order);

    void updateStatus(@Param("orderId") Long orderId, @Param("status") Integer status);

    void deleteById(Long orderId);
}
