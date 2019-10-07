package com.cjwstorm.service;

import com.cjwstorm.bean.GoodsCategory;

import java.util.List;

public interface IGoodsCategoryService {
    List<GoodsCategory> findGoodsCategoryListByParentId(Integer parentId,Integer count);
}
