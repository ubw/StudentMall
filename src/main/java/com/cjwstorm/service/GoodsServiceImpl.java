package com.cjwstorm.service;

import com.cjwstorm.bean.Goods;
import com.cjwstorm.bean.GoodsCategory;
import com.cjwstorm.mapper.GoodsCategoryMapper;
import com.cjwstorm.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {
    @Resource(name = "goodsMapper")
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findGoodsListByCategoryId() {
        return goodsMapper.findGoodsListByCategoryId(163, "priority desc", 0, 3);
    }

    @Override
    public List<Goods> findGoodsListByCategoryId(Integer categoryId, String orderField, Integer offset, Integer count) {
        return goodsMapper.findGoodsListByCategoryId(categoryId, orderField, offset, count);
    }

    @Override
    public List<Goods> findGoodsListByCategoryId(Integer categoryId, String orderField, Integer page) {
        Integer offset = (page-1)*PER_PAGE_COUNT;
        return goodsMapper.findGoodsListByCategoryId(categoryId, orderField, offset, PER_PAGE_COUNT);
    }

    @Override
    public List<Goods> findGoodsListByCategoryId(Integer categoryId, Integer page) {
        Integer offset = (page-1)*PER_PAGE_COUNT;
        return goodsMapper.findGoodsListByCategoryId(categoryId, null, offset, PER_PAGE_COUNT);
    }

    @Override
    public Integer getCountsByCategoryId(Integer categoryId) {
        return goodsMapper.getCountsByCategoryId(categoryId);
    }

    //如果没有商品信息，则会返回null
    @Override
    public Goods findGoodsById(Integer id) {
        return goodsMapper.findGoodsById(id);
    }

    @Override
    public List<Goods> findGoodsListByItemType(String itemType) {
        return goodsMapper.findGoddsListByItemType(itemType);
    }
}
