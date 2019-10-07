package com.cjwstorm.service;

import com.cjwstorm.bean.Order;
import com.cjwstorm.bean.OrderGoodsDtl;
import com.cjwstorm.mapper.OrderMapper;
import com.cjwstorm.service.ex.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
    @Resource(name = "orderMapper")
    private  OrderMapper orderMapper;

    @Transactional
    @Override
    public Integer insertOrder(Order order, List<OrderGoodsDtl> orderGoodsDtlList) {

        //插入订单表
        Integer ret = orderMapper.addOrder(order);
        System.out.println("插入订单表失败");
        if (ret != 1){
            throw new ServiceException("插入订单表失败");
        }

        //插入订单商品表
        for (int i = 0; i < orderGoodsDtlList.size(); i++){
            System.out.println("插入订单商品表失败");
            ret = orderMapper.addOrderGoodsDtl(orderGoodsDtlList.get(i));
            if (ret != 1){
                throw new ServiceException("插入订单商品表失败");
            }
        }
        return null;
    }
}
