package com.cjwstorm.mapper;

import com.cjwstorm.bean.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    Integer add(Cart cart);
    Integer updateNumber(@Param("uid") Integer uid, @Param("goodsId") Integer goodsId, @Param("adjustNumber") Integer adjustNumber);
    Integer findNumber(@Param("uid") Integer uid, @Param("goodsId") Integer goodsId);
    List<Cart> findCartList(Integer uid);
    List<Cart> findCartListByUidAndGoodsIds(@Param("uid") Integer uid, @Param("goodsIds") List<Integer> goodsIds);
}
