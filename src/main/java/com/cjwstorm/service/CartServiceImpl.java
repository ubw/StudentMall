package com.cjwstorm.service;

import com.cjwstorm.bean.Cart;
import com.cjwstorm.mapper.CartMapper;
import com.cjwstorm.service.ex.ServiceException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("cartService")
public class CartServiceImpl implements  ICartService{
    @Resource(name="cartMapper")
    private CartMapper cartMapper;

    @Override
    public void addToCart(Cart cart) {
        //先查询商品该用户是否已经添加到购物车
        Integer count = findNumber(cart.getUid(), cart.getGoodsId());

        if (count == 0) {
            Integer id = cartMapper.add(cart);
            System.out.println(id);

            if (id <= 0) {
                throw new ServiceException("插入购物车异常");
            }
        } else if (count == 1){
            cartMapper.updateNumber(cart.getUid(), cart.getGoodsId(), cart.getGoodsCount());
        } else {
            throw new ServiceException("查询购物车商品数量数据结果异常");
        }
    }

    @Override
    public Integer updateNumber(Integer uid, Integer goodsId, Integer adjustNumber) {
        Integer count = cartMapper.updateNumber(uid, goodsId, adjustNumber);
        if (count != 1){
            throw  new ServiceException("增加购物车数量条件异常");
        }

        return count;
    }

    @Override
    public Integer findNumber(Integer uid, Integer goodsId) {
        return cartMapper.findNumber(uid, goodsId);
    }

    @Override
    public List<Cart> findCartList(Integer uid) {
        return cartMapper.findCartList(uid);
    }

    @Override
    public List<Cart> findCartListByUidAndGoodsIds(Integer uid, List<Integer> goodsIds) {
        return cartMapper.findCartListByUidAndGoodsIds(uid, goodsIds);
    }
}
