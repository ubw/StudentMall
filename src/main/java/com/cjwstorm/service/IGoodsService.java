package com.cjwstorm.service;

import com.cjwstorm.bean.Goods;

import java.util.List;

public interface IGoodsService {
    //接口中定义的成员默认都是用public static final修饰的
    Integer PER_PAGE_COUNT = 20;

    String[] ORDER_BY_FIELD = {"priority desc", "price desc","price asc"};

    //显示主页前3
    List<Goods> findGoodsListByCategoryId();

    List<Goods> findGoodsListByCategoryId(Integer categoryId, String orderField, Integer offset, Integer count);
    List<Goods> findGoodsListByCategoryId(Integer categoryId, String orderField, Integer page);
    List<Goods> findGoodsListByCategoryId(Integer categoryId, Integer page);
    Integer getCountsByCategoryId(Integer categoryId);
    Goods findGoodsById(Integer id);
    List<Goods> findGoodsListByItemType(String itemType);
}
