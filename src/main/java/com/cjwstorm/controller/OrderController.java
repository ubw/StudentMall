package com.cjwstorm.controller;


import com.cjwstorm.bean.Address;
import com.cjwstorm.bean.Cart;
import com.cjwstorm.bean.Order;
import com.cjwstorm.service.IAddressService;
import com.cjwstorm.service.ICartService;
import com.cjwstorm.service.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{
    @Resource(name="orderService")
    private IOrderService orderService;

    @Resource(name = "addressService")
    private IAddressService addressService;

    @Resource(name = "cartService")
    private ICartService cartService;

    @RequestMapping(method = RequestMethod.GET, value="/list.do")
    public String showOrderList(@RequestParam("goodsIdParam") String goodsId, ModelMap modelMap, HttpSession session){
        System.out.println("========showOrderList========="+goodsId);
        if (goodsId == null){
            return "error";
        }
        //根据uid找地址
        Integer uid = getUidFromSession(session);
        List<Address> addressList = addressService.getAddressByUid(uid);

        String[] paramArray = goodsId.split(",");
        List<Integer> goodsIds = new ArrayList<>();
        for(int i = 0; i<paramArray.length; i++) {
            goodsIds.add(Integer.valueOf(paramArray[i]));
        }
        System.out.println(goodsIds);
        List<Cart> cartList = cartService.findCartListByUidAndGoodsIds(uid, goodsIds);

        //绑定到前端
        modelMap.addAttribute("cartList", cartList);
        modelMap.addAttribute("addressList", addressList);

        System.out.println("test cartList:"+cartList);
        System.out.println("test addressList:"+addressList);

        return "orderConfirm";
    }
}
