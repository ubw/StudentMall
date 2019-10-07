package com.cjwstorm.service;

import com.cjwstorm.bean.GoodsCategory;
import com.cjwstorm.mapper.GoodsCategoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsCategoryService")
public class GoodsCategoryServiceImpl implements IGoodsCategoryService {
    @Resource(name = "goodsCategoryMapper")
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public List<GoodsCategory> findGoodsCategoryListByParentId(Integer parentId, Integer count) {
        List<GoodsCategory> goodsCategoryList = null;
        goodsCategoryList = goodsCategoryMapper.findGoodsCategoryListByParentId(parentId, count);

        return goodsCategoryList;
    }
}
