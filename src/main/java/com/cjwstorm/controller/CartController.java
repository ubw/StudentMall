package com.cjwstorm.controller;

import com.cjwstorm.bean.Cart;
import com.cjwstorm.bean.ResponseResult;
import com.cjwstorm.service.ICartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{
    @Resource(name="cartService")
    private ICartService cartService;

    @RequestMapping(method = RequestMethod.POST, value = "/add.do")
    @ResponseBody
    public ResponseResult<Void> addToCart(Cart cart, HttpSession session){
        System.out.println("cart:"+cart);
        Integer uid = getUidFromSession(session);
        ResponseResult<Void> ret = null;
        cart.setUid(uid);
        try {
            cartService.addToCart(cart);
            ret = new ResponseResult<>(0, "加入购物车成功");
        }catch (Exception e){
            ret = new ResponseResult<>(-1, e.getMessage());
        }

        return  ret;
    }

    @RequestMapping("list.do")
    public String showCartList(HttpSession session, ModelMap modelMap){
        List<Cart> cartList = cartService.findCartList(getUidFromSession(session));
        modelMap.addAttribute("cartList", cartList);

        System.out.println("cartList test:"+cartList);
        return "cart";
    }

}
