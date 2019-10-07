package com.cjwstorm.mapper;

import com.cjwstorm.bean.Order;
import com.cjwstorm.bean.OrderGoodsDtl;

import java.util.List;

public interface OrderMapper {
    Integer addOrder(Order order);
    Integer addOrderGoodsDtl(OrderGoodsDtl orderGoodsDtl);
}
