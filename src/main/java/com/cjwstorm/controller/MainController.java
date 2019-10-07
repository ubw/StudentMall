package com.cjwstorm.controller;

import com.cjwstorm.bean.Goods;
import com.cjwstorm.bean.GoodsCategory;
import com.cjwstorm.service.IGoodsCategoryService;
import com.cjwstorm.service.IGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController extends BaseController{

    //基于接口编程？？
    @Resource(name = "goodsCategoryService")
    private IGoodsCategoryService goodsCategoryService;
    @Resource(name="goodsService")
    private IGoodsService goodsService;

    @RequestMapping("/index.do")
    public String goToIndex(ModelMap modelMap){
        List<List<GoodsCategory>> computerLvlThreeList = new ArrayList<>();
        //获取电脑大类商品列表
        List<GoodsCategory> computerLvlTwoList = goodsCategoryService.findGoodsCategoryListByParentId(161, 3);

        //3级子类赋值
        for (GoodsCategory lvlTwoLCategory:computerLvlTwoList){
            List<GoodsCategory> listLvlThreeList = goodsCategoryService.findGoodsCategoryListByParentId(lvlTwoLCategory.getId(), 5);
            computerLvlThreeList.add(listLvlThreeList);
        }

        //返回排名前3的计算机列表
        List<Goods> goodsList = goodsService.findGoodsListByCategoryId();

        modelMap.addAttribute("computerLvlThreeList", computerLvlThreeList);
        modelMap.addAttribute("computerLvlTwoList", computerLvlTwoList);
        modelMap.addAttribute("goodsList", goodsList);

        System.out.println(goodsList);

        return "index";
    }

    @RequestMapping(value = "/demo.do", produces = "image/png")
    @ResponseBody
    public byte[] showDemoPic() {
        System.out.println("show demoPic in");
        String path= "demo.png";
        InputStream in = MainController.class.getClassLoader().getResourceAsStream(path);
        byte[] retByte = null;
        try {
            retByte = new byte[in.available()];
            System.out.println("文件长度是:"+in.available());
            System.out.println(retByte.toString());
            in.read(retByte);
            if (in != null){
                in.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return retByte;
    }
}
