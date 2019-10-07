package com.cjwstorm.service;

import com.cjwstorm.bean.*;

import java.util.List;


public interface IOrderService {
    Integer insertOrder(Order order, List<OrderGoodsDtl> orderGoodsDtlList);
}
