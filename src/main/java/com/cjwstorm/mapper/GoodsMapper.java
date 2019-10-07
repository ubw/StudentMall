package com.cjwstorm.mapper;

import com.cjwstorm.bean.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    List<Goods> findGoodsListByCategoryId(@Param("categoryId") Integer categoryId, @Param("orderField") String orderField, @Param("offset") Integer offset,@Param("count") Integer count);
    Integer getCountsByCategoryId(Integer categoryId);
    Goods   findGoodsById(Integer id);
    List<Goods> findGoddsListByItemType(String itemType);
}
