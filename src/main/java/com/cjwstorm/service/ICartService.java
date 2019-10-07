package com.cjwstorm.service;

import com.cjwstorm.bean.Cart;

import java.util.List;

public interface ICartService {
    void addToCart(Cart cart);
    Integer updateNumber(Integer uid, Integer goodsId, Integer adjustNumber);
    Integer findNumber(Integer uid, Integer goodsId);
    List<Cart> findCartList(Integer uid);
    List<Cart> findCartListByUidAndGoodsIds(Integer uid, List<Integer> goodsIds);
}
