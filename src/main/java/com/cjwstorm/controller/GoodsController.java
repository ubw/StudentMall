package com.cjwstorm.controller;

import com.cjwstorm.bean.Goods;
import com.cjwstorm.bean.GoodsCategory;
import com.cjwstorm.service.IGoodsCategoryService;
import com.cjwstorm.service.IGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController{

    @Resource(name = "goodsService")
    private IGoodsService goodsService;

    @RequestMapping("/list.do")
    public String list(Integer categoryId, Integer orderById, Integer page, ModelMap modelMap){
        if (categoryId == null || categoryId <= 0){
            return "error";
        }
        String orderField = null;
        if (orderById == null || orderById < 0 || orderById >=3){
            orderField = IGoodsService.ORDER_BY_FIELD[0];
        } else {
            orderField = IGoodsService.ORDER_BY_FIELD[orderById];
        }

        if (page == null){
            page = 1;
        }

        List<Goods> goodsList = goodsService.findGoodsListByCategoryId(categoryId, orderField, page);
        Integer goodsCount = goodsService.getCountsByCategoryId(categoryId);

        //返回给前端商品列表，每页展示数目，页数，总数,当前页
        modelMap.addAttribute("goodsList", goodsList);
        modelMap.addAttribute("goodsCount", goodsCount);
        Integer pageNum = goodsCount/IGoodsService.PER_PAGE_COUNT;
        pageNum += (goodsCount%IGoodsService.PER_PAGE_COUNT == 0)?0:1;
        modelMap.addAttribute("pageNum", pageNum);
        modelMap.addAttribute("per_page_count)", IGoodsService.PER_PAGE_COUNT);
        modelMap.addAttribute("currentPage", page);


        return "goods_list";
    }

    @RequestMapping("showDetail.do")
    public  String showGoodsDetail(@RequestParam(value="id", required = true)Integer id, ModelMap modelMap){
        Goods goods = goodsService.findGoodsById(id);
        List<Goods>  goodsList = goodsService.findGoodsListByItemType(goods.getItemType());

        modelMap.addAttribute("goods", goods);
        modelMap.addAttribute("goodsList", goodsList);

        System.out.println("商品详情:"+goods);
        System.out.println("商品详情:"+goodsList);

        return "product_details";
    }
}
