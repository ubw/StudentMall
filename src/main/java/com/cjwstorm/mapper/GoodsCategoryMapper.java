package com.cjwstorm.mapper;

import com.cjwstorm.bean.GoodsCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryMapper {
    List<GoodsCategory> findGoodsCategoryListByParentId(@Param("parentId") Integer parentId,@Param("count") Integer count);
}
